package uni.aed.model;
/*
    @20224025A
*/

import uni.aed.Biblioteca.BookList;

/*Esta clase modela a un autor, cada autor tiene un nombre 
    y una coleccion de libros de su autoria*/

public class Author{  
    public String name; //nombre del autor   
    public BookList books = new BookList(); //coleccion de libros    
    
    public Author() {
    }

    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object node) { 
        return name.equals(((Author) node).name);   //compara el nombre de este autor
    }                                                       //con el nombre de un autor dado
    
    public void display() {         //Metodo para escribir en el terminal 
        System.out.println(name); //el nombre del autor y sus libros  
        books.display();
    }
    
    /*Implementado para el GUI*/
    @Override
    public String toString() {    //Analogo a display
        return name  + books ;  //retorna una cadena con con el nombre del autor y sus libros
    }
    
}