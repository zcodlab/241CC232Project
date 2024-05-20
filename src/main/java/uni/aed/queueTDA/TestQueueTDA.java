package uni.aed.queueTDA;

import java.util.Random;

public class TestQueueTDA {
    public static void main(String[] args){
        TestQueueTDA testQueueTDA=new TestQueueTDA();
        testQueueTDA.TestLinkedQueueTDA();
    }
    private void TestLinkedQueueTDA(){
        QueueTDA<String> q=new LinkedQueueTDA<>();
        q.add("Jose");
        q.add("Pedro");
        q.add("Sandro");
        
        System.out.println("Despues de insertar elementos en la cola");
        System.out.println(q.toString());
        System.out.println("Despues de eliminar elementos en la cola"+ q.remove());
        System.out.println(q.toString());
         
    }
    private void TestArrayQueueTDA(){
        ArrayQueueTDA<Integer> q=new ArrayQueueTDA<>(4);
        q.add(30);
        q.add(10);
        q.add(20);        
        System.out.println("Despues de insertar elementos en la cola");
        System.out.println(q.toString());        
        q.remove();
        System.out.println("Despues eliminar");
        System.out.println(q.toString());
        q.remove();
        System.out.println("Despues eliminar");        
        System.out.println(q.getFront());
        System.out.println(q.getBack());
        System.out.println(q.toString());
//        q.add(80);
//        q.add(70);
//        q.add(60);
//        q.add(50);
//        q.add(40);
//        System.out.println("Despues 2 adicion");        
//        System.out.println(q.toString());
    }
    
    private void TestPriorityQueueTDA(){
        PriorityQueueTDA<Integer> q=new PriorityQueueTDA<>(10);
        Random random=new Random();
        for(int i=0;i<10;i++)
            q.add(random.nextInt(100));
        for(int i=0;i<10;i++)
            System.out.println(q.remove());
        
    }
    
}
