package uni.aed.Biblioteca;
/**
 *
 * Esta clase invoca las principales operaciones de una Biblioteca por Consola
 */
public class LibraryMain {
    
    //funcion principal muestra el menu
    public static void main(String[] args) {
        (new LibraryMain()).run();
    }
    
    /*Muestra un menu de opciones
        y a cada una le asigna un metod*/
    public void run() {  
        Library library=new Library();
        while (true) {
            char option = library.getString("\nIntroduzca una de las siguientes opciones:\n" +
            "1. Incluir el libro en el catalogo\n" +
            "2. Registrar el prestamo de un libro\n" +
            "3. Registrar la devolucion de un libro\n4. Status\n5." +
            "Salir\n" +
            "Su opcion:").charAt(0);
            switch (option) {
                case '1': library.includeBook(); break;
                case '2': library.checkOutBook(); break;
                case '3': library.returnBook(); break;
                case '4': library.status(); break;
                case '5': return;
                default: System.out.println("Opcion invalida, intente de nuevo.");
                }
            }
    }
    
}
