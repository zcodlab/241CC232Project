package uni.aed.sort;

public class SortObject{   
    private static final int LESS = -1;
    private static final int EQUAL = 0;    
    private static final int MORE  = 1;  
    
    //Metodo de Ordenamiento HeapSort
    public Object[] HeapSort(Object[] X)
    { 
        Object[] Y=new Object[X.length];
        HeapSortConstruct(X); //fase de construccion: construye el heap   
        Y=HeapSortExtract(X); //fase de extraccion: extrae nodos raiz              
        return Y;
    }     
    private void HeapSortConstruct(Object[] X)             
    {
        int     current, maxChildIndex;
        boolean hecho;        
        for (int i = (X.length-2) / 2; i >= 0; i--) {            
            current = i;
            hecho    = false;                           
            int comparisonResult;            
            while ( !hecho ) {                
                if ( 2*current+1 > X.length-1 ) {
                    //nodo actual no tiene hijos, termina
                    hecho = true;
                }
                else {
                    //el nodo actual tiene al menos un hijo, obtenga el índice del hijo más grande
                    maxChildIndex = HeapSortMaxChild(X,current, X.length-1 );                                        
                    comparisonResult = ((Comparable)X[maxChildIndex]).compareTo( X[current] );                    
                    if (comparisonResult>0){                        
                        intercambio( X,current, maxChildIndex );
                        current = maxChildIndex;
                    }
                    else { //la restricción de la relación de valor se cumple, terminar                        
                        hecho = true;
                    }
                }
            }
        }
    }
    
    private Object[] HeapSortExtract(Object[] X)
    {
        int     current, maxChildIndex;
        boolean hecho;
        Object[] Y= new Object[X.length];//sortedList        
        int comparisonResult;            
        for (int i = X.length-1; i >= 0; i--) {            
            //remover data del nodo raiz
            Y[i] = X[ 0 ];            
            //mover el ultimo nodo a la raiz
            X[ 0 ] = X[i];            
            //reconstruir
            current = 0;
            hecho    = false;            
            while ( !hecho ) {                
                if ( 2*current+1 > i )
                    //si actual nodo no tiene hijos, deternerse
                    hecho = true;                
                else {
                    //si nodo actual tiene al menos un hijo, obtener el indice del hijo mas grande
                    maxChildIndex = HeapSortMaxChild(X,current, i );                                        
                    comparisonResult = ((Comparable)X[maxChildIndex]).compareTo( X[current] );
                    if (comparisonResult>0){                       
                        intercambio( X,current, maxChildIndex );
                        current = maxChildIndex;
                    }
                    else  //la restricción de la relación de valor se cumple, terminar   
                        hecho = true;                    
                }
            }            
        }
        return Y;
    }
    
     private int HeapSortMaxChild(Object[] X,int loc, int end )
    {   //Precondition: nodo de la ubicacion tiene al menos un hijo, //Iz=leftChildIndex,Der=rightChildIndex
        int result, Izq,Der;        
        Der = 2*loc + 2;
        Izq  = 2*loc + 1;                
        if ( Der <= end && ((Comparable)X[Der]).compareTo( X[Izq] )>0) {
            result = Der;
        }
        else {
            result = Izq;
        }       
        return result;
    }  
     
    private void intercambio(Object X[],int p,int q){
        Object temp=X[p];
        X[p]=X[q];
        X[q]=temp;       
    }
}

