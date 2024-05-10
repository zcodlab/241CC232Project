package uni.aed.model;
/*
    @20224025A
*/

/*modela un prestamo, contiene el autor y un libro */
public class CheckedOutBook {
    public Author author = null;
    public Book book = null;
    public CheckedOutBook() {
    }
    
    @Override
    public boolean equals(Object node) {//compara dos objetos CheckedOutBook
        return book.title.equals(((CheckedOutBook) node).book.title) &&
                author.name.equals(((CheckedOutBook) node).author.name); //verifica la igualdad del titulo del libro y el no,bre del autor
    }
    
    @Override
    public String toString() { //Retorna un string con el nombre del autor y el titulo del libro
        return " * " + author.name + ": " + book.title ;
    }
}