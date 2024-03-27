package uni.aed.maxmin;
/**
 * Algoritmo que determina el Maximo y Minimo de una lista de numeros enteros
 * @author uni.cc232
 */
public class MaxMin {    
    
    public Integer getMaxValor(Integer[] X){
        if(X.length==0)
            return -1;
        Integer max=X[0];
        for(int i=1;i<X.length;i++){
            if(X[i]>max)
                max=X[i];         
        }
        return max;
    }
    public Integer getMinValor(Integer[] X){
        if(X.length==0)
            return -1;
        Integer min=X[0];
        for(int i=1;i<X.length;i++){
            if(X[i]<min)
                min=X[i];         
        }
        return min;
    }
}
