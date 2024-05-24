package uni.aed.laberinto;

import java.util.Random;
import java.util.Scanner;

public class Laberinto {
    
    private int numRenglones, numColumnas;
    CeldaDelLaberinto entrada, salida;
    CeldaDelLaberinto [][] matrizLaberinto;    
 
    public Laberinto(int numRenglones, int numColumnas){
        this.numRenglones = numRenglones;
        this.numColumnas = numColumnas;
        
        matrizLaberinto = new CeldaDelLaberinto[numRenglones][numColumnas];
        for(int i = 0; i < numRenglones; i ++)
            for(int j = 0; j < numColumnas; j ++)
                matrizLaberinto[i][j] = new CeldaDelLaberinto(i, j);
            
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nIngrese celda de entrada");
        System.out.println("Ingrese fila y columna de celda de entrada: ");
        int i = teclado.nextInt();
        int j = teclado.nextInt();
        entrada = matrizLaberinto[i][j];
        System.out.println("La celda de entrada es : celda(" + 
                            entrada.obtenNumRenglon() + ", " + entrada.obtenNumColumna() + ")");
        
        System.out.println("\nIngrese celda de salida");
        System.out.println("Ingrese fila y columna de celda de salida: ");
        i = teclado.nextInt();
        j = teclado.nextInt();
        salida = matrizLaberinto[i][j];
        System.out.println("La celda de salida es : celda(" + 
                            salida.obtenNumRenglon() + ", " + salida.obtenNumColumna() + ")");
        
    }    
 
    public void limpia(){
        
        for (int i = 0; i < numRenglones; i++)
            for (int j = 0; j < numColumnas; j++)
                matrizLaberinto[i][j].estableceVisitada(false);
    }    
 
    public int obtenContadorColumna() {
      return numColumnas;  
    }    

    public int obtenContadorRenglon() {
        return numRenglones;
    }
   
    public CeldaDelLaberinto obtenCeldaDeEntrada() {
        return entrada;
    }    
    
    public CeldaDelLaberinto obtenCeldaDeSalida() {
        return salida;
    }    
    
    public CeldaDelLaberinto obtenSiguienteCelda(CeldaDelLaberinto celdaActual) {
        
        int i = celdaActual.obtenNumRenglon();
        int j = celdaActual.obtenNumColumna();
        
        
        if (i-1 >= 0)
            if ((celdaActual.NORTE == CeldaDelLaberinto.NO_TIENE_PARED 
                 || matrizLaberinto[i-1][j].SUR == CeldaDelLaberinto.NO_TIENE_PARED) 
                 && matrizLaberinto[i-1][j].esVisitable())
                    return matrizLaberinto[i-1][j];
            
        if (j-1 >= 0)
            if ((celdaActual.OESTE == CeldaDelLaberinto.NO_TIENE_PARED 
                 || matrizLaberinto[i][j-1].ESTE == CeldaDelLaberinto.NO_TIENE_PARED) 
                 && matrizLaberinto[i][j-1].esVisitable())
                    return matrizLaberinto[i][j-1];
                
        
        if (i+1 < numRenglones)
            if ((celdaActual.SUR == CeldaDelLaberinto.NO_TIENE_PARED 
                 || matrizLaberinto[i+1][j].NORTE == CeldaDelLaberinto.NO_TIENE_PARED) 
                 && matrizLaberinto[i+1][j].esVisitable())
                    return matrizLaberinto[i+1][j];
            
        if (j+1 < numColumnas)
            if ((celdaActual.ESTE == CeldaDelLaberinto.NO_TIENE_PARED 
                 || matrizLaberinto[i][j+1].OESTE == CeldaDelLaberinto.NO_TIENE_PARED) 
                 && matrizLaberinto[i][j+1].esVisitable())
                    return matrizLaberinto[i][j+1];

        return null;
    }    
    
    public CeldaDelLaberinto obtenCeldaAleatoria(CeldaDelLaberinto celdaActual) {
        
        int i = celdaActual.obtenNumRenglon();
        int j = celdaActual.obtenNumColumna();
        
        Random ran = new Random();
        
        switch(ran.nextInt(4)) {
            case 0 ->{
               if (i-1 >= 0 && (celdaActual.NORTE == 0 || matrizLaberinto[i-1][j].SUR == 0))
                   return matrizLaberinto[i-1][j]; 
            }
            case 1 ->{
                if (j-1 >= 0  && (celdaActual.OESTE == 0 || matrizLaberinto[i][j-1].ESTE == 0))
                    return matrizLaberinto[i][j-1];
            }
            case 2 ->{
                if (i+1 < numRenglones && (celdaActual.SUR == 0 || matrizLaberinto[i+1][j].NORTE == 0))
                    return matrizLaberinto[i+1][j];
            }
            case 3 ->{
                if (j+1 < numColumnas && (celdaActual.ESTE == 0 || matrizLaberinto[i][j+1].OESTE == 0))
                    return matrizLaberinto[i][j+1];
            }

        }
        
        return celdaActual;
    }
    
    public void derribaParedes(int [][] matrizDerribaParedes) {
        
        for(int i = 0; i < numRenglones; i ++) {
            for(int j = 0; j < numColumnas; j ++) {
                matrizLaberinto[i][j].derribaPared(matrizDerribaParedes[i][j]);
            }
        }
        
    }
   
}
