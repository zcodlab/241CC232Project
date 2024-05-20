package uni.aed.queueTDA;

public class QueueEmptyExceptionTDA extends RuntimeException{

    public QueueEmptyExceptionTDA() {
        this("Cola Vacia");
    }
    public QueueEmptyExceptionTDA(String msg) {
        super(msg);
    }
    
    
}
