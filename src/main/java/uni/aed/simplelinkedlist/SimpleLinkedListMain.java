/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.simplelinkedlist;

/**
 *
 * @author hp
 */
public class SimpleLinkedListMain {
    public static void main(String[] args){
        SimpleLinkedListMain listaMain=new SimpleLinkedListMain();
        listaMain.ListaEnlazadaSimple();        
    }
    private void ListaEnlazadaSimple(){
        SimpleLinkedList lista=new SimpleLinkedList();
        lista.addLast(10);
        lista.addLast(20);
        lista.addLast(30);
        lista.addFirst(40);
        lista.addToPosition(2,60);
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());
        
        System.out.println("Eliminando un elemento: 20");
        lista.remove(20);
        
        System.out.println("Buscando el elemento: 60");
        int result=lista.search(60);
        if(result==-1)
            System.out.println("El elemento no se ubico en la lista");
        else
            System.out.println("El elemento se ubico en la lista, en la posicion"+ result);
            
        
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());
        
    }
    
}
