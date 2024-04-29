package uni.aed.genericclass;

public class Casillero3<T> {
    private T contenido1;
    private T contenido2;
    public Casillero3() {
        this(null,null);
    }
    public Casillero3(T elemento1,T elemento2) {
        contenido1=elemento1;
        contenido2=elemento2;        
    }

    public void setContenido1(T contenido1) {
        this.contenido1 = contenido1;
    }

    public void setContenido2(T contenido2) {
        this.contenido2 = contenido2;
    }

    public T getContenido1() {
        return contenido1;
    }

    public T getContenido2() {
        return contenido2;
    }   
    
}
