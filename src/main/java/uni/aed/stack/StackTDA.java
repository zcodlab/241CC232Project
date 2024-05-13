package uni.aed.stack;
public interface StackTDA<E> {
    public void push(E elemento);
    public E pop() throws StackEmptyExceptionTDA;
    public E peek() throws StackEmptyExceptionTDA;
    public int size();
    public void clear();
    public boolean isEmpty();    
}
