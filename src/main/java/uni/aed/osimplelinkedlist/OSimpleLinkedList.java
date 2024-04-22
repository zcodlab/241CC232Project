package uni.aed.osimplelinkedlist;
public class OSimpleLinkedList {
    ONodo head;
    public void addFirst(Object data){
        ONodo newNodo=new ONodo(data);
        newNodo.next=head;
        head=newNodo;
    }
    public void addLast(Object data){
        ONodo newNodo=new ONodo(data);
        if(head==null){
            head=newNodo;
            return;
        }
        ONodo current =head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNodo;
    }  
    public void remove(Object data){
        if(head==null)//si lista no tiene datos no hay nada que eliminar            
            return;
        //encontrar el elemento a remover
        //verificamos si el primer elemento de la lista es igual al valor ingresado
        if(((Comparable)head.data).compareTo(data)==0){
            head=head.next;
            return;
        }
        //Recorrer la lista en la busqueda del nodo a eliminar
        ONodo current=head;
        while(current.next!=null && (((Comparable)current.next.data).compareTo(data)!=0))
            current=current.next;
        //si lo encontro entonces procede a eliminar
        if(current.next!=null)
            current.next=current.next.next;
            
    }
    
    public void clear(){
        head=null;
    }
    public String toString(){
        String lista="";
        ONodo current=head;
        while(current!=null){
            if(lista.length()==0)
                lista=""+current.data.toString();
            else
                lista=lista+"->"+current.data.toString();
            current=current.next;
        }
        return lista;
        
    }
}
