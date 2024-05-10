package uni.aed.model;
/*
    @20224025A
*/
/*Clase que modela un libro
    contiene titulo y el usuario que accede al libro*/
public class Book {
    public String title;  //Titulo
    public Patron patron = null;    //usuario que accede al libro    
   
    public Book() {
    }
    
    @Override
    public boolean equals(Object node) {
        return title.equals(((Book) node).title);   //Compara los titulos de dos libros
    }
    
    
    @Override
    public String toString() {  //Retorna el titulo y si esta siendo usado en forma de string
        return " * " + title +
        (patron != null ? " - checked out to " + patron.name : "") +
        "\n";
    }
}