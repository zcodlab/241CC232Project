package uni.aed.linkedlist;
public class ListaEnlazadaSimple {
    Nodo head;
    public void addFirst(int data){
        Nodo newNodo=new Nodo(data);
        newNodo.next=head;
        head=newNodo;
    }
    public void addLast(int data){
        Nodo newNodo=new Nodo(data);        
        if(head==null){
            head=newNodo;
            return;
        }
        Nodo current=head;
        while(current.next!=null)
            current=current.next;        
        current.next=newNodo;            
    }
    public void remove(int data){
        if(head==null)
            return;
        //si el elemento a eliminar es el primer nodo
        if(head.data==data){
            head=head.next;
            return;
        }
        //si el nodo a eliminar no es el primer nodo
        Nodo current=head;
        while(current.next!=null && current.next.data!=data)
            current=current.next;
        
        if(current.next!=null)
            current.next=current.next.next;
    }
    public void clear(){
        head=null;
    }
    @Override
    public String toString(){
        String lista="";
        Nodo current=head;
        while(current!=null){
            if(lista.length()==0)
                lista=""+current.data;
            else
                lista=lista+"->"+current.data;
            current=current.next;
        }
        return lista;
    }
}
