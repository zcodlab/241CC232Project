package uni.aed.trees.softwarestore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SoftwareStore {
    private SoftwareNode root;
    private String fileName;
        
    public SoftwareStore(String fileName) {
        this.root = null;
        this.fileName = fileName;
        readFromFile();
    }
    
    private void readFromFile() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int position = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");
                if (parts.length!= 4) {
                        System.err.println("Invalid line format: " + line);
                        continue; 
                }
                String name = parts[0];
                String version = parts[1].toString();
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                SoftwareNode newNode = new SoftwareNode(name, version, quantity, price, position);
                root = insert(root, newNode);
                position++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private SoftwareNode insert(SoftwareNode root, SoftwareNode newNode) {
        if (root == null) {
            return newNode;
        }

        int compareResult = newNode.name.compareTo(root.name);

        if (compareResult < 0) {
            root.left = insert(root.left, newNode);
        } else if (compareResult > 0) {
            root.right = insert(root.right, newNode);
        } else {            
            root.quantity += newNode.quantity;
        }

        return root;
    }
    
    public void sellSoftware(String name, String version, int quantitySold) {
        SoftwareNode node = findNode(root, name, version);

        if (node != null) {
            node.quantity -= quantitySold;
            updateFile();
            if (node.quantity <= 0) {                
                root = deleteNode(root, name, version);
            }
        } else {
            System.out.println("Software not found.");
        }
    }    
    
    public void addSoftware(String name, String version, int quantity, int price) {
        SoftwareNode newNode = new SoftwareNode(name, version, quantity, price, -1); 
        root = insert(root, newNode); //Inserta o suma la cantidad de software
        updateFile(); //Actualiza archivo .txt
    }
    
    private SoftwareNode deleteNode(SoftwareNode root, String name, String version) {
        if (root == null) {
            return root;
        }
        int compareResult = (name + version).compareTo(root.name + root.version);

        if (compareResult < 0) {
            root.left = deleteNode(root.left, name, version);
        } else if (compareResult > 0) {
            root.right = deleteNode(root.right, name, version);
        } else {            
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;                                    
            root.name = minValueNode(root.right).name;
            root.version = minValueNode(root.right).version;
            root.quantity = minValueNode(root.right).quantity;
            
            root.right = deleteNode(root.right, root.name, root.version);
        }
        return root;
    }
    
    private SoftwareNode minValueNode(SoftwareNode root) {
        SoftwareNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    private SoftwareNode findNode(SoftwareNode root, String name, String version) {
        if (root == null || (root.name.equals(name) && root.version.equals(version))) {
            return root;
        }

        int compareResult = (name + version).compareTo(root.name + root.version);

        if (compareResult < 0) {
            return findNode(root.left, name, version);
        } else {
            return findNode(root.right, name, version);
        }
    }
    
    private void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            inorderWriteToFile(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void inorderWriteToFile(SoftwareNode root, BufferedWriter writer) throws IOException {
        if (root != null) {
            inorderWriteToFile(root.left, writer);
            writer.write(root.name + " " + root.version + " " + root.quantity + " " + root.price);
            writer.newLine();
            inorderWriteToFile(root.right, writer);
        }
    }       
    
    public void inventarioSoftware() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            System.out.printf("%-30s %-15s %-10s %-10s%n", "Nombre", "Versión", "Cantidad", "Precio");
            System.out.println("--------------------------------------------------------------------------------");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                if (parts.length >= 4) {
                    String name = parts[0];
                    String version = parts[1];
                    String quantity = parts[2];
                    String price = parts[3];

                    System.out.printf("%-30s %-15s %-10s %-10s%n", name, version, quantity, price);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se pudo encontrar el archivo: " + fileName);
        }
    }
    
    public void displayMenu() {
        System.out.println("1. Sell Software");
        System.out.println("2. Add Software");
        System.out.println("3. Ver Inventario");
        System.out.println("4. Exit");
    }    
    
    public void cleanUpFile() {        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".tmp"))) {

            String line;
            int position = 0;                        
            List<String> lines = new LinkedList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);               
            }             
            boolean stock=false;            
            while(position<lines.size()){
                line=lines.get(position);
                String[] parts = line.split("\\s+");                  
                int quantity = Integer.parseInt(parts[2]);                
                if (quantity == 0)
                {    
                    while(position<lines.size() && !stock){
                        String lineLast=lines.get(lines.size()-1);
                        String[] partsLast = lineLast.split("\\s+");                
                        int quantityLast = Integer.parseInt(partsLast[2]);
                        if (quantityLast>0){
                            stock=true;
                            lines.set(position, lineLast);
                        }    
                        lines.remove(lines.size()-1);
                    }
                }
                position++;
            }
            for (String fline : lines) {
                String[] parts = fline.split("\\s+");
                String name = parts[0];
                String version = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                if (quantity > 0) {
                    writer.write(name + " " + version + " " + quantity + " " + price);
                    writer.newLine();
                }                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        File originalFile = new File(fileName);
        if (originalFile.delete()) {
            File tempFile = new File(fileName + ".tmp");
            if (tempFile.renameTo(originalFile))
                System.out.println("Archivo limpiado y actualizado correctamente.");
            else
                System.out.println("Error al renombrar el archivo temporal.");            
        } else
            System.out.println("Error al borrar el archivo original.");
        
    }
}
