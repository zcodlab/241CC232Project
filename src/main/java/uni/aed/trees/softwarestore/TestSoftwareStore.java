package uni.aed.trees.softwarestore;
import java.util.Scanner;
public class TestSoftwareStore {
    public static void main(String[] args) {
        SoftwareStore softwareStore = new SoftwareStore("src\\main\\java\\uni\\aed\\trees\\softwarestore/software.txt");
                                                                
        Scanner scanner = new Scanner(System.in);        

        int choice;
        do {
            softwareStore.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter software name: ");
                    String name = scanner.next();
                    
                    System.out.println("Enter software version: ");
                    String version = scanner.next();
                    
                    System.out.println("Enter quantity sold: ");
                    int quantitySold = scanner.nextInt();
                    
                    softwareStore.sellSoftware(name, version, quantitySold);
                    break;
                case 2:                    
                    System.out.println("Enter software name: ");
                    name = scanner.next();
                    
                    System.out.println("Enter software version: ");
                    version = scanner.next();
                    
                    System.out.println("Enter quantity to sold: ");
                    quantitySold = scanner.nextInt();
                    
                    System.out.println("Enter price: ");
                    int price = scanner.nextInt();
                    
                    softwareStore.addSoftware(name, version, quantitySold, price);
                    break;
                case 3:
                    softwareStore.inventarioSoftware();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 4);        
        softwareStore.cleanUpFile();
    }
}
