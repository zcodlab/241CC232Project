package uni.aed.trees.B;

public class TestBTree {
    public static void main(String[] args)
    {        
        BTree<Integer> bst = new BTree<>(5);
        bst.add(2);
        bst.add(8);
        bst.add(14);
        bst.add(15);
        bst.add(3);
        bst.add(1);
        bst.add(16);
        bst.add(6);
        bst.add(5);
        bst.add(27);
        bst.add(37);
        bst.add(18);
        bst.add(25);
        bst.add(7);
        bst.add(13);
        bst.add(20);
        bst.add(22);
        bst.add(23);
        bst.add(24);
        System.out.println(bst.toString());
        bst.remove(6);
        System.out.println(bst.toString());
        bst.remove(7);
        System.out.println(bst.toString());
        bst.remove(8);
        System.out.println(bst.toString());

    }
}
