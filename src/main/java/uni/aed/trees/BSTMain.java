package uni.aed.trees;

public class BSTMain {
    public static void main(String[] args){
        BSTMain bSTMain=new BSTMain();
        bSTMain.insert02();
        bSTMain.insert03();
    }
    private void insert02(){
        BST tree=new BST();
        tree.insert(15);
        tree.insert(10);
        tree.insert(5);
        tree.insert(11);
        tree.insert(12);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        System.out.println("\nRealizando eliminacion por fusion del nodo raiz: 15");
        System.out.println(tree.root.toString());        
        tree.deleteByMerging(15);
        System.out.println(tree.root.toString());        
    }
    private void insert03(){
        BST tree=new BST();
        tree.insert(15);
        tree.insert(10);
        tree.insert(5);
        tree.insert(4);
        tree.insert(7);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        System.out.println("\nRealizando eliminacion por fusion del nodo raiz: 15");
        System.out.println(tree.root.toString());        
        tree.deleteByMerging(15);
        System.out.println(tree.root.toString());        
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
        System.out.println("\nRealizando una llamanda preorder(VLR)");
        tree.preorder();
        System.out.println("\nRealizando una llamanda postorder(LRV)");
        tree.postorder();
        System.out.println("\nRealizando una busqueda del elemento 13");
        tree.visit(tree.search(13));
        System.out.println("\nRealizando una llamada al metodo primero en amplitud");        
        tree.breadthFirst();
        System.out.println("\nRealizando eliminacion por copiado del nodo raiz: 10");
        tree.deleteByCopying(10);
        tree.inorder();
        System.out.println("\nRealizando eliminacion por fusion del nodo raiz: 10");
        tree.deleteByMerging(20);
        tree.inorder();
    }
    
}
