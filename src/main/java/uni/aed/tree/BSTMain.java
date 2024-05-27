package uni.aed.tree;

public class BSTMain {
    public static void main(String[] args){
        BSTMain bSTMain=new BSTMain();
        bSTMain.insert();
    }
    private void insert(){
        BST tree=new BST();
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.insert(4);
        tree.insert(6);
        tree.insert(15);
        tree.insert(30);
        tree.insert(0);
        tree.insert(7);
        tree.insert(13);
        tree.insert(8);
        System.out.println("Realizando una llamanda inorder(LVR)");
        tree.inorder();
    }
    
}
