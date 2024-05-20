package uni.aed.queueTDA;

public class ArrayQueueTDA<E> implements QueueTDA<E> {
    private static final int TAMANIO_DEFINIDO=25;
    private E[] queue;
    private int contador;
    private int front;
    private int back;

    public int getFront() {
        return front;
    }

    public int getBack() {
        return back;
    }

    public ArrayQueueTDA(int tamanio) {
        if(tamanio<=0)
            throw new IllegalArgumentException("Capacidad mayor a cero");
        queue=(E[])new Object[tamanio];
        contador=0;        
    }

    @Override
    public void add(E item) {
        if(contador==queue.length)
            expande();
        queue[back]=item;
        back=(back+1)%queue.length;
        contador++;
    }
    @Override
    public E remove() throws QueueEmptyExceptionTDA{
        E item;
        if (isEmpty())
            throw new QueueEmptyExceptionTDA();
        else{
            item=queue[front];
            queue[front]=null;
            front=(front+1)%queue.length;
            contador--;
        }
        return item;
    }

    @Override
    public E peek(){
        if (isEmpty())
            return null;
        else
            return queue[front];
    }

    @Override
    public void clear() {
        for(int i=0;i<contador;i++)
            queue[i]=null;
        front=back=contador=0;
    }

    @Override
    public boolean isEmpty() {
        return contador==0;
    }

    @Override
    public int size() {
        return contador;
    }
    public void expande(){
        E[] temp=(E[])new Object[(int)(1.5*queue.length)];
        int q_idx=front;
        int t_idx=front;
        for(int i=0;i<contador;i++){
            temp[t_idx]=queue[q_idx];
            t_idx=(t_idx + 1)%temp.length;
            q_idx=(q_idx + 1)%queue.length;
        }
        back=t_idx;
        queue=temp;
    }

    @Override
    public void offer(E elemento, int prioridad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public String toString(){
        String result="";
        int current=front;
        for(int i = 0; i < contador; i++){
            result=result+"\n"+queue[current].toString();
            current = (current + 1) % queue.length;
        }           
        return result;
            
    }
    
    public void imprimir(){        
        int current=front;
        for(int i = 0; i < contador; i++){
            System.out.println(queue[current]);
            current = (current + 1) % queue.length;
        }       
    }

    @Override
    public E poll() {
        E item;
        if (isEmpty())
            return null;
        else{
            item=queue[front];
            queue[front]=null;
            front=(front+1)%queue.length;
            contador--;
        }
        return item;
    }
    
}
