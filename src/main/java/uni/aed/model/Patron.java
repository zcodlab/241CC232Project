package uni.aed.model;
/*
    @20224025A
*/
/*Modela a un usuario de la biblioteca*/
import uni.aed.Biblioteca.BookList;

public class Patron {
    public String name; //Nombre del ususario
    public BookList books = new BookList();//libros pedidos por el usuario
    
    public Patron() {
    }
    
    @Override
    public boolean equals(Object node) {    //compara el nombre de dos usuarios
        return name.equals(((Patron) node).name);
    }
    
    public void display() {
        if (!books.isEmpty()) { //En caso la lista de libros no este vacia
        System.out.println(name + " tiene los siguientes libros:"); //escribe el nombre
        books.display();   //y la lista los libros
        }
        else System.out.print(name + " no tiene libros"); //caso contrario solo muestra que no tiene libros siendo usados
    }
    
    /*Implementado para el GUI*/
    @Override
    public String toString() {
        String cadena="";  //inicializamos la cadena que retornaremos
        
        if (!books.isEmpty()) //para una lista no vacia retorna un string con 
            cadena = cadena+ " \\\\ " + name + " tiene los siguientes libros: "+ books; //El nombre  y los librps que esta usando
        else    
             cadena = cadena + "\\\\"  + name + " no tiene libros"; //En caso no tenga libros, lo muestra explicitamente
        
        return cadena;
    }
    
    
}