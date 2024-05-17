package uni.aed.Reservas;

import uni.aed.linkedlistTDA.LinkedListTDA;
import uni.aed.listTDA.ListTDA;

public class Reservacion {
    ListTDA<Reserva> reservacion;

    public Reservacion() {
        this.reservacion = new LinkedListTDA<>();
    }
    
    public void reservarVuelo(Reserva reserva){
        reservacion.add(reserva);
    }
    
    public Reserva cancelarVuelo(Reserva reserva){
        int index=reservacion.indexOf(reserva);
        return reservacion.delete(index);
    }
    public Pasajero consultarBoleto(Boleto boleto){
        Object[] listaReservas = reservacion.toArray();
        for(Object o:listaReservas){
            Boleto bo=((Reserva)o).getBoleto();
            Pasajero pa=((Reserva)o).getPasajero();
            if(bo.equals(boleto))
                return pa;
        }
        return null;
    }
    public ListTDA<Pasajero> listarPasajeros(Vuelo vuelo){
        Object[] listaReservas = reservacion.toArray();
        ListTDA<Pasajero> lista=new LinkedListTDA<>();
        for(Object o:listaReservas){
            Vuelo vu=((Reserva)o).getVuelo();
            Pasajero pa=((Reserva)o).getPasajero();
            if(vu.equals(vuelo))
                lista.add(pa);
        }
        return lista;
    }

    @Override
    public String toString() {
        return "Reservacion{" + "reservacion=" + reservacion.toString() + '}';
    }
    
}
