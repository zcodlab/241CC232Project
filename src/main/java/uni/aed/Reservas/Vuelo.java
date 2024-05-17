package uni.aed.Reservas;

import java.util.Objects;

public class Vuelo {
    String numero;

    public Vuelo(String numero) {
        this.numero = numero;
    }    

    @Override
    public boolean equals(Object obj) {       
        final Vuelo other = (Vuelo) obj;
        return Objects.equals(this.numero, other.numero);
    }

    @Override
    public String toString() {
        return "Vuelo{" + "numero=" + numero + '}';
    }
    
}
