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
        System.out.println("Despues de ingresar elementos a la pila");
        System.out.println(pila.toString());
    }
    
}
