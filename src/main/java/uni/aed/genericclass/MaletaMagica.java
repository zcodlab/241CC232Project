package uni.aed.genericclass;

public class MaletaMagica<T> implements ContenedorMagico<T> {
    private T contenido;

    public MaletaMagica() {
        set(null);
    }
    
    @Override
    public T get() {
        return contenido;
    }

    @Override
    public void set(T contenido) {
        this.contenido=contenido;
    }
    
    
}
