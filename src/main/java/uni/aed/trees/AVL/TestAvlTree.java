package uni.aed.trees.AVL;

public class TestAvlTree {
    public static void main(String[] args){
        AvlTree tree =new AvlTree();
        System.out.println("Cargando datos al arbol");
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(25);
        System.out.println("Visualizando el arbol despues de la carga");
        System.out.println(tree.root.toString());
        System.out.println("Realizando el recorrido en profundidad- preorder(LVR)");
        System.out.println(tree.PreOrder(tree.root));
        System.out.println("Eliminando nodos en el arbol");
        tree.delete(20);
        System.out.println("Visualizando el arbol despues de la operacion");
        System.out.println(tree.root.toString());
        System.out.println("Realizando el recorrido en profundidad- preorder(LVR)");
        System.out.println(tree.PreOrder(tree.root));
        
    }
    
}

