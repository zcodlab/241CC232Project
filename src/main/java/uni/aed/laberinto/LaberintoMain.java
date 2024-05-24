package uni.aed.laberinto;

import uni.aed.stackTDA.ArrayStackTDA;
import uni.aed.stackTDA.StackTDA;

public class LaberintoMain{
    
    public static void main(String[] args) {
        
        int [][] matrizDerribaParedes = {{3, 2, 2, 1, 1}, 
                                         {3, 2, 2, 2, 0}, 
                                         {0, 3, 2, 3, 3}, 
                                         {2, 1, 1, 3, 0},
                                         {3, 3, 3, 0, 1}};
        
        Laberinto laberinto = new Laberinto(5, 5);
        laberinto.derribaParedes(matrizDerribaParedes);
        
        LaberintoMain sol = new LaberintoMain();        
        sol.resuelvePorRetroceso(laberinto);
    }
    
    private void solveRandom(Laberinto laberinto) {
        
        CeldaDelLaberinto actual = laberinto.obtenCeldaDeEntrada();
        CeldaDelLaberinto salida = laberinto.obtenCeldaDeSalida();
        
        System.out.println("Celda actual: (" + actual.obtenNumRenglon()
                                + ",  " + actual.obtenNumColumna() + ")");
        
        while (actual != salida) {            
            actual = laberinto.obtenCeldaAleatoria(actual);
            if (actual != null){
                System.out.println("Celda actual: (" + actual.obtenNumRenglon()
                                + ",  " + actual.obtenNumColumna() + ")");
            }
        }
        
        System.out.println("Ruta de solución encontrada");
    }
    
    private void resuelvePorRetroceso(Laberinto laberinto) {
        
        CeldaDelLaberinto actual = laberinto.obtenCeldaDeEntrada();
        CeldaDelLaberinto salida = laberinto.obtenCeldaDeSalida();
        StackTDA<CeldaDelLaberinto> pila = new ArrayStackTDA<>();
        
        pila.push(actual);
        
        while(actual != salida) {
            
            actual = laberinto.obtenSiguienteCelda(actual);
            if (actual != null) {
                actual.estableceVisitada(true);
                pila.push(actual);
                
            } else { 
                actual = pila.pop();
               
                if (laberinto.obtenSiguienteCelda(actual) != null){
                    pila.push(actual);
                }
            }
        }
        StackTDA<CeldaDelLaberinto> solucionPila = new ArrayStackTDA<>();
        
        while(!pila.isEmpty()) {
            solucionPila.push(pila.pop());
        }
        System.out.println("Ruta de solución");
        while(!solucionPila.isEmpty()){
            System.out.println(solucionPila.pop());
        }
    }
}
