package uni.aed.laberinto;

public class CeldaDelLaberinto {
    
    /*
     * 1 significa que hay pared
     * 0 significa que no hay pared
     * Al crearse una celda, esta automaticamente tiene todos sus lados con una pared
    */
    
    public static final int TIENE_PARED = 1;
    public static final int NO_TIENE_PARED = 0;
    
    public int NORTE = TIENE_PARED ;  // pared norte de la celda, pared 0
    public int OESTE = TIENE_PARED;   // pared oeste de la celda, pared 1
    public int SUR = TIENE_PARED;     // pared sur de la celda, pared 2
    public int ESTE = TIENE_PARED;    // pared este de la celda, pared 3
    
    
    private int numRenglon, numColumna;
    private boolean haSidoVisitado = false;
    
     public CeldaDelLaberinto(int numRenglon, int numColumna) {
        this.numRenglon = numRenglon;
        this.numColumna = numColumna;
    }
    
    public int obtenNumColumna() {
        return numColumna;
    }    
 
    public int obtenNumRenglon() {
        return numRenglon;
    }    
    
    boolean esVisitable() {
        return !haSidoVisitado;
    }   
    
    public boolean hayPared(int lado) {
        return lado == TIENE_PARED;
    }    
    
    public void derribaPared(int lado) {
        
        switch(lado) {
            case 0 -> {
                NORTE = NO_TIENE_PARED;
            }
            case 1 -> {
                OESTE = NO_TIENE_PARED;
            }
            case 2 -> {
                SUR = NO_TIENE_PARED;
            }
            case 3 -> {
                ESTE = NO_TIENE_PARED;
            }
            default ->{
                System.out.println("Solo se aceptan valores entre 0 y 3");
            }
        }
    }
    
    public void estableceVisitada(boolean estado){
        haSidoVisitado = estado;
    }
    
    public String toString() {
        return "(" + numRenglon + ", " + numColumna + ")";
    }
 
}
