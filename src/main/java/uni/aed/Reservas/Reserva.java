package uni.aed.Reservas;

import java.util.Objects;

public class Reserva {    
    String codigo;
    Pasajero pasajero;
    Vuelo vuelo;
    Boleto boleto;

    public Reserva(String codigo,Pasajero pasajero,Vuelo vuelo,Boleto boleto) {
    this.codigo = codigo;
    this.vuelo = vuelo;
    this.pasajero = pasajero;
    this.boleto = boleto;
    }    

    public String getCodigo() {
        return codigo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public Boleto getBoleto() {
        return boleto;
    }
    
    @Override
    public boolean equals(Object obj) {        
        final Reserva other = (Reserva) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
    
    @Override
    public String toString() {
        return "Reserva{" + "codigo=" + codigo + ", pasajero=" + pasajero + ", vuelo=" + vuelo + ", boleto=" + boleto + '}';
    }
}
