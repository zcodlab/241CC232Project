package uni.aed.trees.B.QuadTreeSolucion;

import java.util.List;
import java.util.Scanner;

public class QuadTreeMenu {
    private QuadTree qt;    
    private Scanner scanner;

    public QuadTreeMenu() {
        qt = new QuadTree();        
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    // metodo implementado para el menu
    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("----- Menu  -----");
            System.out.println("1. Cargar arbol con ciudades de Usa");
            System.out.println("2. Cargar arbol con ciudades de Peru");
            System.out.println("3. Registrar ciudades (Usa o Peru)");
            System.out.println("4. Visualizar arbol");
            System.out.println("5. Buscar ciudades vecinas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    loadUsa();
                    break;
                case 2:
                    loadPeru();
                    break;
                case 3:
                    register();
                    break;
                case 4:
                    visualize();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    System.out.println("Saliendo del menu...");
                    running = false;
                    break;
                default:
                    System.out.println("Opcion no válida. Intenta otra vez.");
            }
        }
        scanner.close();
    }

    private void loadUsa() {
        qt.clear();
        qt.insert("Louisville", 38, -85); 
        qt.insert("Washington", 38, -77); 
        qt.insert("Chicago", 41, -87);
        qt.insert("New York", 40, -74);
        qt.insert("Pittsburgh", 40, -79);
        qt.insert("Dayton", 39, -84);        
        qt.insert("Nashville", 36, -87);
        qt.insert("Montreal", 45, -73);
        qt.insert("Cleveland", 41, -81);
        qt.insert("Atlanta", 34, -84);
        System.out.println("Ciudades de Usa cargadas.");
        visualize();
    }

    // usando https://www.geodatos.net/coordenadas/peru
    // y tomando numeros enteros
    private void loadPeru() {
        qt.clear();
        qt.insert("Lima", -12, -77);
        qt.insert("Arequipa", -16, -71);
        qt.insert("Callao", -12, -77);
        qt.insert("Trujillo", -8, -79);
        qt.insert("Chiclayo", -6, -79);
        qt.insert("Iquitos", -3, -73);
        qt.insert("Huancayo", -12, -75);
        System.out.println("Ciudades de Peru cargadas.");
        visualize();
    }

    // registra ciudad de Usa o peru
    private void register() {
        String opcion = "S";
        qt.clear();
        do{
            System.out.print("Ingrese el nombre de la ciudad: ");
            String name = scanner.next();
            System.out.print("Ingrese la latitud: ");
            double lat = scanner.nextDouble();
            System.out.print("Ingrese la longitud: ");
            double lon = scanner.nextDouble();
            qt.insert(name, lat, lon);
            System.out.println("¿Desea continuar registrando ciudades en el arbol cuaternario?(S/N).");
            opcion = scanner.next();
        }while (opcion.equalsIgnoreCase("S"));
        visualize();
    }

    private void visualize() {
        System.out.println("Visualiza Ciudades Registradas en el Arbol Cuaternario");        
        qt.visualize();        
    }

    private void search() {
            visualize();
            System.out.print("Ingrese el nombre de la ciudad: ");
            String cityName = scanner.nextLine();
            System.out.print("Ingrese el radio de busqueda (en millas): ");
            double radius = scanner.nextDouble();            

            List<String> nearbyCities;            
            nearbyCities = qt.searchByCity(cityName, radius);
            System.out.println("Ciudades cercanas a " + cityName + ":");
            for (String city : nearbyCities) {
                System.out.println(city);
            }
        }
}
