package uni.aed.linkedlist;
public class ListaEnlazadaSimple {
    Nodo head;
    int lenght=0;
    
    public void addFirst(int data){
        Nodo newNodo=new Nodo(data);
        newNodo.next=head;
        head=newNodo;
        lenght++;
    }
    public void addToPosition(int position,int currentDataValue){
        Nodo anotherNodo=new Nodo(currentDataValue);        
        Nodo current;
        int index;
        if((position<1 || position>lenght))
           System.out.println("Posicion debe ser un valor entre 1-"+lenght);
        else
        {
            if(position==1)
                addFirst(anotherNodo.data);                
            else
            {
                current=head;            
                index=1;
                while(index<(position-1)){
                    current=current.next;
                    index++;
                }
                anotherNodo.next=current.next;
                current.next=anotherNodo;
                lenght++;
            }
        }      
    }
    public int search(int key){
       Nodo temp=head;
       boolean isFound=false;
       int index=1;
       while((temp!=null) && (isFound==false)){
           if(temp.data==key)
               isFound=true;
           else{
               temp=temp.next;
               index++;
           }
       }
       if (isFound==true)
           return index;
       else
           return -1;
       
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
        lenght++;
    }
    public void remove(int data){
        if(head==null)
            return;
        //si el elemento a eliminar es el primer nodo
        if(head.data==data){
            head=head.next;
            lenght--;
            return;
        }
        //si el nodo a eliminar no es el primer nodo
        Nodo current=head;
        while(current.next!=null && current.next.data!=data)
            current=current.next;
        
        if(current.next!=null){
            current.next=current.next.next;
            lenght--;
        }
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
    public boolean isEmpty(){
        return(lenght==0);
    }
    public void displayReverse(){
        Nodo temp=head;
        if(isEmpty()==false)
            reverse(temp);        
    }
    private void reverse(Nodo temp){
        if(temp.next!=null)
            reverse(temp.next);
        System.out.println(temp.data);
    }
            
}
