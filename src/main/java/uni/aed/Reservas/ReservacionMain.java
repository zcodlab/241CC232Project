package uni.aed.Reservas;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ReservacionMain {
    private static Scanner scr;
    Reservacion reservacion;
    Reserva reserva;
    Pasajero pasajero;
    Vuelo vuelo;
    Boleto boleto;    

    public ReservacionMain() {
        reservacion=new Reservacion();
        scr=new Scanner(System.in).useDelimiter("\n");
    }
    
    public static void main(String[] args){
        ReservacionMain reservacionMain=new ReservacionMain(); 
        reservacionMain.menu();

    }
    private void menu(){        
        int opcion=1;		
	String Rpta="S";				
	String SEPARADOR="\n";	                            
        try{
            
            do			
            {	
                System.out.print("Reserva de pasajes con Listas Enalazadas"+SEPARADOR+
                "1.- Reservar Vuelo "+SEPARADOR+
                "2.- Cancelar Reserva "+SEPARADOR+
                "3.- Consultar Boleto "+SEPARADOR+                
                "4.- Listar Pasajeros "+SEPARADOR+                
                "5.- Listar Reservas "+SEPARADOR+                
                "6.- Salir "+SEPARADOR+"Elija una opcion:");                
                opcion =scr.nextInt();            
                switch (opcion)
                {
                    case 1 -> {reservarVuelo();}
                    case 2 -> {cancelarVuelo();}
                    case 3 -> {consultarBoleto();}                    
                    case 4 -> {listarPasajeros();}                    
                    case 5 -> {listarReservas();}                    
                    default -> {break;}
                }	            
                System.out.print("Para continuar con las operaciones pulsa S; Para finalizar pulse N: ");
                Rpta=scr.next().toUpperCase();			
            }while(Rpta.equals("S")==true);	
        }catch(InputMismatchException ex) {
            System.out.println("Debe ingresar obligatoriamente un número entero como opcion elegida.");
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
    private void reservarVuelo(){                
        System.out.println("Ingrese datos del Pasajero:");
        System.out.println("Ingrese Nombre:");
        String nombre=scr.next();
        System.out.println("Ingrese Apellidos:");
        String apellidos=scr.next();        
        pasajero=new Pasajero(nombre, apellidos);
        
        System.out.println("Ingrese el numero de vuelo de su interes:");
        String codigoVuelo=scr.next();        
        vuelo=new Vuelo(codigoVuelo);
                
        Random random=new Random();
        boleto=new Boleto("T"+String.valueOf(random.nextInt(100)));
        System.out.println("Se ha generado el Boleto N°"+ boleto.getNumeroTicket());
        
        reserva=new Reserva("R"+String.valueOf(random.nextInt(100)),pasajero,vuelo,boleto);        
        reservacion.reservarVuelo(reserva);       
        System.out.println("Gracias por Reservar, Su N° de Reserva es:"+ reserva.getCodigo());
    }
    private void cancelarVuelo(){        
        System.out.println("Cancelacion de Reserva");
        System.out.println("Ingrese la Reserva a cancelar");
        String codigoReserva=scr.next();
        reserva=new Reserva(codigoReserva,null,null,null);        
        System.out.println("Se ha cancelado la Reserva" + reservacion.cancelarVuelo(reserva).toString());        
    }
    private void consultarBoleto(){              
        System.out.println("Ingrese el Boleto a consultar");
        String numeroTicket=scr.next();
        boleto=new Boleto(numeroTicket);
        pasajero=reservacion.consultarBoleto(boleto);
        System.out.println("El Boleto le pertenece al Pasajero: "+pasajero.toString());
    }
    private void listarPasajeros(){
        System.out.println("Reporte de Pasajeros del Vuelo");
        scr=new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el numero de Vuelo ");
        String numeroVuelo=scr.next();
        vuelo=new Vuelo(numeroVuelo);        
        for(Object o:(reservacion.listarPasajeros(vuelo)).toArray())
            System.out.println(((Pasajero)o).toString());
    }
    private void listarReservas(){
        System.out.println("Listado de Reservas");
        System.out.println(reservacion.toString());
    }
    private void opciones(){
//        Reservacion reservacion=new Reservacion();
//        Reserva reserva;
//        Pasajero pasajero;
//        Vuelo vuelo;
//        Boleto boleto;
        System.out.println("Ingrese el Pasajero");
        pasajero=new Pasajero("Jose", "Perez");
        System.out.println("Ingrese el numero de vuelo de su interes");
        vuelo=new Vuelo("V10");
        System.out.println("Se le ha generado el Boleto N°");
        boleto=new Boleto("T10");
        reserva=new Reserva("R001",pasajero,vuelo,boleto);        
        reservacion.reservarVuelo(reserva);        
        //2reservacion
        System.out.println("Ingrese el Pasajero");
        pasajero=new Pasajero("Juan", "Lopez");
        System.out.println("Ingrese el numero de vuelo de su interes");
        vuelo=new Vuelo("V10");
        System.out.println("Se le ha generado el Boleto N°");
        boleto=new Boleto("T11");
        reserva=new Reserva("R002",pasajero,vuelo,boleto);        
        reservacion.reservarVuelo(reserva);
        //3reservacion
        System.out.println("Ingrese el Pasajero");
        pasajero=new Pasajero("Ronald", "Ramos");
        System.out.println("Ingrese el numero de vuelo de su interes");
        vuelo=new Vuelo("V10");
        System.out.println("Se le ha generado el Boleto N°");
        boleto=new Boleto("T12");
        reserva=new Reserva("R003",pasajero,vuelo,boleto);        
        reservacion.reservarVuelo(reserva);        
        System.out.println(reservacion.toString());
        
        System.out.println("Cancelacion de Reserva");
        System.out.println("Ingrese la Reserva a cancelar");
        reserva=new Reserva("R003",null,null,null);        
        reservacion.cancelarVuelo(reserva);
        System.out.println("Listado de Reservas");
        System.out.println(reservacion.toString());
        
        System.out.println("Buscando un Boleto");
        System.out.println("Ingrese el Boleto a consultar");
        boleto=new Boleto("T11");
        pasajero=reservacion.consultarBoleto(boleto);
        System.out.println("El Boleto le pertenece al Pasajero: "+pasajero.toString());
        
        System.out.println("Reporte del Vuelo");
        vuelo=new Vuelo("V10");        
        for(Object o:(reservacion.listarPasajeros(vuelo)).toArray())
            System.out.println(((Pasajero)o).toString());
    }
    
}
