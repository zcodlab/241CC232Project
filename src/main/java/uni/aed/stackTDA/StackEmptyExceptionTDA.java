package uni.aed.stackTDA;

public class StackEmptyExceptionTDA extends RuntimeException{

    public StackEmptyExceptionTDA() {
        this("La Pila esta vacia");
    }

    public StackEmptyExceptionTDA(String message) {
        super(message);
    }
}
