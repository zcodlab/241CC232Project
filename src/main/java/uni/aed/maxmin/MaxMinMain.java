package uni.aed.maxmin;

public class MaxMinMain {
    public static void main(String[] args){
        MaxMin mm=new MaxMin();
        Integer X[]={15,1,25,60,69,86,3,78,2,10};
        System.out.println("El Array contiene los siguientes elementos:");
        for(int i=0;i<X.length;i++)
            System.out.print(X[i]+",");
        System.out.println("");
        System.out.println("El valor maximo es:"+ mm.getMaxValor(X).toString());
        System.out.println("El valor minimo es:"+ mm.getMinValor(X).toString());        
    }
}
