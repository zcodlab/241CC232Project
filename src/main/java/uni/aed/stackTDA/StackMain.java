package uni.aed.stackTDA;

import java.util.Scanner;

public class StackMain {
    public static void main(String[] args){
        StackMain stackMain=new StackMain();
        stackMain.menu();
    }
    private void menu()
    {
        StackTDA<String> pila;
        int accion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese qué tipo de stack desea\n 1:ArrayStack\n2:LinkedStack\n3:ListStack");
        accion = sc.nextInt();
        switch(accion)
        {
            case 1:
                pila = new ArrayStackTDA<>();
                break;
            case 2:
                pila = new LinkedStackTDA<>();
                break;
            case 3:
                pila = new ListStackTDA<>();
                break;
            default:
                pila = new ArrayStackTDA<>();
        }
        
        do
        {
            System.out.println("Ingrese un número según la acción que desea realizar:\n1:push\n2: peek\n3: pop\n-1: Salir");
            accion = sc.nextInt();
            switch(accion)
            {
                case 1:
                    System.out.println("Ingrese el elemento a añadir");
                    pila.push(sc.next());
                    break;
                case 2:
                    System.out.println("El primer elemento de la pila es: " + pila.peek());
                    break;
                case 3:
                    System.out.println("El elemento eliminado es: " + pila.pop());
                    break;
                case -1: return;
            }
            System.out.println("El estado de la pila es: " + pila.toString());
        }while(accion != -1);
    }
    
}
