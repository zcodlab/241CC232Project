package uni.aed.fortunecookie;

import java.util.Scanner;

public class FortuneCookieMain {
    public static void main(String[] args) {
        FortuneCookieManager fortuneCookieManager=new FortuneCookieManager();
        Scanner escaner=new Scanner(System.in);                        
        String rpta;        
        System.out.println("****Galletas de la Fortuna****");
        System.out.println(fortuneCookieManager.nexFortune());        
        System.out.println("Pulse S para continuar obteniendo galletas de la fortuna, N para salir:");        
        while(true){
            rpta=escaner.next();
            if(!rpta.equalsIgnoreCase("N"))
                System.out.println(fortuneCookieManager.nexFortune());    
            else break;
        }
    }
    
}
