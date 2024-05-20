package uni.aed.queueTDA;

public interface QueueTDA<E> {
    public void add(E elemento);//enqueue
    public E remove() throws QueueEmptyExceptionTDA;//dequeue
    public E poll();//dequeue
    public E peek();//peek
    public void clear();
    public boolean isEmpty();
    public int size();    
    public void offer(E elemento,int prioridad);//enqueue
    
}
