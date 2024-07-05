package uni.aed.trees.B.QuadTree;

import java.util.ArrayList;
import java.util.List;

public class QuadTree {
     CityNode root;
    private static final double R = 3956.0; // Radio de la Tierra en millas

    public void insert(String name, double latitude, double longitude) {
        root = insert(root, name, latitude, longitude);
    }

    private CityNode insert(CityNode node, String name, double latitude, double longitude) {
        if (node == null) {
            return new CityNode(name, latitude, longitude);
        }

        if (latitude < node.latitude && longitude < node.longitude) {
            node.NO = insert(node.NO, name, latitude, longitude);
        } else if (latitude < node.latitude && longitude >= node.longitude) {
            node.NE = insert(node.NE, name, latitude, longitude);
        } else if (latitude >= node.latitude && longitude < node.longitude) {
            node.SO = insert(node.SO, name, latitude, longitude);
        } else if (latitude >= node.latitude && longitude >= node.longitude) {
            node.SE = insert(node.SE, name, latitude, longitude);
        }

        return node;
    }

    public List<String> search(double latitude, double longitude, double radius) {
        List<String> result = new ArrayList<>();
        search(root, latitude, longitude, radius, result);
        return result;
    }

    private void search(CityNode node, double latitude, double longitude, double radius, List<String> result) {
        if (node == null) {
            return;
        }

        double distance = distance(latitude, longitude, node.latitude, node.longitude);
        if (distance <= radius) {
            result.add(node.name);
        }

        if (latitude - radius < node.latitude && longitude - radius < node.longitude) {
            search(node.NO, latitude, longitude, radius, result);
        }
        if (latitude - radius < node.latitude && longitude + radius >= node.longitude) {
            search(node.NE, latitude, longitude, radius, result);
        }
        if (latitude + radius >= node.latitude && longitude - radius < node.longitude) {
            search(node.SO, latitude, longitude, radius, result);
        }
        if (latitude + radius >= node.latitude && longitude + radius >= node.longitude) {
            search(node.SE, latitude, longitude, radius, result);
        }
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        return R * Math.acos(Math.sin(lat1) * Math.sin(lat2) +
                             Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1));
    }

    public List<String> searchByCity(String cityName, double radius) {
        CityNode city = findCity(root, cityName);
        if (city == null) {
            return new ArrayList<>();
        }
        return search(city.latitude, city.longitude, radius);
    }

    private CityNode findCity(CityNode node, String cityName) {
        if (node == null) {
            return null;
        }

        if (node.name.equals(cityName)) {
            return node;
        }

        CityNode foundCity = findCity(node.NO, cityName);
        if (foundCity == null) foundCity = findCity(node.NE, cityName);
        if (foundCity == null) foundCity = findCity(node.SO, cityName);
        if (foundCity == null) foundCity = findCity(node.SE, cityName);

        return foundCity;
    }

    @Override
    public String toString() {
        return "QuadTree{" + "root=" + root + '}';
    }
    
}
