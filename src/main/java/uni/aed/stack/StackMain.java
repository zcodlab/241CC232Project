package uni.aed.stack;
public class StackMain {
    public static void main(String[] args){
        StackMain stackMain=new StackMain();
        stackMain.arrayStackTDA();
    }
    private void arrayStackTDA(){
        StackTDA<String> pila=new ArrayStackTDA<>(3);
        pila.push("Jose");
        pila.push("Juan");
        pila.push("Mario");
        System.out.println("Despues de ingresar elementos a la pila");
        System.out.println(pila.toString());
        System.out.println("Realizando una llamada de tipo pop");
        System.out.println(pila.pop());
        System.out.println("Despues de realizar una llamado pop");
        System.out.println(pila.toString());
        System.out.println("Realizando una llamada de tipo peek");
        System.out.println(pila.peek());
        System.out.println("Despues de realizar una llamado peek");
        System.out.println(pila.toString());
        
    }
    
}
