/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.directorio;

import javax.swing.JOptionPane;
import uni.aed.model.Persona;
/**
 *
 * @author hp
 */
public class DirectorioMain {
    public static void main(String[] args) {
        DirectorioMain tester = new DirectorioMain();
        tester.start();
    }

    private void start( ) {
        String[] name = {"ape", "cat", "bee", "bat", "eel",
                         "dog", "gnu", "yak", "fox", "cow",
                         "hen", "tic", "man"};
        Persona p;
        Directorio ab;

        int version = Integer.parseInt(
                        JOptionPane.showInputDialog(null,"Uso de Directorio Version #:"));

        switch (version) {
            case 1:  ab = new DirectorioV1(); break;
            case 2:  ab = new DirectorioV2(); break;            
            default: ab = new DirectorioV1(); break;
        }

        for (int i = 0; i < name.length; i++) {
            p = new Persona(name[i], random(10, 50),
                            random(0,1)==0?'M':'F'); //if(random(0,1) ==0) 'M' else 'F'
            ab.add(p);
        }
        System.out.println("Visualizando el Directorio");
        System.out.println( ab.toString());
        
        System.out.println(" ");
        
        Persona[] sortedlist = ab.sort( Persona.AGE );
        for (int i = 0; i < sortedlist.length; i++) {
            System.out.println( sortedlist[i].toString( ) );
        }
        
        System.out.println(" ");
        System.out.println("Visualizando el Directorio");
        System.out.println( ab.toString());
        
        System.out.println(" ");

        sortedlist = ab.sort( Persona.NAME );
        for (int i = 0; i < sortedlist.length; i++) {
            System.out.println( sortedlist[i].toString( ) );
        }
        
        System.out.println(" ");
        System.out.println("Visualizando el Directorio");
        System.out.println( ab.toString());
    }    
    

    /**
     * Returns a random integer between low
     * and high, inclusive.
     *
     * @param low  the low bound of the random number
     * @param high the high bound of the random number
     *
     * @return a random integer between low and high
     */
    private int random(int low, int high) {
        return (int) Math.floor(Math.random() * (high - low + 1)) + low;
    }
}
