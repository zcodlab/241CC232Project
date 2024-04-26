package uni.aed.circlelinkedlist;

public class CicleLinkedListMain {
    public static void main(String[] args){
        CicleLinkedListMain lista=new CicleLinkedListMain();
        lista.cicleLinkedList();
    }
    private void cicleLinkedList(){
        CircleLinkedList lista=new CircleLinkedList();
        lista.addLast(10);
        lista.addLast(20);
        lista.addLast(30);        
        
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());
    }
}
