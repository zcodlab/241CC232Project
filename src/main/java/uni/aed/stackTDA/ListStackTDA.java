package uni.aed.stackTDA;
import uni.aed.linkedlistTDA.LinkedListTDA;
import uni.aed.listTDA.ListTDA;
public class ListStackTDA<E> implements StackTDA<E> {
    private static final int FRENTE=0;
    private final ListTDA<E> lista;

    public ListStackTDA() {
        this.lista = new LinkedListTDA<>();
    }
    
    @Override
    public void push(E elemento) {
        lista.add(FRENTE, elemento);
    }

    @Override
    public E pop() throws StackEmptyExceptionTDA {
        if(isEmpty())
            throw new StackEmptyExceptionTDA();
        else
            return lista.delete(FRENTE);
    }

    @Override
    public E peek() throws StackEmptyExceptionTDA {
        if(isEmpty())
            throw new StackEmptyExceptionTDA();
        else
            return lista.get(FRENTE);
    }

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public void clear() {
        lista.clear();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
    
}
