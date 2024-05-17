package uni.aed.Reservas;

import java.util.Objects;

public class Pasajero {
    String nombre;
    String apellidos;

    public Pasajero(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }   

    @Override
    public boolean equals(Object obj) {        
        final Pasajero other = (Pasajero) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellidos, other.apellidos);
    }
    
    @Override
    public String toString() {
        return "Pasajero{" + "nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
    
}
