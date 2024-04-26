package uni.aed.genericclass;
public class Casillero1<T> {
    private T contenido;
    public Casillero1() {
        this(null);
    }
    public Casillero1(T contenido) {
        this.contenido = contenido;
    }
    public void setContenido(T contenido) {
        this.contenido = contenido;
    }
    public T getContenido() {
        return contenido;
    }
    
    
    
}
