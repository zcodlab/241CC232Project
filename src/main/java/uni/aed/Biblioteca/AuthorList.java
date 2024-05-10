package uni.aed.Biblioteca;
/*
    @20224025A
*/

//import java.util.LinkedList;
import uni.aed.linkedlistTDA.LinkedListTDA;
import uni.aed.model.Author;

public class AuthorList extends LinkedListTDA {
    public AuthorList() {
        super();
    }
    //enlita los autores 
    public void display() {
        Object[] authors = toArray(); //transforma la lista en un array
        
        for (int i = 0; i < authors.length; i++)
            ((Author)authors[i]).display(); //Le manda una instruccion de display a cada uno de sus elementos
    }

    /*Implementado para el GUI*/
    public String toString() { 
        String cadena =""; //cadena a retornar
        Object[] authors = toArray(); //lo convertimos en array
        
        for (int i = 0; i < authors.length; i++)
            cadena =   cadena + " \\\\ " +((Author)authors[i]).toString() ;
        //aplicamos el metodoto String a cada elemento
        return cadena;
    }
    
    
}