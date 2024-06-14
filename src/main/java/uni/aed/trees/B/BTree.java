package uni.aed.trees.B;

import java.util.Collection;

public class BTree<T extends Comparable<T>> implements ITree<T> {
    private int minKeySize;//keytally min
    private int minChildrenSize;//keytally children min
    private int maxKeySize;//keytally max
    private int maxChildrenSize;//keytally children max
    protected Node<T> root = null;
    private int size = 0;
    
    public BTree() {
    }
    
    public BTree(int m) {
        this.minKeySize = (m/2) - 1;
        this.minChildrenSize = (m/2) ;
        this.maxKeySize = m - 1;
        this.maxChildrenSize = m;
    }

    @Override
    public boolean add(T value) {
        if (root == null) {
            root = new Node<>(null, maxKeySize, maxChildrenSize);
            root.addKey(value);
        } else {
            Node<T> node = root;
            while (node != null) {
                if (node.numberOfChildren() == 0) {
                    node.addKey(value);
                    if (node.numberOfKeys() <= maxKeySize)
                        break;                    
                    // necesita dividirse
                    split(node);
                    break;
                }
                // es menor o igual
                T lesser = node.getKey(0);
                if (value.compareTo(lesser) <= 0) {
                    node = node.getChild(0);
                    continue;
                }
                // es mayor que
                int numberOfKeys = node.numberOfKeys();
                int last = numberOfKeys - 1;
                T greater = node.getKey(last);
                if (value.compareTo(greater) > 0) {
                    node = node.getChild(numberOfKeys);
                    continue;
                }
                // busca nodos internos
                for (int i = 1; i < node.numberOfKeys(); i++) {
                    T prev = node.getKey(i - 1);
                    T next = node.getKey(i);
                    if (value.compareTo(prev) > 0 && value.compareTo(next) <= 0) {
                        node = node.getChild(i);
                        break;
                    }
                }
            }
        }
        size++;
        return true;
    }
    /**
     * El tamaño de la clave del nodo es mayor que maxKeySize, dividido por la mitad.     
     * @param nodeToSplit a split     
     */
    private void split(Node<T> nodeToSplit) {
        Node<T> node = nodeToSplit;
        int numberOfKeys = node.numberOfKeys();
        int medianIndex = numberOfKeys / 2;
        T medianValue = node.getKey(medianIndex);

        Node<T> left = new Node<>(null, maxKeySize, maxChildrenSize);
        for (int i = 0; i < medianIndex; i++)
            left.addKey(node.getKey(i));        
        
        if (node.numberOfChildren() > 0) {
            for (int j = 0; j <= medianIndex; j++) {
                Node<T> c = node.getChild(j);
                left.addChild(c);
            }
        }

        Node<T> right = new Node<>(null, maxKeySize, maxChildrenSize);
        for (int i = medianIndex + 1; i < numberOfKeys; i++)
            right.addKey(node.getKey(i));
        
        if (node.numberOfChildren() > 0) {
            for (int j = medianIndex + 1; j < node.numberOfChildren(); j++) {
                Node<T> c = node.getChild(j);
                right.addChild(c);
            }
        }

        if (node.parent == null) {
            // new root, height del arbol es incrementado
            Node<T> newRoot = new Node<>(null, maxKeySize, maxChildrenSize);
            newRoot.addKey(medianValue);
            node.parent = newRoot;
            root = newRoot;
            node = root;
            node.addChild(left);
            node.addChild(right);
        } else {            
            //Mueve el valor medio hacia el padre
            Node<T> parent = node.parent;
            parent.addKey(medianValue);
            parent.removeChild(node);
            parent.addChild(left);
            parent.addChild(right);

            if (parent.numberOfKeys() > maxKeySize) split(parent);
        }
    }

    @Override
    public T remove(T value) {
        T removed = null;
        Node<T> node = this.getNode(value);
        removed = remove(value,node);
        return removed;
    }
    
    private Node<T> getNode(T value) {
        Node<T> node = root;
        while (node != null) {
            T lesser = node.getKey(0);
            if (value.compareTo(lesser) < 0) {
                if (node.numberOfChildren() > 0)
                    node = node.getChild(0);
                else
                    node = null;
                continue;
            }

            int numberOfKeys = node.numberOfKeys();
            int last = numberOfKeys - 1;
            T greater = node.getKey(last);
            if (value.compareTo(greater) > 0) {
                if (node.numberOfChildren() > numberOfKeys)
                    node = node.getChild(numberOfKeys);
                else
                    node = null;
                continue;
            }

            for (int i = 0; i < numberOfKeys; i++) {
                T currentValue = node.getKey(i);
                if (currentValue.compareTo(value) == 0)
                    return node;                

                int next = i + 1;
                if (next <= last) {
                    T nextValue = node.getKey(next);
                    if (currentValue.compareTo(value) < 0 && nextValue.compareTo(value) > 0) {
                        if (next < node.numberOfChildren()) {
                            node = node.getChild(next);
                            break;
                        }
                        return null;
                    }
                }
            }
        }
        return null;
    }
    
