package uni.aed.Biblioteca;
/*
    @20224025A
*/


import uni.aed.linkedlistTDA.LinkedListTDA;
import uni.aed.model.Patron;


public class PatronList extends LinkedListTDA {
    public PatronList() {
        super();
    }
    //recorre el arreglo para imprimir la informacion requerida de cada usuario
    public void display() {
        Object[] patrons = toArray(); //transforma la lista en un array
        
        for (int i = 0; i < patrons.length; i++)
            ((Patron)patrons[i]).display();
    }

    /*implementado para el GUI*/
    @Override
    public String toString() {
        String cadena="";//inicializa la cadena
        
        Object[] patrons = toArray(); //transforma la lista en un array
        
        for (int i = 0; i < patrons.length; i++)
            cadena = cadena +((Patron)patrons[i]).toString(); //recorre la lista y concatena la informacion de cada usuario
        
        return cadena;
    }
    
}
