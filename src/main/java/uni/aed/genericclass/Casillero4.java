package uni.aed.genericclass;
public class Casillero4<T extends Number> {
    private T contenido;
    public Casillero4() {
        this(null);
    }
    public Casillero4(T contenido) {
        this.contenido = contenido;
    }
    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
    
}