    private T remove(T value, Node<T> node) {
        if (node == null) return null;

        T removed = null;
        int index = node.indexOf(value);
        removed = node.removeKey(value);
        if (node.numberOfChildren() == 0) {
            // leaf node
            if (node.parent != null && node.numberOfKeys() < minKeySize)
                this.combined(node);
            else if (node.parent == null && node.numberOfKeys() == 0)
                // Removing root node with no keys or children
                root = null;            
        } else {
            // internal node
            Node<T> lesser = node.getChild(index);
            Node<T> greatest = this.getGreatestNode(lesser);
            T replaceValue = this.removeGreatestValue(greatest);
            node.addKey(replaceValue);
            if (greatest.parent != null && greatest.numberOfKeys() < minKeySize)
                this.combined(greatest);
            
            if (greatest.numberOfChildren() > maxChildrenSize)
                this.split(greatest);            
        }

        size--;
        return removed;
    }
    
    /**
     * Combined children keys with parent when size is less than minKeySize.     * 
     * @param node  with children to combined.
     * @return True if combined successfully.
     */
    private boolean combined(Node<T> node) {
        Node<T> parent = node.parent;
        int index = parent.indexOf(node);
        int indexOfLeftNeighbor = index - 1;
        int indexOfRightNeighbor = index + 1;

        Node<T> rightNeighbor = null;
        int rightNeighborSize = -minChildrenSize;
        if (indexOfRightNeighbor < parent.numberOfChildren()) {
            rightNeighbor = parent.getChild(indexOfRightNeighbor);
            rightNeighborSize = rightNeighbor.numberOfKeys();
        }

        // Trata de prestarse del nodo vecino
        if (rightNeighbor != null && rightNeighborSize > minKeySize) {
            // Trata de prestarse del nodo vecino derecho
            T removeValue = rightNeighbor.getKey(0);
            int prev = getIndexOfPreviousValue(parent, removeValue);
            T parentValue = parent.removeKey(prev);
            T neighborValue = rightNeighbor.removeKey(0);
            node.addKey(parentValue);
            parent.addKey(neighborValue);
            if (rightNeighbor.numberOfChildren() > 0) {
                node.addChild(rightNeighbor.removeChild(0));
            }
        } else {
            Node<T> leftNeighbor = null;
            int leftNeighborSize = -minChildrenSize;
            if (indexOfLeftNeighbor >= 0) {
                leftNeighbor = parent.getChild(indexOfLeftNeighbor);
                leftNeighborSize = leftNeighbor.numberOfKeys();
            }

            if (leftNeighbor != null && leftNeighborSize > minKeySize) {
                // Trata de prestarse del nodo vecino izquierdo
                T removeValue = leftNeighbor.getKey(leftNeighbor.numberOfKeys() - 1);
                int prev = getIndexOfNextValue(parent, removeValue);
                T parentValue = parent.removeKey(prev);
                T neighborValue = leftNeighbor.removeKey(leftNeighbor.numberOfKeys() - 1);
                node.addKey(parentValue);
                parent.addKey(neighborValue);
                if (leftNeighbor.numberOfChildren() > 0) {
                    node.addChild(leftNeighbor.removeChild(leftNeighbor.numberOfChildren() - 1));
                }
            } else if (rightNeighbor != null && parent.numberOfKeys() > 0) {
                // no puede prestarse de los nodos vecinos, trata de fusionarse con el nodo vecino derecho
                T removeValue = rightNeighbor.getKey(0);
                int prev = getIndexOfPreviousValue(parent, removeValue);
                T parentValue = parent.removeKey(prev);
                parent.removeChild(rightNeighbor);
                node.addKey(parentValue);
                for (int i = 0; i < rightNeighbor.keysSize; i++) {
                    T v = rightNeighbor.getKey(i);
                    node.addKey(v);
                }
                for (int i = 0; i < rightNeighbor.childrenSize; i++) {
                    Node<T> c = rightNeighbor.getChild(i);
                    node.addChild(c);
                }

                if (parent.parent != null && parent.numberOfKeys() < minKeySize)
                    // removing key made parent too small, combined up tree
                    this.combined(parent);
                else if (parent.numberOfKeys() == 0) {
                    // parent no longer has keys, make this node the new root
                    // which decreases the height of the tree
                    node.parent = null;
                    root = node;
                }
            } else if (leftNeighbor != null && parent.numberOfKeys() > 0) {
                // Can't borrow from neighbors, try to combined with left neighbor
                T removeValue = leftNeighbor.getKey(leftNeighbor.numberOfKeys() - 1);
                int prev = getIndexOfNextValue(parent, removeValue);
                T parentValue = parent.removeKey(prev);
                parent.removeChild(leftNeighbor);
                node.addKey(parentValue);
                for (int i = 0; i < leftNeighbor.keysSize; i++) {
                    T v = leftNeighbor.getKey(i);
                    node.addKey(v);
                }
                for (int i = 0; i < leftNeighbor.childrenSize; i++) {
                    Node<T> c = leftNeighbor.getChild(i);
                    node.addChild(c);
                }

                if (parent.parent != null && parent.numberOfKeys() < minKeySize)
                    // removing key made parent too small, combined up tree
                    this.combined(parent);
                else if (parent.numberOfKeys() == 0) {
                    // parent no longer has keys, make this node the new root
                    // which decreases the height of the tree
                    node.parent = null;
                    root = node;
                }
            }
        }

        return true;
    }
    
