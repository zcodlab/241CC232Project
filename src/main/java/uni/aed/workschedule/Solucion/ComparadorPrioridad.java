package uni.aed.workschedule.Solucion;

import java.util.Comparator;

// Clase ComparadorPrioridad con el que podra complementar la cola con prioridad
public class ComparadorPrioridad implements Comparator<Trabajo>{
    @Override
    public int compare(Trabajo t1, Trabajo t2) {
        return Integer.compare(t1.getPrioridad(), t2.getPrioridad());
    }
}
