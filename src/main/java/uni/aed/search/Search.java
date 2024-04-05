package uni.aed.search;
/**
 * Algoritmo de busqueda Lineal, considerando un Array de numeros enteros
 * @author uni.cc232
 */
public class Search {
    public final int NO_ENCONTRADO=-1;
    
    public int searchLineal(Integer[] X, int valor){
        int loc=0;
        while(loc<X.length && X[loc]!=valor){
            loc++;
        }
        if(loc==X.length)
            return NO_ENCONTRADO;
        else
            return loc;
    }
    public int searchBinaria(Integer[] X, int valor){
        int bajo=0,alto=X.length-1,
        medio=(bajo+alto)/2;
        while(bajo<=alto && X[medio]!=valor){
            if(X[medio]<valor)
                bajo=medio+1;
            else
                alto=medio-1;
            medio=(bajo + alto)/2;            
        }
        if(bajo>alto)
            medio=NO_ENCONTRADO;
        return medio;        
    }
    
}
