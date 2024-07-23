package uni.aed.workschedule.Solucion;

import java.util.InputMismatchException;
import java.util.Scanner;

// Clase App para la inicialización de nuestro menú de ayuda al usuario
public class App {
    static Scanner sc = new Scanner(System.in);
    static Simulacion sm;
    
    public static void main(String[] args) {                
        int i = 1, menu;
        
        // Formación y demostración de nuestros parámetros hacia el usuario con las distintas opciones que se pueden considerar
        while(i == 1){
            System.out.println("\nBienvenido al simulador de agenda de trabajos, seleccione la opción que desee");
            System.out.println("1. Cargar Agenda de Trabajo");
            System.out.println("2. Obtener el tiempo de espera promedio");
            System.out.println("3. Obtener el tiempo de espera máximo por nivel de prioridad");
            System.out.println("4. Visualizar Agenda de Trabajo");
            System.out.println("5. Eliminar actual Agenda de Trabajo");
            System.out.println("6. Salir");
            
            // Clausula de excepciones para casos en los que se indiquen valores no enteros o opciones no validas
            try{
                System.out.print("--> ");
                menu = sc.nextInt();
                sc.nextLine();
            }catch(InputMismatchException e){
                menu = 0;
                sc.nextLine();
            }
            
            switch(menu){
                case(0)->{
                    System.out.println("Valor ingresado incorrecto, vuelva a intentarlo, se le mostrará nuevamente las opciones\n");
                    break;
                }
                case(1)->{
                    Integer m, n;
                    System.out.println("Ingrese los parámetros para la simulación: ");
                    System.out.print("M (Minutos a simular): ");
                    m = sc.nextInt();
                    sc.nextLine();
                    System.out.print("N (Capacidad de concurrencia de la computadora): ");
                    n = sc.nextInt();
                    sc.nextLine();
                    sm = new Simulacion(m, n);
                    sm.comenzarSimulacion();
                    System.out.println("La agenda fue cargada correctamente\n");
                    break;
                }
                case(2)->{
                    if(sm == null){
                        System.out.println("La agenda de trabajo aún no ha sido inicializada, vuelva a intentarlo\n");
                    }else{
                        sm.obtenerTiempoEsperaGeneral();
                        sm.obtenerTiempoEsperaPromedioPrioridad();
                    }
                    break;
                }
                case(3)->{
                    if(sm == null){
                        System.out.println("La agenda de trabajo aún no ha sido inicializada, vuelva a intentarlo\n");
                    }else{
                        sm.obtenerTiempoEsperaMaximoPrioridad();
                    }
                    break;
                }
                case(4)->{
                    if(sm == null){
                        System.out.println("La agenda de trabajo aún no ha sido inicializada, vuelva a intentarlo\n");
                    }else{
                        sm.mostrar();
                    }
                    break;
                }
                case(5)->{
                    sm = null;
                    System.out.println("La agenda fue eliminada satisfactoriamente\n");
                    break;
                }
                case(6)->{
                    System.out.println("Fin del Programa\n");
                    i = 0;
                    break;
                }
            }
        }
    }    
}
