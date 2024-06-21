package uni.aed.graphs.shortestpath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import uni.aed.graphs.*;

/**
 * Dijkstra's shortest path. Only works on non-negative path weights. Returns a
 * tuple of total cost of shortest path and the path. 
 * Worst case: O(|E| + |V| log |V|)   
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class Dijkstra {
    //constructor privado
    private Dijkstra() { }
    //metodo que determina la ruta mas corta
    public static Map<Vertex<Integer>, CostPathPair<Integer>> 
        getShortestPaths(Graph<Integer> graph, Vertex<Integer> start) {
        
        //hashmap de vertices o nodos y sus aristas    
        final Map<Vertex<Integer>, List<Edge<Integer>>> paths = new HashMap<>();
        
        //hashmap de vertices o nodos y sus costos
        final Map<Vertex<Integer>, CostVertexPair<Integer>> costs = new HashMap<>();
        
        //llamada al metodo sobrecargado getShortestPath con cuatro parametros
        //(grafo,nodo inicial,nodo final=null,hashmap de rutas y hashmap de costos)
        getShortestPath(graph, start, null, paths, costs);
        
        //hashmap de vertices y costo de la ruta
        final Map<Vertex<Integer>, CostPathPair<Integer>> map = new HashMap<>();
        
        //recorremos el mapa de vertices o nodos y sus costos
        for (CostVertexPair<Integer> pair : costs.values()) {
            int cost = pair.getCost();
            Vertex<Integer> vertex = pair.getVertex();
            List<Edge<Integer>> path = paths.get(vertex);
            //consignamos en el hashmap de vertices y costo de la ruta: el vertice, objeto CostPathPair con costo y ruta
            map.put(vertex, new CostPathPair<>(cost, path));
        }
        return map;
    }

    public static CostPathPair<Integer> 
        getShortestPath(Graph<Integer> graph, Vertex<Integer> start, Vertex<Integer> end) {
            
        if (graph == null)
            throw (new NullPointerException("Graph must be non-NULL."));

        // Dijkstra's algorithm only works on positive cost graphs
        final boolean hasNegativeEdge = checkForNegativeEdges(graph.getVertices());
        
        if (hasNegativeEdge)
            throw (new IllegalArgumentException("Negative cost Edges are not allowed."));
        
        //crea un hashmap de vertices o nodos y sus aristas 
        final Map<Vertex<Integer>, List<Edge<Integer>>> paths = new HashMap<>();
        //crea un hashmap de vertices o nodos y sus costos 
        final Map<Vertex<Integer>, CostVertexPair<Integer>> costs = new HashMap<>();
        
        //llamada recursiva al mismo metodo
        return getShortestPath(graph, start, end, paths, costs);
    }

    private static CostPathPair<Integer> 
        getShortestPath(Graph<Integer> graph, 
                      Vertex<Integer> start, Vertex<Integer> end,
                      Map<Vertex<Integer>, List<Edge<Integer>>> paths,
                      Map<Vertex<Integer>, CostVertexPair<Integer>> costs) {
        if (graph == null)
            throw (new NullPointerException("Graph must be non-NULL."));
        if (start == null)
            throw (new NullPointerException("start must be non-NULL."));

        // Dijkstra's algorithm only works on positive cost graphs
        boolean hasNegativeEdge = checkForNegativeEdges(graph.getVertices());
        if (hasNegativeEdge)
            throw (new IllegalArgumentException("Negative cost Edges are not allowed."));
        
        //descarga los vertices o nodos del grafo en el hashmap paths como primer parametro y un arraylist como 2° parametro
        for (Vertex<Integer> v : graph.getVertices())
            paths.put(v, new ArrayList<>());
        //recorre el grafo y por cada vertice lo compara con el vertice inicial
        for (Vertex<Integer> v : graph.getVertices()) {
            if (v.equals(start))            //si son iguales consigna cero como costo del vertice
                costs.put(v, new CostVertexPair<>(0, v));
            else //si no son iguales inicializa el costo con un entero muy grande=infinito teorico como costo del vertice
                costs.put(v, new CostVertexPair<>(Integer.MAX_VALUE, v));
        }
        
        //declara una cola prioritaria
        final Queue<CostVertexPair<Integer>> unvisited = new PriorityQueue<>();
        //añade a la cola el hashmap de costos del vertice inicial
        unvisited.add(costs.get(start));
        
        //mientras la cola no este vacia
        while (!unvisited.isEmpty()) {
            //desencola o elimina el primer elemento de la cola
            final CostVertexPair<Integer> pair = unvisited.remove();
            //obtiene el vertice del elemento desencolado
            final Vertex<Integer> vertex = pair.getVertex();
            
            //Calcula los costos desde el vértice actual hasta todos los vértices adyacentes que no han sido visitados
            for (Edge<Integer> e : vertex.getEdges()) {
                //obtiene el objeto CostVertexPair del hashmap costos del vertice destino del vertice actual 
                final CostVertexPair<Integer> toPair = costs.get(e.getToVertex()); // O(1)
                //obtiene el objeto CostVertexPair costo menor del hashmap costos del objeto vertext actual
                final CostVertexPair<Integer> lowestCostToThisVertex = costs.get(vertex); // O(1)
                //suma el costo del objeto CostVertexPair determinado en la linea anterio mas el costo de la arista actual
                final int cost = lowestCostToThisVertex.getCost() + e.getCost();
                
                //verifica si el objeto CostVertexPair del hashmap costos del vertice destino del vertice actual es infinito
                // vertice aun no ha sido visitado
                if (toPair.getCost() == Integer.MAX_VALUE) {                    
                    //desencolar el par, actualizar su costo y volver a encolar
                    unvisited.remove(toPair); // O(n)
                    toPair.setCost(cost);
                    unvisited.add(toPair); // O(log n)

                    // actualiza las rutas
                    List<Edge<Integer>> set = paths.get(e.getToVertex()); // O(log n)
                    set.addAll(paths.get(e.getFromVertex())); // O(log n)
                    set.add(e);
                } else if (cost < toPair.getCost()) {                    
                    //Encontró un camino más corto hacia un vértice accesible

                    //desencolar el par, actualizar su costo y volver a encolar
                    unvisited.remove(toPair); // O(n)
                    toPair.setCost(cost);
                    unvisited.add(toPair); // O(log n)

                    //actualiza las rutas
                    List<Edge<Integer>> set = paths.get(e.getToVertex()); // O(log n)
                    set.clear();
                    set.addAll(paths.get(e.getFromVertex())); // O(log n)
                    set.add(e);
                }
            }

            // condiciones de terminacion del ciclo
            if (end != null && vertex.equals(end)) {                
                //Buscamos y encontramos el camino más corto a un vértice específico
                break;
            }
        }

        if (end != null) {
            final CostVertexPair<Integer> pair = costs.get(end);
            final List<Edge<Integer>> set = paths.get(end);
            return (new CostPathPair<>(pair.getCost(), set));
        }
        return null;
    }

    private static boolean checkForNegativeEdges(Collection<Vertex<Integer>> vertices) {
        for (Vertex<Integer> v : vertices) {
            for (Edge<Integer> e : v.getEdges()) {
                if (e.getCost() < 0)
                    return true;
            }
        }
        return false;
    }
}
