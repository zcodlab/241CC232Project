package uni.aed.genericclass;
public class GenericClassMain {
    public static void main(String[] args){
        GenericClassMain gc=new GenericClassMain();
        System.out.println("Clase Generica Casillero1, con un parametro de tipo");
        gc.casillero1();
        System.out.println("Clase Generica Casillero2, con dos parametros de tipo");
        gc.casillero2();
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
    private void casillero2(){
        Casillero2<String,Integer> casillero;
        casillero=new Casillero2<>("Mochila",100);
        
        Casillero2<String,String> saludo;
        saludo=new Casillero2<>("Curso","AED");
        
        System.out.println("El Casillero tiene el contenido:"
                +casillero.getContenido1()+"-"+casillero.getContenido2().toString());
        System.out.println("El saludo es:"
                +saludo.getContenido1()+"-"+saludo.getContenido2());        
    }
}
