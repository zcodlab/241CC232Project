package uni.aed.linkedlistTDA;

import java.util.InputMismatchException;
import java.util.Scanner;
import uni.aed.listTDA.ListTDA;
import uni.aed.model.Persona;

public class LinkedListTDAMain {
    public static void main(String[] args) {
        LinkedListTDAMain listaTDA=new LinkedListTDAMain();   
        listaTDA.menu();
    }
    private void menu(){
        Scanner scr=new Scanner(System.in).useDelimiter("\n");
        int opcion=1;		
	String Rpta="S";				
	String SEPARADOR="\n";	                            
        try{
            
            do			
            {	
                System.out.print("Listas Enlazadas"+SEPARADOR+
                "1.- Añadir Numeros "+SEPARADOR+
                "2.- Añadir Personas "+SEPARADOR+                
                "3.- Salir "+SEPARADOR+"Elija una opcion:");                
                opcion =scr.nextInt();            
                switch (opcion)
                {
                    case 1 -> {noDupLinkedListTDAEnteros();}
                    case 2 -> {noDupLinkedListTDAPersonas();}                    
                    default -> {break;}
                }	            
                System.out.print("Para continuar con las operaciones pulsa S; Para finalizar pulse N: ");
                Rpta=scr.next().toUpperCase();			
            }while(Rpta.equals("S")==true);	
        }catch(InputMismatchException ex) {
            System.out.println("Debe ingresar obligatoriamente un número entero como opcion elegida.");
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
    private void noDupLinkedListTDAEnteros(){
        Scanner scr=new Scanner(System.in).useDelimiter("\n");
        String Rpta="S";
        NoDupLinkedListTDA<Integer> lista=new NoDupLinkedListTDA();
        do{
            System.out.println("Digite un numero");
            int n = scr.nextInt();
            if (lista.addNoDup(n)==-1)                 
                System.out.println("El numero ingresado ya existe en la lista, la lista no permite duplicados");
            System.out.println("¿Desea continuar? Pulse n para detenerse. ");
            Rpta=scr.next().toUpperCase();
        }while(Rpta.equals("S")==true);
        System.out.println(lista.toString());
    }
    private void noDupLinkedListTDAPersonas(){
        Scanner scr=new Scanner(System.in).useDelimiter("\n");
        NoDupLinkedListTDA<Persona> lista=new NoDupLinkedListTDA();
        String Rpta="S";
        do{
            System.out.println("Ingrese Nombre de la Persona:");
            String nombre = scr.next().toUpperCase();
            System.out.println("Ingrese Edad de la Persona:");
            int edad = scr.nextInt();
            System.out.println("Ingrese Genero(F/M) de la Persona:");
            char genero = scr.next().toUpperCase().charAt(0);
            if (lista.addNoDup(new Persona(nombre,edad,genero))==-1)
                System.out.println("La Persona ingresada ya existe en la lista, la lista no permite duplicados");
            System.out.println("¿Desea continuar? Pulse n para detenerse. ");
            Rpta=scr.next().toUpperCase();
        }while(Rpta.equals("S")==true);
        System.out.println(lista.toString());
    }
    private void linkedListString(){
        ListTDA<String> linkedListTDA = new LinkedListTDA<>();
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+linkedListTDA.size());
        linkedListTDA.add("Jose");
        linkedListTDA.add("Beatriz");
        linkedListTDA.add("Sandro");
        linkedListTDA.add("Franklin");
        linkedListTDA.add(2,"Adelaida");        
        System.out.println("Despues de añadir elementos:");	
        System.out.println("Size = "+linkedListTDA.size());
        System.out.println(linkedListTDA.toString());
        String elemento="Adelaida";
        if (linkedListTDA.contain(elemento)==true){            
            System.out.println("El elemento buscado: "+ elemento +" se encuentra en la posicion: "+ linkedListTDA.indexOf(elemento)+" se procedera a su eliminacion.");            
            System.out.println("Eliminando el elemento "+ elemento +" luego de ubicarlo en la lista");
            linkedListTDA.delete(linkedListTDA.indexOf(elemento));
        }else
            System.out.println("El elemento buscado no se encuentra en el Registro");
        //imprimiendo elementos de la LinkedList        
        System.out.println("Añadiedo 1 registro en la posicion 2: Steve Jobs");
        linkedListTDA.add(2, "Steve Jobs");
        //imprimiendo elementos de la LinkedList
        System.out.println(linkedListTDA.toString()); 
    }
    private void linkedListPersona(){
        ListTDA<Persona> linkedListTDA = new LinkedListTDA<>();
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+linkedListTDA.size());
        
        Persona p1=new Persona("Sonya Smith",30,'F');
        Persona p2=new Persona("Barack Obama",60,'M');
        Persona p3=new Persona("Dina Boluarte",50,'F');
        Persona p4=new Persona("Mick Jagger",75,'M');
        
        linkedListTDA.add(p1);
        linkedListTDA.add(p2);
        linkedListTDA.add(p3);
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+linkedListTDA.size());
        System.out.println(linkedListTDA.toString());
                
        linkedListTDA.add(1,p4);   
        System.out.println("Despues de añadir 1 elemento: Mick Jagger, posicion 1");	
        System.out.println("Size = "+linkedListTDA.size());        
        System.out.println(linkedListTDA.toString());
        
        System.out.println("Buscando 1 elemento: Elon Musk");	
        Persona p5=new Persona("Elon Musk",60,'M');
        if (linkedListTDA.contain(p5)==true){            
            System.out.println("El elemento buscado: "+ p5.getName() +" se encuentra en la posicion: "+ linkedListTDA.indexOf(p5)+" se procedera a su eliminacion.");            
            System.out.println("Eliminando el elemento "+ p5.getName() +" luego de ubicarlo en la lista");
            linkedListTDA.delete(linkedListTDA.indexOf(p5));
        }else
            System.out.println("El elemento buscado no se encuentra en el Registro");
        
        System.out.println("Buscando 1 elemento: Barack Obama");
        if (linkedListTDA.contain(p2)==true){            
            System.out.println("El elemento buscado: "+ p2.getName() +" se encuentra en la posicion: "+ linkedListTDA.indexOf(p2)+" se procedera a su eliminacion.");            
            System.out.println("Eliminando el elemento "+ p2.getName() +" luego de ubicarlo en la lista");
            linkedListTDA.delete(linkedListTDA.indexOf(p2));
        }else
            System.out.println("El elemento buscado no se encuentra en el Registro");
        //imprimiendo elementos de la LinkedList        
        System.out.println(linkedListTDA.toString());
        
        System.out.println("Añadiedo 1 registro en la posicion 2: Zhang Yiming");
        linkedListTDA.add(2, new Persona("Zhang Yiming",45,'M'));
        //imprimiendo elementos de la LinkedList        
        System.out.println(linkedListTDA.toString());
    }
}