    /**
     * Get the index of previous key in node.     * 
     * @param node to find the previous key in.
     * @param value to find a previous value for.
     * @return index of previous key or -1 if not found.
     */
    private int getIndexOfPreviousValue(Node<T> node, T value) {
        for (int i = 1; i < node.numberOfKeys(); i++) {
            T t = node.getKey(i);
            if (t.compareTo(value) >= 0)
                return i - 1;
        }
        return node.numberOfKeys() - 1;
    }

    /**
     * Get the index of next key in node.     * 
     * @param node to find the next key in.
     * @param value to find a next value for.
     * @return index of next key or -1 if not found.
     */
    private int getIndexOfNextValue(Node<T> node, T value) {
        for (int i = 0; i < node.numberOfKeys(); i++) {
            T t = node.getKey(i);
            if (t.compareTo(value) >= 0)
                return i;
        }
        return node.numberOfKeys() - 1;
    }
    
    /**
     * Get the greatest valued child from node.
     * @param nodeToGet child with the greatest value.
     * @return Node<T> child with greatest value.
     */
    private Node<T> getGreatestNode(Node<T> nodeToGet) {
        Node<T> node = nodeToGet;
        while (node.numberOfChildren() > 0) {
            node = node.getChild(node.numberOfChildren() - 1);
        }
        return node;
    }
    
    /**
     * Remove greatest valued key from node.     
     * @param node to remove greatest value from.
     * @return value removed;
     */
    private T removeGreatestValue(Node<T> node) {
        T value = null;
        if (node.numberOfKeys() > 0) {
            value = node.removeKey(node.numberOfKeys() - 1);
        }
        return value;
    }
    //
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(T value) {
        Node<T> node = getNode(value);
        return (node != null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean validate() {
        if (root == null) return true;
        return validateNode(root);
    }
    
    /**
     * Validate the node according to the B-Tree invariants.
     * @param node to validate.
     * @return True if valid.
     */
    private boolean validateNode(Node<T> node) {
        int keySize = node.numberOfKeys();
        if (keySize > 1) {
            // Make sure the keys are sorted
            for (int i = 1; i < keySize; i++) {
                T p = node.getKey(i - 1);
                T n = node.getKey(i);
                if (p.compareTo(n) > 0)
                    return false;
            }
        }
        int childrenSize = node.numberOfChildren();
        if (node.parent == null) {
            // root
            if (keySize > maxKeySize)
                // check max key size. root does not have a min key size
                return false;
            else if (childrenSize == 0)
                // if root, no children, and keys are valid
                return true;
            else if (childrenSize < 2)
                // root should have zero or at least two children
                return false;
            else if (childrenSize > maxChildrenSize)
                return false;            
        } else {
            // non-root
            if (keySize < minKeySize)
                return false;
            else if (keySize > maxKeySize)
                return false;
            else if (childrenSize == 0)
                return true;
            else if (keySize != (childrenSize - 1))
                // If there are chilren, there should be one more child then
                // keys
                return false;
            else if (childrenSize < minChildrenSize)
                return false;
            else if (childrenSize > maxChildrenSize)
                return false;            
        }

        Node<T> first = node.getChild(0);
        // The first child's last key should be less than the node's first key
        if (first.getKey(first.numberOfKeys() - 1).compareTo(node.getKey(0)) > 0)
            return false;

        Node<T> last = node.getChild(node.numberOfChildren() - 1);
        // The last child's first key should be greater than the node's last key
        if (last.getKey(0).compareTo(node.getKey(node.numberOfKeys() - 1)) < 0)
            return false;

        // Check that each node's first and last key holds it's invariance
        for (int i = 1; i < node.numberOfKeys(); i++) {
            T p = node.getKey(i - 1);
            T n = node.getKey(i);
            Node<T> c = node.getChild(i);
            if (p.compareTo(c.getKey(0)) > 0)
                return false;
            if (n.compareTo(c.getKey(c.numberOfKeys() - 1)) < 0)
                return false;
        }

        for (int i = 0; i < node.childrenSize; i++) {
            Node<T> c = node.getChild(i);
            boolean valid = this.validateNode(c);
            if (!valid)
                return false;
        }
        return true;
    }

    @Override
    public Collection<T> toCollection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String toString() {
        TreePrinter tp=new TreePrinter();
        return tp.getString(this);
    }
}
