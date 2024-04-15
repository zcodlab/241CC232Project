/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.linkedlist;

/**
 *
 * @author hp
 */
public class Nodo {
    int data;
    Nodo next;

    public Nodo(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Nodo getNext() {
        return next;
    }
    
}
