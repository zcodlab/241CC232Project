package uni.aed.search;
/**
 * Algoritmo de busqueda Lineal, considerando un Array de numeros enteros
 * @author uni.cc232
 */
public class Search {
    public final int NO_ENCONTRADO=-1;
    
    public int Lineal(Integer[] X, int valor){
        int loc=0;
        while(loc<X.length && X[loc]!=valor){
            loc++;
        }
        if(loc==X.length)
            return NO_ENCONTRADO;
        else
            return loc;
    }
    
}
