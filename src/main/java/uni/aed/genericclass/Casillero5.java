package uni.aed.genericclass;

public class Casillero5<T extends Number> {
    private T contenido;

    public Casillero5() {
        this(null);
    }

    public Casillero5(T contenido) {
        this.contenido = contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
    
    public boolean isSameValue(Casillero5<?> contenido){
        return this.getContenido().doubleValue()==contenido.getContenido().doubleValue();
    }
}
