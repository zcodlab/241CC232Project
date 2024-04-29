package uni.aed.listTDA;
public interface IteratorTDA<E> {
    public boolean hasNext();
    public E next() throws NoSuchElementException;    
}
