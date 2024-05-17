package uni.aed.Reservas;

import java.util.Objects;

public class Boleto {
    String numeroTicket;

    public Boleto(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }    

    @Override
    public boolean equals(Object obj) {     
        final Boleto other = (Boleto) obj;
        return Objects.equals(this.numeroTicket, other.numeroTicket);
    }

    @Override
    public String toString() {
        return "Boleto{" + "numeroTicket=" + numeroTicket + '}';
    }

    
    
    
}
