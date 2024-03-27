/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.search;

import java.util.Scanner;

/**
 * programa que invoca el algoritmo de busqueda Lineal
 * @author uni.cc232
 */
public class SearchMain {
    public static void main(String[] args){
        Scanner scr=new Scanner(System.in);
        Search s=new Search();
        Integer X[]={15,1,25,60,69,86,3,78,2,10};
        System.out.println("Ingrese el valor a buscar:");
        int valor =scr.nextInt();
        int pos=s.Lineal(X, valor);        
        if (pos==-1)
            System.out.println("El numero " + valor + " no existe en la lista");
        else
            System.out.println("El numero " + valor + " se ubico en la lista en la posicion "+ pos);
        
        System.out.println("El Array contiene los siguientes elementos:");
        for(int i=0;i<X.length;i++)
            System.out.print(X[i]+",");
        System.out.println("");        
    }
    
}
