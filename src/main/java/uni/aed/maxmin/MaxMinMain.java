/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.maxmin;

import java.util.Scanner;
/**
 * Programa que permite realizar las operaciones de Carga de datos en un array de numeros enteros,
 * Visualizar el contenido de un Array, Obtener el maximo y el minimo valor de un Array.
 * @author uni.cc232
 */
public class MaxMinMain {    
        
    public static void main(String[] args){        
        Scanner scr=new Scanner(System.in);
        int opcion=1;		
	String Rpta="S";				
	String SEPARADOR="\n";	                    
        Integer[] X = null;
        do			
	{	
            System.out.print("Algoritmos Maximo-Mínimo"+SEPARADOR+
                "1.- Carga de Datos en Array "+SEPARADOR+
                "2.- Visualizar Array "+SEPARADOR+                
                "3.- Maximo-Minimo "+SEPARADOR+                
                "4.- Salir "+SEPARADOR+"Elija una opcion:");
            opcion =scr.nextInt();
            switch (opcion)
            {
		case 1 -> {X=carga();}
                case 2 -> {visualizar(X);}
                case 3 -> {getMaxMin(X);}
                default -> {break;}
            }	            
            System.out.print("Para continuar con las operaciones pulsa S; Para finalizar pulse N: ");
            Rpta=scr.next().toUpperCase();			
        }while(Rpta.equals("S")==true);	
    }
    public static Integer[] carga(){
        Scanner scr=new Scanner(System.in);
        System.out.println("Ingrese el tamaño del Array");
        int N=scr.nextInt();
        Integer[] X =new Integer[N];
        for(int i=0;i<X.length;i++){
            System.out.print("Ingrese el valor X["+i+"]=");
            X[i]=scr.nextInt();
        }
        return X;
    }
    public static void visualizar(Integer[] X){        
        System.out.println("El Array contiene los siguientes elementos:");
        for(Integer i=0;i<X.length;i++){
            System.out.print(X[i]+",");
        }
        System.out.println("");
    }
    public static void getMaxMin(Integer[] X){                
        //Proceso
        MaxMin mm=new MaxMin();        
        //Salida        
        System.out.println("");
        System.out.println("El maximo valor es: "+ mm.getMaxValor(X).toString());
        System.out.println("El minimo valor es: "+ mm.getMinValor(X).toString());
    }
    public static void determinaMaxMin(){
        MaxMin mm=new MaxMin();
        Integer X[]={15,1,25,60,69,86,3,78,2,10};
        System.out.println("El Array contiene los siguientes elementos:");
        for(Integer i=0;i<X.length;i++){
            System.out.print(X[i]+",");
        }
        System.out.println("");
        System.out.println("El maximo valor es: "+ mm.getMaxValor(X).toString());
        System.out.println("El minimo valor es: "+ mm.getMinValor(X).toString());
        
    }
}
