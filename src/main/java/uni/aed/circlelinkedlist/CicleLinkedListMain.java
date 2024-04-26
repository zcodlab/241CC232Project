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
        
        System.out.println("Buscando el valor 60");
        if(lista.search(60))
            System.out.println("El valor 60 fue ubicado en la lista");
        else
            System.out.println("El valor 60 No se ubico en la lista");
        
        System.out.println("Buscando el valor 20");
        if(lista.search(20))
            System.out.println("El valor 20 fue ubicado en la lista");
        else
            System.out.println("El valor 20 No se ubico en la lista");
    }
}
