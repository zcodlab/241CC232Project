package uni.aed.genericclass;
public class GenericClassMain {
    public static void main(String[] args){
        GenericClassMain gc=new GenericClassMain();
        gc.casillero1();
    }    
    private void casillero1(){
        Casillero1<String> casilleroUno;
        Casillero1<Integer> casilleroDos;
        casilleroUno=new Casillero1<>();
        casilleroDos=new Casillero1<>();
        casilleroUno.setContenido("Mochila");
        casilleroDos.setContenido(100);
        
        System.out.println("El Casillero1 tiene el contenido:"+casilleroUno.getContenido());
        System.out.println("El Casillero2 tiene el contenido:"+casilleroDos.getContenido().toString());
    }
}
