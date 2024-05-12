package uni.aed.fortunecookie;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FortuneCookieMain {
    private static FortuneCookieManager fortuna;
    private static Scanner scr;        
    public static void main(String[] args) {
        FortuneCookieMain fortunaMain=new FortuneCookieMain();
        fortuna=new FortuneCookieManager();        
        fortunaMain.menu();
    }
    private void menu(){
        scr=new Scanner(System.in).useDelimiter("\n");
        int opcion=1;		
	String Rpta="S";				
	String SEPARADOR="\n";	                            
        try{
            
            do			
            {	
                System.out.print("Galleta de la Fortuna con Listas Enalazadas"+SEPARADOR+
                "1.- Obtiene una Galleta de la Fortuna "+SEPARADOR+
                "2.- Añadir Galleta de la Fortuna "+SEPARADOR+
                "3.- Eliminar Galleta de la Fortuna "+SEPARADOR+                
                "4.- Listar Galletas de la Fortuna "+SEPARADOR+                
                "5.- Salir "+SEPARADOR+"Elija una opcion:");                
                opcion =scr.nextInt();            
                switch (opcion)
                {
                    case 1 -> {getFortuneCookie();}
                    case 2 -> {addFortuneCookie();}
                    case 3 -> {deleteFortuneCookie();}                    
                    case 4 -> {verFortunesCookies();}                    
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
    private void addFortuneCookie(){        
        System.out.println("Ingrese una Galleta de la Fortuna");
        String galleta = scr.next();
        fortuna.AddFortuneCookie(galleta);        
        System.out.println("Ahora se tiene "+ fortuna.getSizeFortuneCookie()+ " galletas de la fortuna");
    }
    private void deleteFortuneCookie(){        
        System.out.println("Ingrese la Galleta de la Fortuna a eliminar");
        String galleta = scr.next();
        fortuna.DeleteFortuneCookie(galleta);        
        System.out.println("Ahora se tiene "+ fortuna.getSizeFortuneCookie()+ " galletas de la fortuna");
    }    
    private void verFortunesCookies(){        
        System.out.println("Lista Galletas de la Fortuna "+ fortuna.getSizeFortuneCookie());                
        System.out.println(fortuna.toString());        
        System.out.println("Ingrese el numero de la Galleta de la Fortuna que desea ver");  
        int galleta = scr.nextInt();
        System.out.println(fortuna.getFortuneCookie(galleta));        
    }
    private void getFortuneCookie(){        
        String rpta;        
        System.out.println("****Galletas de la Fortuna****");
        System.out.println(fortuna.nexFortune());        
        System.out.println("Pulse S para continuar obteniendo galletas de la fortuna, N para salir:");        
        while(true){
            rpta=scr.next();
            if(!rpta.equalsIgnoreCase("N"))
                System.out.println(fortuna.nexFortune());    
            else break;
        }
    }
    
}
