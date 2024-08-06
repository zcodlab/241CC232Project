package uni.aed.laberintoSolucion;

import java.util.Random;

public class Laberinto {
    
    private int numRenglones, numColumnas;
    CeldaDelLaberinto entrada, salida;
    CeldaDelLaberinto [][] matrizLaberinto;    
    
    public Laberinto(CeldaDelLaberinto [][] matrizLaberinto,CeldaDelLaberinto entrada, CeldaDelLaberinto salida){
        this.entrada = entrada;
        this.salida = salida;
        this.matrizLaberinto=matrizLaberinto;
        this.numColumnas = matrizLaberinto[0].length;
        this.numRenglones = matrizLaberinto.length;
    }
    // Mediante los dos ultimos parametros se podra trasladar la logica de entrada y salida de esta clase
    public Laberinto(int numRenglones, int numColumnas,CeldaDelLaberinto entrada,CeldaDelLaberinto salida){
        this.numRenglones = numRenglones;
        this.numColumnas = numColumnas;
        
        matrizLaberinto = new CeldaDelLaberinto[numRenglones][numColumnas];
        for(int i = 0; i < numRenglones; i ++)
            for(int j = 0; j < numColumnas; j ++)
                // el constructor de la celda estable las cuatro paredes
                matrizLaberinto[i][j] = new CeldaDelLaberinto(i, j);
        this.entrada = entrada;
        this.salida=salida;
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
        
        for(int x = 0; x < numRenglones; x ++) {
            for(int y = 0; y < numColumnas; y ++) {
                //derriba la pared en el lado matrizDerribaParedes[i][j]
                matrizLaberinto[x][y].derribaPared(matrizDerribaParedes[x][y]);
            }
        }
        
    }
   
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < obtenContadorRenglon(); i++) {
            sb.append("+");
            for (int j = 0; j < obtenContadorColumna(); j++) {
                CeldaDelLaberinto celda = matrizLaberinto[i][j];
                if (celda.hayPared(CeldaDelLaberinto.NORTE_O)) {
                    sb.append("---+");
                } else {
                    sb.append("   +");
                }
            }
            sb.append("\n");
            if (matrizLaberinto[i][0].hayPared(CeldaDelLaberinto.OESTE_O)) {
                sb.append("|");
            } else {
                sb.append(" ");
            }
            for (int j = 0; j < obtenContadorColumna(); j++) {
                CeldaDelLaberinto celda = matrizLaberinto[i][j];
                
                if (celda.equals(entrada)) {
                    sb.append(" S ");
                } else if (celda.equals(salida)) {
                    sb.append(" E ");
                } else {
                    String s = (celda.esVisitable())?
                            " " : "X";
                    sb.append(" ");
                    sb.append(s);
                    sb.append(" ");
                }
                
                if (celda.hayPared(CeldaDelLaberinto.ESTE_O)) {
                    sb.append("|");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            if( i == obtenContadorRenglon() -1){
                sb.append("+");
                for (int j = 0; j < obtenContadorColumna(); j++) {
                    CeldaDelLaberinto celda = matrizLaberinto[i][j];
                    if (celda.hayPared(CeldaDelLaberinto.SUR_O)) {
                        sb.append("---+");
                    } else {
                        sb.append("   +");
                    }
                }
            }
        }
        return sb.toString();
    }
}
