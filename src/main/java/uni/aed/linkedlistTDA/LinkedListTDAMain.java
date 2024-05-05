package uni.aed.linkedlistTDA;

import uni.aed.listTDA.ListTDA;
import uni.aed.model.Persona;

public class LinkedListTDAMain {
    public static void main(String[] args) {
        LinkedListTDAMain listaTDA=new LinkedListTDAMain();   
        listaTDA.linkedListString();
        listaTDA.linkedListPersona();
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
