package uni.aed.queueTDA;
import uni.aed.listTDA.ListTDA;
import uni.aed.linkedlistTDA.LinkedListTDA;

public class ListQueueTDA<E> implements QueueTDA<E> {    

    private static final int FRENTE=0;
    private final ListTDA<E> lista;    
    
    public ListQueueTDA() {
        this.lista = new LinkedListTDA<>();
    }
    
    @Override
    public void add(E elementos){//enqueue
        lista.add(lista.size(),elementos);        
    }
    
    @Override
    public E remove()throws QueueEmptyExceptionTDA{//dequeue
        if(isEmpty())
            throw new QueueEmptyExceptionTDA();
        else
            return lista.delete(FRENTE);
    }
    
    @Override
    public E peek(){//peek
        if(isEmpty())
            return null;
        else
            return lista.get(FRENTE);
    }
    
    @Override
    public void clear(){
        lista.clear();
    }
    
    @Override
    public boolean isEmpty(){
        return lista.isEmpty();
    }    
    
    @Override
    public int size(){
        return lista.size();
    }
    
    @Override
    public String toString(){
        return lista.toString();
    }

    @Override
    public void offer(E elemento, int prioridad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E poll() {
        if(isEmpty())
            return null;
        else
            return lista.delete(FRENTE);
    }
    
}
