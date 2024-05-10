package uni.aed.Biblioteca;
/*
    @20224025A
*/

//import java.util.LinkedList;
import uni.aed.linkedlistTDA.LinkedListTDA;


public class BookList extends LinkedListTDA {
    public BookList() {
        super();
    }
    //Escribe la lista de libros
    public void display() {
        for (int i = 0; i < size(); i++)
            System.out.print(get(i));//llama a cada elemento de cada indice y lo imprime
    }
    
    /*Implementado para el GUI*/
    public String toString() {
        String cadena=""; //inicializamos la cadena
        
        for (int i = 0; i < size(); i++)
            cadena = cadena + get(i);//llama a cada elemento de cada indice y lo concatena
        
        return cadena;
    }
}