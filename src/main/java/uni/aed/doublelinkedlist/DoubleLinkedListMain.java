/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.doublelinkedlist;
/**
 *
 * @author hp
 */
public class DoubleLinkedListMain {
    public static void main(String[] args) {
        DoubleLinkedListMain lista=new DoubleLinkedListMain();
        lista.doubleLinkedList();
        
    }
    private void doubleLinkedList(){
        DoubleLinkedList dll=new DoubleLinkedList();
        dll.addLast(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.addFirst(5);       
        
        System.out.println(dll.toString());                
        
        System.out.println("Eliminando un elemento");        
        dll.remove(20);
        System.out.println(dll.toString());        
        
        System.out.println("Eliminando un elemento que no existe:20");        
        dll.remove(20);
        System.out.println(dll.toString());        
    }
    
}
