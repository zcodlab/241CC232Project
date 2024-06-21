package uni.aed.graphs.shortestpath;

import uni.aed.graphs.Vertex;

public class CostVertexPair<T extends Comparable<T>> implements Comparable<CostVertexPair<T>> {
    private int cost = Integer.MAX_VALUE;
    private Vertex<T> vertex = null;
    //constructor
    public CostVertexPair(int cost, Vertex<T> vertex) {
        if (vertex == null)
            throw (new NullPointerException("vertex cannot be NULL."));

        this.cost = cost;
        this.vertex = vertex;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    /**     
     * Obtiene el hashCode multiplicando this.cost por el hashcode del vértice(recursivo)(o 1 si el vértice es nulo).
     * se multiplica por 31, un número primo, que es una práctica común en las implementaciones java para hashcodes
     */
    @Override
    public int hashCode() {
        return 31 * (this.cost * ((this.vertex!=null)?this.vertex.hashCode():1));
    }

    /**
     * compara dos objetos de tipo CostVertexPair en funcion de su costo y de su vertice
     */
    @Override
    public boolean equals(Object e1) {
        if (!(e1 instanceof CostVertexPair))
            return false;

        final CostVertexPair<?> pair = (CostVertexPair<?>)e1;
        if (this.cost != pair.cost)
            return false;

        if (!this.vertex.equals(pair.vertex))
            return false;

        return true;
    }

    /**
     * compara dos objetos de tipo CostVertexPair en funcion de su costo
     */
    @Override
    public int compareTo(CostVertexPair<T> p) {
        if (p == null)
            throw new NullPointerException("CostVertexPair 'p' must be non-NULL.");

        if (this.cost < p.cost)
            return -1;
        if (this.cost > p.cost)
            return 1;
        return 0;
    }

    /**
     * Retorna un string con el vertice, su peso y costo
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(vertex.getValue()).append(" (")
                .append(vertex.getWeight()).append(") ")
                .append(" cost=")
                .append(cost).append("\n");
        return builder.toString();
    } 
}
