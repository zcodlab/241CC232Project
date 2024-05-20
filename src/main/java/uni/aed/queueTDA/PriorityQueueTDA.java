package uni.aed.queueTDA;

public class PriorityQueueTDA<E> implements QueueTDA<E> {

    private static final int TAMANIO_DEFINIDO=25;
    private static final int RAIZ=0;
    private E[] heap;
    private int contador;
    
    public PriorityQueueTDA() {
        this(TAMANIO_DEFINIDO);
    }
    public PriorityQueueTDA(int tamanio) {
        if(tamanio<=0)
            throw new IllegalArgumentException("Capacidad inicial debe ser positiva");
        heap=(E[])new Object[tamanio];        
        clear();
    }
    
    @Override
    public void add(E item){//enqueue
        if(contador==heap.length)
            expande();
        heap[contador]=item;
        construye();
        contador++;
    }
    
    @Override    
    public void offer(E item,int prioridad){
        if(contador==heap.length)
            expande();
        heap[prioridad]=item;        
        contador++;
    }
    
    @Override
    public E remove()throws QueueEmptyExceptionTDA{//dequeue
        E item;
        if (isEmpty())
            throw new QueueEmptyExceptionTDA();
        else{
            item=heap[RAIZ];
            heap[RAIZ]=heap[contador-1];
            contador--;
            reconstruye(RAIZ);
        }        
        return item;
    }
    
    @Override
    public E peek(){//peek
        if(isEmpty())
            return null;
        else
            return (E)heap[RAIZ];
    }
    
    @Override
    public void clear(){
        for(int i=0;i<contador;i++)
            heap[i]=null;
        contador=0;
    }
    
    @Override
    public boolean isEmpty(){
        return contador==0;
    }    
    
    @Override
    public int size(){
        return contador;
    }
    
    private void expande(){
        E[] temp=(E[])new Object[(int)(heap.length*1.5)];
        for(int i=0;i<heap.length;i++)
            temp[i]=heap[i];
        heap=temp;
    }
    
    private void construye(){
        for(int i=(contador-2)/2;i>=0;i--)
            reconstruye(i);
    }
    public void reconstruye(int raiz){
        int actual=raiz;
        boolean termina=false;
        while(!termina){
            if(2*actual+1 > contador-1)
                //el nodo actual no tiene hijos, asi que paramos
                termina=true;
            else{
                //el nodod actual tiene almenos un hijo
                //obtiene el indice del hijo de mayor prioridad
                int indexHijoAlta=hijoMayorPrioridad(actual,contador-1);
                if(((Comparable<E>)heap[indexHijoAlta]).compareTo(heap[actual])<0){
                    swap(actual,indexHijoAlta);
                    actual=indexHijoAlta;
                }else//se satisface la estriccion de relacion de valor, asi que paramos
                    termina=true;
            }
        }
    }
    
    private int hijoMayorPrioridad(int ubicacion,int fin){
        int resultado,indexHijoIzq,indexHijoDer;
        indexHijoDer=2*ubicacion+2;
        indexHijoIzq=2*ubicacion+1;
        if(indexHijoDer<=fin && ((Comparable<E>)heap[indexHijoIzq])        
                .compareTo(heap[indexHijoDer])<0)
            resultado=indexHijoIzq;
        else
            resultado=indexHijoDer;
        return resultado;
    }
    
    private void swap(int index1,int index2){
        E temp;
        temp=heap[index1];
        heap[index1]=heap[index2];
        heap[index2]=temp;
    }
    
    @Override
    public String toString(){
        String result="";
        int current=RAIZ;
        while (current< contador)
        {
            if (result.trim().length()==0)
                result= heap[current].toString();
            else
                result= result +"\n"+ heap[current].toString();
            current++;
        }
        return result;
    }

    @Override
    public E poll() {
         E item;
        if (isEmpty())
            return null;
        else{
            item=heap[RAIZ];
            heap[RAIZ]=heap[contador-1];
            contador--;
            reconstruye(RAIZ);
        }        
        return item;
    }
    
    
}
