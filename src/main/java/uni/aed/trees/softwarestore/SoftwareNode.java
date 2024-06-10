package uni.aed.trees.softwarestore;

public class SoftwareNode {
    String name;        
    String version;     
    int quantity;       
    int price;          
    int filePosition;   

    SoftwareNode left;  
    SoftwareNode right; 
    
    public SoftwareNode(String name, String version, int quantity, int price, int filePosition) {
        this.name = name;
        this.version = version;
        this.quantity = quantity;
        this.price = price;
        this.filePosition = filePosition;
        this.left = this.right = null;
    }
     public String getName(){
        return this.name;
    }
    public String getVersion(){
        return this.version;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public int getPrice(){
        return this.price;
    }
    @Override
    public String toString() {
        return name + " " + version + " " + quantity + " " + price;
    }
}
