package uni.aed.Biblioteca;

/**
 *
 * Esta clase implementa las pricipales metodos de una Biblioteca para invocarlas desde una GUI
 */
import uni.aed.model.CheckedOutBook;
import uni.aed.model.Author;
import uni.aed.model.Book;
import uni.aed.model.Patron;

public class LibraryToGUI {
    private AuthorList[] catalog = new AuthorList[(int)('Z'+1)];//array donde cada elemento es una 
                                                            //lista de autores cuyo nombre empieza con la misma letra
    private PatronList[] people = new PatronList[(int)('Z'+1)];//array donde cada elemento es una 
                                                            //lista de usuarios cuyo nombre empieza con la misma letra
    
    public LibraryToGUI() {
        for (int i = 0; i <= (int) 'Z'; i++) {
            catalog[i] = new AuthorList(); //inicializamos todos los elementos de catalog y people
            people[i] = new PatronList();//como listas vacias, así solo agregaremos elementos mas adelante
        }
    }
    
    public String statusBooks(int i) { //requerimos de un parametro i que seria el indice
        String cadena ;
 
        if (!catalog[i].isEmpty())  //en caso el elemento de ese indice no este vacio
            cadena = catalog[i].toString(); //lo convierte a string
        else
            cadena = null; //en caso este vacio hacemos que el objeto sea nulo
        
        return cadena; //retornamos
    }
    
    public String statusPatrons(int i) {//requerimos de un parametro i que seria el indice
        String cadena ;

        if (!people[i].isEmpty())  //en caso el elemento de ese indice no este vacio
           cadena = people[i].toString();//lo convierte a string
        else 
            cadena = null;//en caso este vacio hacemos que el objeto sea nulo

        return cadena;//retornamos
    }        
    
    public void includeBook(String nomAutor, String titLibro) {//pedimos dos parametros
        Author newAuthor = new Author();
        int oldAuthor;
        Book newBook = new Book();
        newAuthor.name = nomAutor;
        newBook.title = titLibro;
        
        oldAuthor = catalog[(int)newAuthor.name.charAt(0)].indexOf(newAuthor);
        
        if (oldAuthor == -1) {
            newAuthor.books.add(newBook);
            catalog[(int) newAuthor.name.charAt(0)].add(newAuthor);
        }else 
            ((Author)catalog[(int)newAuthor.name.charAt(0)].get(oldAuthor)).books.add(newBook);
        }   
    
    public int checkOutBook(String nomAutor, String nomUsuario, String titLibro) {//pedimos los nombres de cada atributo
        Patron patron = new Patron(), patronRef;
        Author author = new Author(), authorRef = new Author();
        Book book = new Book();
        
        int patronIndex, bookIndex = -1, authorIndex = -1;
        patron.name = nomUsuario; //asignamos el paramtero correspondiente
        
        while (authorIndex == -1) { 
            author.name = nomAutor;//asignamos el parametro correspondiente
            authorIndex = catalog[(int)
            author.name.charAt(0)].indexOf(author);
            
            if (authorIndex == -1)
                return -1; //retornamos -1, necesario para el GUI
        }
        while (bookIndex == -1) {
            book.title = titLibro;//asignamos el parametro correspondiente
            authorRef = (Author) catalog[(int)
            author.name.charAt(0)].get(authorIndex);
            bookIndex = authorRef.books.indexOf(book);
            if (bookIndex == -1)
                return -2;//retornamos -2, necesario para el GUI
        }
        
        Book bookRef = (Book) authorRef.books.get(bookIndex);
        CheckedOutBook bookToCheckOut = new CheckedOutBook();
        bookToCheckOut.author = authorRef;  
        bookToCheckOut.book = bookRef;
        patronIndex = people[(int)
        patron.name.charAt(0)].indexOf(patron);
       
        if (patronIndex == -1) { 
            patron.books.add(bookToCheckOut);  
            people[(int) patron.name.charAt(0)].add(patron);
            bookRef.patron = (Patron) people[(int)
                    patron.name.charAt(0)].get(0);
            
        }else{
            patronRef = (Patron) people[(int)
            patron.name.charAt(0)].get(patronIndex);
            patronRef.books.add(bookToCheckOut);
            bookRef.patron = patronRef;
        }
        return 0;
    }    
    
    public int returnBook(String nomAutor, String nomUsuario, String titLibro) {//pedimos 3 paramteros
        Patron patron = new Patron();
        Book book = new Book();
        Author author = new Author(), authorRef = new Author();
        int patronIndex = -1, bookIndex = -1, authorIndex = -1;
        
        while (patronIndex == -1) {
            patron.name = nomUsuario;//asignamos parametro correspondiente
            patronIndex = people[(int)
            patron.name.charAt(0)].indexOf(patron);
           
            if (patronIndex == -1)
                return -1;//En caso no exista 
        }
        
        while (authorIndex == -1) {
            author.name = nomAutor;//asignamos parametro correspondiente
            authorIndex = catalog[(int)
            author.name.charAt(0)].indexOf(author);
            
            if (authorIndex == -1)
                return -2;//En caso no exista 
        }
        
        while (bookIndex == -1) {
            book.title = titLibro;//asignamos parametro correspondiente
            authorRef = (Author) catalog[(int)
            author.name.charAt(0)].get(authorIndex);
            bookIndex = authorRef.books.indexOf(book);
                if (bookIndex == -1)
                    return -3;//En caso no exista 
            }
            CheckedOutBook checkedOutBook = new CheckedOutBook();
            checkedOutBook.author = authorRef;
            checkedOutBook.book = (Book) authorRef.books.get(bookIndex);
            ((Book)authorRef.books.get(bookIndex)).patron = null;
            ((Patron)people[(int) patron.name.charAt(0)].get(patronIndex)).
            books.delete(checkedOutBook);
            return 0;
        }
}
