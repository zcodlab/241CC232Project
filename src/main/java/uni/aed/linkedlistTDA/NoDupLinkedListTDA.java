/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.linkedlistTDA;

/**
 * 241:2PC-Enunciado1
 * Esta clase extiene la logica del metodo añadir con la finalidad de no permitir el registro de valores duplicados
 * @author
 */
public class NoDupLinkedListTDA<E> extends LinkedListTDA{
    private static final int ENCONTRADO=-1;
    public int addNoDup(E data) {
        if(!this.contain(data))            
            add(data);
        else
            return ENCONTRADO;        
        return 0;
    }

    
    public int addNoDup(int index, E data) throws IndexOutOfBoundsException {
        revisaPosInsercion(index);
        if(!this.contain(data))
            add(index,data);            
        else
            return ENCONTRADO;
        return 0;   
    }
    
}
