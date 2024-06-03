package uni.aed.trees.TBT;

public class TBTMain {
    public static void main(String[] args){
        TBT tbt=new TBT();
        tbt.insert(15);
        tbt.insert(4);
        tbt.insert(20);
        tbt.insert(17);
        tbt.insert(19);
        System.out.println("Realizando un recorrido Inorder(LVR)");
        tbt.TBTInOrder();
    }
    
}
