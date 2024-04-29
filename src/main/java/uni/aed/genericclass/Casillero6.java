package uni.aed.genericclass;

public class Casillero6<T extends Number>  {
    private T contenido;

    public Casillero6() {
        this(null);
    }

    public Casillero6(T contenido) {
        this.contenido = contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
    
    public boolean isSameValue(Casillero6<T> contenido){
        return this.getContenido().doubleValue()==contenido.getContenido().doubleValue();
    }
}
