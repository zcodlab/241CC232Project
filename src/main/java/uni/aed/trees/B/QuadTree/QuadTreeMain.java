package uni.aed.trees.B.QuadTree;

import java.util.List;

public class QuadTreeMain {
    public static void main(String[] args) {
        QuadTree qt = new QuadTree();

        qt.insert("Louisville", 38, -85); 
        System.out.println("Cities: " + qt.toString());
        qt.insert("Washington", 38, -77); 
        System.out.println("Cities: " + qt.toString());
        qt.insert("Chicago", 41, -87);
        System.out.println("Cities: " + qt.toString());
        qt.insert("New York", 40, -74);
        System.out.println("Cities: " + qt.toString());
        qt.insert("Pittsburgh", 40, -79);
        System.out.println("Cities: " + qt.toString());
        qt.insert("Dayton", 39, -84);        
        System.out.println("Cities: " + qt.toString());
        qt.insert("Nashville", 36, -87);
        System.out.println("Cities: " + qt.toString());
        qt.insert("Montreal", 45, -73);
        System.out.println("Cities: " + qt.toString());
        qt.insert("Cleveland", 41, -81);
        System.out.println("Cities: " + qt.toString());
        qt.insert("Atlanta", 34, -84);
        
        // Search for cities within a radius of a given location
        List<String> citiesNearLocation = qt.search(40.4406, -79.9959, 200); // Pittsburgh location with radius 200 miles
        System.out.println("Cities near location: " + citiesNearLocation);

        // Search for cities within a radius of a given city
        List<String> citiesNearCity = qt.searchByCity("Pittsburgh", 200); // Near Pittsburgh with radius 200 miles
        System.out.println("Cities near Pittsburgh: " + citiesNearCity);
    }
}
