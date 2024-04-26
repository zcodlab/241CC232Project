package uni.aed.circlelinkedlist;
public class CircleLinkedList {
    Nodo head;
    public void addLast(int data){
        Nodo newNodo=new Nodo(data);
        if(head==null){
            head=newNodo;
            head.next=head;
            return;
        }
        Nodo current=head;
        while(current.next!=head)
            current=current.next;
        current.next=newNodo;
        newNodo.next=head;
    }

    @Override
    public String toString() {
        String lista="";
        if (head==null)
            return lista;
        Nodo current=head;
        do{
            if(lista.length()==0)
                lista=""+current.data;
            else
                lista=lista+"->"+current.data;
            current=current.next;
        }while(current!=head);
        
        if(current==head)
            lista=lista+"->"+current.data;
        return lista;
    }
    
}
