package uni.aed.stackTDA;
public interface StackTDA<E> {
    public void push(E elemento);//add
    public E pop() throws StackEmptyExceptionTDA;//remove
    public E peek() throws StackEmptyExceptionTDA;//get
    public int size();//tamaño de la pila
    public void clear();//limpiar la pila
    public boolean isEmpty();//verificar si pila esta vacia    
}
