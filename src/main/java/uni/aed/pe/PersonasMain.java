/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.pe;

/**
 * Prueba de Entrada 241
 * Programa que que permite registrar tres personas y calcular sus edad promedio
 * @author uni.cc232
 */
public class PersonasMain {
    public static void main(String[] args){        
        Personas personal=new Personas(4);
        Persona p1=new Persona("Sonya Smith",30,'F');
        Persona p2=new Persona("Barack Obama",60,'M');
        Persona p3=new Persona("Dina Boluarte",50,'F');
        Persona p4=new Persona("Mick Jagger",75,'M');
        
        personal.insertarPersona(p1);
        personal.insertarPersona(p2);
        personal.insertarPersona(p3);
        personal.insertarPersona(p4);
        
        System.out.println(personal.toString());
        
        System.out.println("La edad promedio del personal es: "+ personal.calcularEdadPromedio());
        
    }
}
