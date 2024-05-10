package uni.aed.Biblioteca;

/**
 *
 * Esta clase implementa las pricipales operaciones de una Biblioteca
 */
import uni.aed.model.CheckedOutBook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import uni.aed.model.Author;
import uni.aed.model.Book;
import uni.aed.model.Patron;

public class Library {
    private AuthorList[] catalog = new AuthorList[(int)('Z'+1)];//array donde cada elemento es una 
                                                            //lista de autores cuyo nombre empieza con la misma letra
    private PatronList[] people = new PatronList[(int)('Z'+1)];//array donde cada elemento es una 
                                                            //lista de usuarios cuyo nombre empieza con la misma letra
    private String input;  //usado para leer String introducidas por el usuario
    private BufferedReader buffer = new BufferedReader(
                                        new InputStreamReader(System.in)); //trabaja junto con el input
    
    public Library() {
        for (int i = 0; i <= (int) 'Z'; i++) {
            catalog[i] = new AuthorList(); //inicializamos todos los elementos de catalog y people
            people[i] = new PatronList();//como listas vacias, así solo agregaremos elementos mas adelante
        }
    }
       /*Para obtener una string ingresada por el usuario mostrando previamente un mensaje*/
    public String getString(String msg) {
        System.out.print(msg + " "); //Imprime el mensaje
        System.out.flush(); //Limpia el buffer
        
        try {
            input = buffer.readLine(); //lee una linea
        } catch(IOException io) {
        }//nos aseguramos de colocar las excepciones
        return input.substring(0,1).toUpperCase() + input.substring(1);
                //retornamos el string ingresado con la primera letra en mayuscula
    }
    
    /*depliega toda la informacion que tenemos de la libreria*/
    public void status() {
        System.out.println("La biblioteca tiene los siguientes libros:\n ");
        
        for (int i = (int) 'A'; i <= (int) 'Z'; i++) //para cada elemento de catalog
            if (!catalog[i].isEmpty())//verificamos q no este vacio
                catalog[i].display();//y en ese caso lo imprimimos
        
        System.out.println("\nLas siguientes personas estan usando la biblioteca:\n ");
        
        for (int i = (int) 'A'; i <= (int) 'Z'; i++)//para cada elemento de people
            if (!people[i].isEmpty())//verificamos q no este vacio
                people[i].display();//y en ese caso lo imprimimos
    }

    /*metodo para ingresar un libro a la libreria*/
    public void includeBook() {
        Author newAuthor = new Author();//un nuevo autor que añadiremoso en caso exista ubicaremos en la lista
        int oldAuthor;// indice para ver si newAuthor se encuentra o no
        Book newBook = new Book(); //nuevo libro, analogo a newAuthor
        
        newAuthor.name = getString("Ingrese el nombre del autor:"); //pedimos el nombre del autor
        newBook.title = getString("Ingrese el titulo del libro:");//pedimos el titulo del libro
        
        /*(int)newAuthor.name.charAt(0) -> busca el numero que le corresponde a la primera letra del nombre del autor
        este seria el indice, al que accedemos en catalog, catalog[i] es una lista
        en esta lista pedimos el indice donde se encuentra newAuthor*/
        oldAuthor = catalog[(int)newAuthor.name.charAt(0)].indexOf(newAuthor); 
        
        if (oldAuthor == -1) {//caso en el que no se encuentra
            newAuthor.books.add(newBook); //primero añade newBook a la lista de libros de newAuthor
            catalog[(int) newAuthor.name.charAt(0)].add(newAuthor); //a la lista que obtuvimos antes le añadimos newAuthor
        }else 
            ((Author)catalog[(int) newAuthor.name.charAt(0)].get(oldAuthor)).books.add(newBook);
        //caso en el que se encuentra
        //solo añadimos a la lista de libros del autor ya existente newBook
    }
    
