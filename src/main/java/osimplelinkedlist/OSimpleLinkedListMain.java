package osimplelinkedlist;

import java.util.Scanner;
import uni.aed.model.Bicicleta;

public class OSimpleLinkedListMain {
    public static void main(String[] args){
        OSimpleLinkedListMain lista=new OSimpleLinkedListMain();
        lista.TestBicicleta();
    }
    private void TestBicicleta(){
        Scanner escaner =new Scanner(System.in);
        Bicicleta b;
        OSimpleLinkedList olista=new OSimpleLinkedList();
        String nombre;
        System.out.println("Consigne nombres de propietarios de Bicicletas");
        while(true){
            nombre=escaner.next();
            if(!nombre.equalsIgnoreCase("salir")){
                b=new Bicicleta(nombre);
                olista.addLast(b);
            }
            else
                break;
        }
        System.out.println("Visualizar el contenido de la lista");
        System.out.println(olista.toString());
        
        System.out.println("Eliminando un elemento de la lista");
        System.out.println("Consigne el elemento a eliminar");
        nombre=escaner.next();
        b=new Bicicleta(nombre);
        olista.remove(b);
        
        System.out.println("Visualizar el contenido de la lista");
        System.out.println(olista.toString());
    }
}
