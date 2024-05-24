package uni.aed.stackTDA;
import uni.aed.linkedlistTDA.Nodo;
public class LinkedStackTDA<E> implements StackTDA<E> {
    private Nodo<E> topPila;
    private int contador;    

    public LinkedStackTDA() {
        clear();
    }    
    
    @Override
    public void push(E elemento) {
        Nodo newTope=new Nodo(elemento);
        newTope.setNext(topPila);
        topPila=newTope;
        contador++;
    }

    @Override
    public E pop() throws StackEmptyExceptionTDA {
        if(isEmpty())
            throw new StackEmptyExceptionTDA();
        else{
            contador--;
            E temp=(E)topPila.getData();
            topPila=topPila.getNext();
            return temp;
        }
    }

    @Override
    public E peek() throws StackEmptyExceptionTDA {
        if(isEmpty())
            throw new StackEmptyExceptionTDA();
        else
            return (E)topPila.getData();
    }

    @Override
    public int size() {
        return contador;
    }

    @Override
    public void clear() {
        topPila=null;
        contador=0;
    }

    @Override
    public boolean isEmpty() {
        return contador==0;
    }

    @Override
    public String toString() {
        String result="";
        Nodo current=topPila;
        while(current!=null){
            result=result+"\n"+ current.getData().toString();
            current=current.getNext();
        }
        return result;
    }
    
}
