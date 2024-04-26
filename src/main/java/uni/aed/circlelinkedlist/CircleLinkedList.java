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
    
    public boolean search(int key){
        if(head==null)
            return false;
        Nodo current=head;
        do{
            if(current.data==key)
                return true;            
            current=current.next;
        }while(current!=head);
        return false;
    }
    public void remove(int data){
        if(head==null)
            return;
        if(head.data==data){
            Nodo current=head;
            while(current.next!=head)
                current=current.next;
            head=head.next;
            current.next=head;
            return;
        }
        
        Nodo current=head;
        while(current.next!=head && current.next.data!=data)
            current=current.next;
        
        if(current.next!=head)
            current.next=current.next.next;
        //falta analizar eliminacion de un nodo intermedio de una lista de mas de 3 elementos
        //falta analizar eliminar del ultimo nodo de la lista
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
