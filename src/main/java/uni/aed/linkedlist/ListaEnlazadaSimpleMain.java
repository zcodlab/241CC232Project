/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.linkedlist;

/**
 *
 * @author hp
 */
public class ListaEnlazadaSimpleMain {
    public static void main(String[] args){
        ListaEnlazadaSimpleMain listaMain=new ListaEnlazadaSimpleMain();
        listaMain.ListaEnlazadaSimple();        
    }
    private void ListaEnlazadaSimple(){
        ListaEnlazadaSimple lista=new ListaEnlazadaSimple();
        lista.addLast(10);
        lista.addLast(20);
        lista.addLast(30);
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());
        
        System.out.println("Eliminando un elemento");
        lista.remove(20);
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());
        
    }
    
}
