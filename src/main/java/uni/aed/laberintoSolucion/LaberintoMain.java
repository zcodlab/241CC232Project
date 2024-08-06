package uni.aed.laberintoSolucion;

import java.util.Scanner;
import uni.aed.stackTDA.ArrayStackTDA;
import uni.aed.stackTDA.StackEmptyExceptionTDA;
import uni.aed.stackTDA.StackTDA;

public class LaberintoMain{
    
    public static void main(String[] args) {
        
        Laberinto laberinto = obtenLaberintoBase();
        LaberintoMain sol = new LaberintoMain();        
        
        Scanner sc = new Scanner(System.in);
        boolean salir = false;        
        while(!salir){
            System.out.println("\n\n========== MENU =========");
            System.out.println("""
                               (1) ver laberinto
                               (2) ver solucion por retroceso
                               (3) ver solucion por solucion aleatoria
                               (4) salir
                               digite su opcion: """);
            int opcion = sc.nextInt();
            //Limpiamos el laberinto antes de iniciar con las operaciones
            laberinto.limpia();
            switch (opcion) {
                case 1:
                    System.out.println(laberinto);
                    break;
                case 2:
                    sol.resuelvePorRetroceso(laberinto);
                    System.out.println("Solucion grafica:");
                    System.out.println(laberinto);
                    break;
                case 3:
                    sol.solveRandom(laberinto);
                    System.out.println("Solucion grafica con todas las celdas visitadas:");
                    System.out.println(laberinto);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("DIGITE UNA OPCION VALIDA!!!");
            }
        }
    }
    
    /**
     * No se usó el metodo de derribar por matriz porque en cada elememento de esta
     * solo se nos permite derribar una pared y no derribaria la pared
     * correspondiente a la celda que esta al lado de la pared que se deberia derribar.
     * Para simplificar esto use un metodo que me devuelve un laberinto de ejemplo.
     * 
     * @return Devuelve un laberinto de ejemplo con las paredes derribadas
     */
    
    public static Laberinto obtenLaberintoBase() {
        CeldaDelLaberinto celdas[][] = new CeldaDelLaberinto[5][5];
        for(int i = 0;i<celdas.length ;++i) 
            for(int j =0;j<celdas[0].length;++j) 
                celdas[i][j] = new CeldaDelLaberinto(i, j) ;
        
        celdas[0][0].derribaPared(CeldaDelLaberinto.SUR_O) ;
        celdas[0][0].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        
        celdas[0][1].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        celdas[0][1].derribaPared(CeldaDelLaberinto.SUR_O) ;
        
        celdas[0][2].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        celdas[0][2].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        
        celdas[0][3].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        celdas[0][3].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        celdas[0][3].derribaPared(CeldaDelLaberinto.SUR_O) ; 
        
        celdas[0][4].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        celdas[0][4].derribaPared(CeldaDelLaberinto.SUR_O) ;
        //=====================================================================
        celdas[1][0].derribaPared(CeldaDelLaberinto.NORTE_O) ;
        celdas[1][0].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        
        celdas[1][1].derribaPared(CeldaDelLaberinto.NORTE_O) ;
        celdas[1][1].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        
        celdas[1][2].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        celdas[1][2].derribaPared(CeldaDelLaberinto.SUR_O) ;
        
        celdas[1][3].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        celdas[1][3].derribaPared(CeldaDelLaberinto.NORTE_O) ;
        
        celdas[1][4].derribaPared(CeldaDelLaberinto.NORTE_O) ;
        //=====================================================================
        celdas[2][0].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        celdas[2][0].derribaPared(CeldaDelLaberinto.SUR_O) ;
        
        celdas[2][1].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        celdas[2][1].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        
        celdas[2][2].derribaPared(CeldaDelLaberinto.NORTE_O) ;
        celdas[2][2].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        
        celdas[2][3].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        celdas[2][3].derribaPared(CeldaDelLaberinto.SUR_O) ; 
        
        celdas[2][4].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        celdas[2][4].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        //=====================================================================
        celdas[3][0].derribaPared(CeldaDelLaberinto.SUR_O) ;
        celdas[3][0].derribaPared(CeldaDelLaberinto.NORTE_O) ;
        
        celdas[3][1].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        celdas[3][1].derribaPared(CeldaDelLaberinto.SUR_O) ;
        
        celdas[3][2].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        celdas[3][2].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        
        celdas[3][3].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        celdas[3][3].derribaPared(CeldaDelLaberinto.NORTE_O) ; 
        
        celdas[3][4].derribaPared(CeldaDelLaberinto.SUR_O) ;
        //=====================================================================
        celdas[4][0].derribaPared(CeldaDelLaberinto.NORTE_O) ;
        celdas[4][0].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        
        celdas[4][1].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        celdas[4][1].derribaPared(CeldaDelLaberinto.NORTE_O) ;
        celdas[4][1].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        
        celdas[4][2].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        celdas[4][2].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        
        celdas[4][3].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        celdas[4][3].derribaPared(CeldaDelLaberinto.ESTE_O) ;
        
        celdas[4][4].derribaPared(CeldaDelLaberinto.OESTE_O) ;
        celdas[4][4].derribaPared(CeldaDelLaberinto.NORTE_O) ;
        
        CeldaDelLaberinto entrada = celdas[0][0];
        CeldaDelLaberinto salida = celdas[2][4];
        Laberinto laberinto = 
                new Laberinto(celdas,entrada,salida) ;
        
        
        return laberinto;
        
        
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
                //Establecemos como visitada para visualizar que celdas ha recorrido
                actual.estableceVisitada(true);
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
                try {
                    actual = pila.pop();
                    
                } catch (StackEmptyExceptionTDA e) {
                    /*
                    Ejercicio 13
                    El metodo pop tirara esta excepcion cuando la pila este vacia
                    ,lo que significa que ya hemos recorrido todos los posibles
                    caminos que comienzen desde la entrada y por tanto no hay camino
                    hacia la salida
                    */
                    
                    System.out.println("La pila esta vacia");
                    System.out.println("\tNo ruta de solucion");
                    // cerramos porque no hay solucion
                    System.exit(1);
                }
               
                if (laberinto.obtenSiguienteCelda(actual) != null){
                    pila.push(actual);
                }
            }
        }
        
        /**
         * Ejercicio 14
         * Cuando hacemos pop a la pila solucion el camino que tendremos nos
         * sera dado en el sentido contrario a la solucion(empezara desde la 
         * salida), por ello usaremos otra pila para invertir el orden en el que
         * hace pop la pila con la solucion. Cada valor retornado por el pop()
         * de pila ira a la nueva pila solucionPila por medio de un push() de esta
         * forma la primera celda que nos dara sera la celda de entrada y luego las
         * demas celdas de la solucion.     
         */
        StackTDA<CeldaDelLaberinto> solucionPila = new ArrayStackTDA<>();
        
        while(!pila.isEmpty()) {
            solucionPila.push(pila.pop());
        }
        System.out.println("Ruta de solución:");
        while(!solucionPila.isEmpty()){
            System.out.println(solucionPila.pop());
        }
    }
    
}