    /*metodo para el prestamo de un libro*/
    public void checkOutBook() {
        Patron patron = new Patron(), patronRef; //un patron y otro de apoyo
        Author author = new Author(), authorRef = new Author(); //un autor y uno de apoyo
        Book book = new Book(); //un nuevo libro
        
        int patronIndex, bookIndex = -1, authorIndex = -1; 
            //variables para los indices, inicializamos dos en -1 para ingresar al bul¿cle while 
        
        
        patron.name = getString("Introduzca el nombre del usuario:"); //introducimos el nombre del usuario
        
        while (authorIndex == -1) { 
            author.name = getString("Ingrese el nombre del autor:");//ingresamos el nombre del autor
            //pedimos el indice del autor de la lista que le corresponde la primera letra del nombre
            authorIndex = catalog[(int)
            author.name.charAt(0)].indexOf(author);
            
            if (authorIndex == -1)//en caso no exista ´lo pedimos nuevamente
                System.out.println("Nombre del autor mal escrito");
        }
        
        while (bookIndex == -1) {
            book.title = getString("Ingrese el titulo del libro:");//ingresamos el titulo del libro
            //previamente confirmamos que el autor ya existe
            //accedemos a ese autor mediante authorIndex
            authorRef = (Author) catalog[(int)
            author.name.charAt(0)].get(authorIndex);
            //en la lista de libros del autor buscamos el libro 
            bookIndex = authorRef.books.indexOf(book);
            
            if (bookIndex == -1)//en caso no se encuentre lo pedimos nuevamente
                System.out.println("Titulo mal escrito");
        }
        
        Book bookRef = (Book) authorRef.books.get(bookIndex); //usamos otra instancia de BOok 
        CheckedOutBook bookToCheckOut = new CheckedOutBook();//hacemos una instancia de CheckedOutBook
        bookToCheckOut.author = authorRef;  //introducimos a sus atributos 
        bookToCheckOut.book = bookRef;//los elementos que tenemos
        patronIndex = people[(int)
        patron.name.charAt(0)].indexOf(patron); //buscamos el indice donde se encuentra el usuario que escribimos
        
        if (patronIndex == -1) { // en caso no se encuentre
            patron.books.add(bookToCheckOut);   //primero agregamos el libro a la lista de libros del usuario
            people[(int) patron.name.charAt(0)].add(patron);//luego añadimos el usuario a la lista que le correpsonde al indice de su primera letra
            bookRef.patron = (Patron) people[(int)
                    patron.name.charAt(0)].get(0);//añadimos al usuario de bookRef el usuario que tenemos
            
        }else{
            patronRef = (Patron) people[(int)
            patron.name.charAt(0)].get(patronIndex); //accedemos al usuario que le corresponde el indice que calculamos
            patronRef.books.add(bookToCheckOut); //a ese usuario le añadimos el libro a su lista de libros
            bookRef.patron = patronRef;//añadimos el usuario correspondiente
        }
    }

    /*metodo para la devolucion de un libro*/
    public void returnBook() {
        Patron patron = new Patron();//instancia de patron
        Book book = new Book();//instancia de book
        Author author = new Author(), authorRef = new Author();//dos instancias de Author
        int patronIndex = -1, bookIndex = -1, authorIndex = -1;
         //variables para los indices, inicializamos dos en -1 para ingresar al bul¿cle while 
         
        while (patronIndex == -1) {
            patron.name = getString("Ingrese el nombre del usuario:");//ingresamos el nombre del autor
            //pedimos el indice del autor de la lista que le corresponde la primera letra del nombre
            patronIndex = people[(int)
            patron.name.charAt(0)].indexOf(patron);
            if (patronIndex == -1)// En caso no exista lo pedimos nuevamente
            System.out.println("Nombre del usuario mal escrito");
        }
        
        while (authorIndex == -1) {
            author.name = getString("Ingrese el nombre del autor:");// Ingresamos el título del libro
            
            // Pedimos el indice que le corresponde al autor en la lista que le corresponde
            authorIndex = catalog[(int)
            author.name.charAt(0)].indexOf(author);
            if (authorIndex == -1)// En caso no exista lo pedimos nuevamente
            System.out.println("Nombre del auotor mal escrito");
        }
        
        while (bookIndex == -1) {
            book.title = getString("Ingrese el titulo del libro:");//Pedimos el titulo del libro
            
            //previamente confirmamos que el autor existtia entonces lo llamamos mediante su indice
            authorRef = (Author) catalog[(int)
            author.name.charAt(0)].get(authorIndex);
            bookIndex = authorRef.books.indexOf(book);//pedimos el indice del libro en la lista del autor
                if (bookIndex == -1)//Si no se encuentra pedimos nuevamente
                    System.out.println("Titulo mal escrito");
            }
            //nos apoyamos en CheckedOutBook instanciandolo y llenando sus atributos
            CheckedOutBook checkedOutBook = new CheckedOutBook();
            checkedOutBook.author = authorRef;
            checkedOutBook.book = (Book) authorRef.books.get(bookIndex);
            ((Book)authorRef.books.get(bookIndex)).patron = null; //desconectamos del usuario el libro que ya fue devuelto
            ((Patron)people[(int) patron.name.charAt(0)].get(patronIndex)).books.delete(checkedOutBook);//y tambien lo sacamos de la lista de libros del usuario
        }   
    
}
