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
        if(head==null)         
            return;
        
        if(((Comparable)head.data).compareTo(data)==0){
            head=head.next;
            return;
        }
        
        ONodo current=head;
        while(current.next!=null && (((Comparable)current.next.data).compareTo(data)!=0))
            current=current.next;
        
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
