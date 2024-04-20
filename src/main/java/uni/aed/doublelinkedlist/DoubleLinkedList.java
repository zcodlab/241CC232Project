package uni.aed.doublelinkedlist;

public class DoubleLinkedList {
    Nodo head;
    Nodo ultimo;
    
    public void addLast(int data){
        Nodo newNodo=new Nodo(data);
        if(ultimo==null){
            head=newNodo;
            ultimo=newNodo;
        }else{
            newNodo.prev=ultimo;
            ultimo.next=newNodo;
            ultimo=newNodo;
        }
    }
    
    
}
