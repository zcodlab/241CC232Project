//Nueva clase genérica Node
//Generaliza SoftwareNode sirviendo como nodo de arbol binario
//Se toma a todo un objeto Software como la clave para poder trabajar directamente con su nombre y versión
package uni.aed.trees.softwarestore.solucion;
public class Node<E> {
    E key;
    int filePosition;
    Node left;
    Node right;
    public Node(E key, int filePosition){
        this.key = key;
        this.left = null;
        this.right = null;
        this.filePosition = filePosition;
    }

    public E getKey() {
        return key;
    }

    public int getFilePosition() {
        return filePosition;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public void setFilePosition(int filePosition) {
        this.filePosition = filePosition;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }   
}