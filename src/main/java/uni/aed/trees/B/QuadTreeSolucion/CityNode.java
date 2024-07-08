package uni.aed.trees.B.QuadTreeSolucion;

public class CityNode {

    String name;
    double latitude;
    double longitude;
    CityNode NO;
    CityNode NE, SO, SE;

    CityNode(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "CityNode{" + "name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + ", NO=" + NO + ", NE=" + NE + ", SO=" + SO + ", SE=" + SE + '}';
    }

}
