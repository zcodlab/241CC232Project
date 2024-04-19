package osimplelinkedlist;
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
