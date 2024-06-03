package uni.aed.trees.AVL;
public class AvlTree {    
    AvlTreeNode root;    
    public void add(int key){
        if(findAvlTreeNode(root,key)==null){
            root=BSTInsert(root,key);            
            System.out.println("\n"+ key +" se inserto en el arbol");
        }
        else
            System.out.println("\nkey ya existe en el arbol");
    }
    private AvlTreeNode BSTInsert(AvlTreeNode root, int key){
        if(root==null)
            return new AvlTreeNode(key);
        else if(key < root.key)
            root.left=BSTInsert(root.left,key);
        else
            root.rigth=BSTInsert(root.rigth,key);
        //proceso para validar si el arbol esta balanceado
        return balanceTree(root);
    }
    private AvlTreeNode findAvlTreeNode(AvlTreeNode root,int key){
        if(root==null || key==root.key)
            return root;
        if(key<root.key)
            return findAvlTreeNode(root.left,key);
        else
            return findAvlTreeNode(root.rigth,key);
    }
    private AvlTreeNode balanceTree(AvlTreeNode root){
        updateHeight(root);
        int balance=Balance(root);
        if(balance>1){
            if(Balance(root.rigth)<0){
                root.rigth=rotateRigth(root.rigth);
                return rotateLeft(root);                
            }else 
                return rotateLeft(root);                
        }
        if(balance<-1){
            if(Balance(root.left)>0){
                root.left=rotateLeft(root.left);
                return rotateRigth(root);                
            }else
                return rotateRigth(root);                
        }
        return root;
    }
    private void updateHeight(AvlTreeNode key){
        key.height=Math.max(Height(key.left),Height(key.rigth)) + 1;    
    }
    private int Height(AvlTreeNode key){
        if(key==null)
            return 0;
        else
            return key.height;
    }
    //calculando el factor de balance
    private int Balance(AvlTreeNode key){
        if(key==null)
            return 0;
        else
            return (Height(key.rigth) - Height(key.left));
    }
    private AvlTreeNode rotateLeft(AvlTreeNode x){
        AvlTreeNode y=x.rigth;
        AvlTreeNode T2=y.left;        
        y.left=x;
        x.rigth=T2;        
        updateHeight(x);
        updateHeight(y);
        
        return y;
    }
    private AvlTreeNode rotateRigth(AvlTreeNode y){
        AvlTreeNode x=y.left;
        AvlTreeNode T2=x.rigth;
        
        x.rigth=y;
        y.left=T2;
        
        updateHeight(y);
        updateHeight(x);
        
        return x;        
    }
    
    public String PreOrder(AvlTreeNode node){//VLR
        StringBuilder tree = new StringBuilder();
        if(node!=null){
            tree.append(node.key);
            tree.append("");
            tree.append(PreOrder(node.left));
            tree.append(PreOrder(node.rigth));            
        }
        return tree.toString();
            
    }
    public int search(int key){
        if(findAvlTreeNode(root, key)==null)
            return 0;
        else
            return 1;
    }
    public void delete(int key){
        if(findAvlTreeNode(root, key)!=null){
            root=Remove(root, key);
            System.out.println("\nEliminacion de "+ key +" exitosa");
        }
        else
            System.out.println("\nNo fue posible eliminar "+ key +" no se ubico en el arbol");
    }
    private AvlTreeNode Remove(AvlTreeNode root, int key){
        if(root==null)
            return root;
        else if(key<root.key)
            root.left=Remove(root.left,key);
        else if(key>root.key)
            root.rigth=Remove(root.rigth,key);
        else{
            if(root.rigth==null)
                root=root.left;
            else if(root.left==null)
                root=root.rigth;
            else{
                AvlTreeNode temp=Succesor(root.rigth);
                root.key=temp.key;
                root.rigth=Remove(root.rigth,root.key);                        
            }                           
        }
        if(root==null)
            return root;
        else
            return balanceTree(root); 
    }
    private AvlTreeNode Succesor(AvlTreeNode root){
        if(root.left!=null)
            return Succesor(root.left);
        else
            return root;
    }
}
