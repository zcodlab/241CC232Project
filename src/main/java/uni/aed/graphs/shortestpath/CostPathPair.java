package uni.aed.graphs.shortestpath;

import java.util.Iterator;
import java.util.List;
import uni.aed.graphs.Edge;

public class CostPathPair<T extends Comparable<T>> {
    private int cost = 0;
    private List<Edge<T>> path = null;
    
    //constructor
    public CostPathPair(int cost, List<Edge<T>> path) {
        if (path == null)
            throw (new NullPointerException("path cannot be NULL."));

        this.cost = cost;
        this.path = path;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Edge<T>> getPath() {
        return path;
    }

    /**
     * Obtiene el hashCode multiplicando el hash inicial por el costo de cada arista en la ruta.
     * El hash final se multiplica por 31, un número primo, que es una práctica común en las implementaciones     
     * de código hash para reducir la probabilidad de colisiones y mejorar la distribución.
     */
    @Override
    public int hashCode() {
        int hash = this.cost;  // Initialize hash with the cost of the path
        for (Edge<T> e : path)  // Iterate over each edge in the path
            hash *= e.getCost();      // Update hash by multiplying it with the cost of each edge
        return 31 * hash;       // Multiply the final hash by a prime number (31 is commonly used) and return it
    }


    /**
     * Este método se utiliza para comprobar si dos instancias de la clase CostPathPair son iguales 
     * en función de sus costos y rutas.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CostPathPair))//verifica si obj es una instancia de la clase CostPathPair.
            return false;

        final CostPathPair<?> pair = (CostPathPair<?>) obj;//convierte obj a CostPathPair y compara sus costos.
        if (this.cost != pair.cost)
            return false;

        final Iterator<?> iter1 = this.getPath().iterator();//getPath() retorna una lista de aristas
        final Iterator<?> iter2 = pair.getPath().iterator();//getPath() retorna una lista de aristas
        while (iter1.hasNext() && iter2.hasNext()) {//recorre las dos listas de aristas
            Edge<T> e1 = (Edge<T>) iter1.next();    
            Edge<T> e2 = (Edge<T>) iter2.next();
            if (!e1.equals(e2))                 //compara cada par de aristas (e1 y e2) de las rutas
                return false;                      //si las listas son distintas en alguna arista, retorna falso, rutas son distintas
        }

        return true;                               //rutas son iguales
    }

    /**
     * Este método proporciona una representación legible de un objeto, 
     * incluido costo y detalles de cada arista en la ruta(path).
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Cost = ").append(cost).append("\n");
        for (Edge<T> e : path)
            builder.append("\t").append(e);
        return builder.toString();
    }
}
