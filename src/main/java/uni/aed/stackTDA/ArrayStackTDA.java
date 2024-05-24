package uni.aed.stackTDA;

public class ArrayStackTDA<E> implements StackTDA<E> {
    private static final int TAM_DEFINIDO=10;
    private E[] elementos;
    private int contador;

    public ArrayStackTDA() {
        this(TAM_DEFINIDO);
    }
    public ArrayStackTDA(int tamanio) {
        if(tamanio<=0)
            throw new IllegalArgumentException("Capacidad inicial debe ser positivo");
        this.elementos=(E[])new Object[tamanio];
    }
        
    @Override
    public void push(E elemento) {
        if(contador==elementos.length)
            expande();
        elementos[contador++]=elemento;//colocando el elemento en la cuspide del array
    }
    private void expande(){
        int newtamanio=(int)(1.5*elementos.length);
        E[] temp =(E[])new Object[newtamanio];
        for(int i=0; i<elementos.length;i++)
            temp[i]=elementos[i];
        elementos=temp;
    }

    @Override
    public E pop() throws StackEmptyExceptionTDA {
        if(isEmpty())
            throw new StackEmptyExceptionTDA();
        else
            contador--;
            E elemento=elementos[contador];
            elementos[contador]=null;//eliminando elemento de la cuspide
            return elemento;
    }
    @Override
    public E peek() throws StackEmptyExceptionTDA {
        if(isEmpty())
            throw new StackEmptyExceptionTDA();
        else
            return (E)elementos[contador-1];//similar a get, 
                                    //pero retorna el valor de la cuspide
    }

    @Override
    public int size() {
        return contador;
    }

    @Override
    public void clear() {
        for(int i=0; i<contador;i++)
            elementos[i]=null;
        contador=0;
    }

    @Override
    public boolean isEmpty() {
        return contador==0;
    }

    @Override
    public String toString() {
        String result="";
        int  current=contador-1;
        while(current>=0){
            result=result+"\n"+ elementos[current].toString();
            current--;
        }
        return result;
    }
    
}
