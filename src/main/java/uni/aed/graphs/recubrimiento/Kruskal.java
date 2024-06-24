package uni.aed.graphs.recubrimiento;

import uni.aed.graphs.Graph;
import uni.aed.graphs.Vertex;
import uni.aed.graphs.Edge;
import uni.aed.graphs.shortestpath.CostPathPair;

import java.util.*;

/**
 * Kruskal's minimum spanning tree. Only works on undirected graphs. It finds a
 * subset of the edges that forms a tree that includes every vertex, where the
 * total weight of all the edges in the tree is minimized.
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Kruskal%27s_algorithm">Kruskal's Algorithm (Wikipedia)</a>
 * <br>
 * @author Bartlomiej Drozd <mail@bartlomiejdrozd.pl>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class Kruskal {

    private Kruskal() { }

    public static CostPathPair<Integer> getMinimumSpanningTree(Graph<Integer> graph) {
        if (graph == null)
            throw (new NullPointerException("Graph must be non-NULL."));

        // Kruskal's algorithm only works on undirected graphs
        if (graph.getType() == Graph.TYPE.DIRECTED)
            throw (new IllegalArgumentException("Undirected graphs only."));

        int cost = 0;
        final List<Edge<Integer>> path = new ArrayList<>();

        // Prepare data to store information which part of tree given vertex is
        HashMap<Vertex<Integer>, HashSet<Vertex<Integer>>> membershipMap = new HashMap<>();
        for (Vertex<Integer> v : graph.getVertices()) {
            HashSet<Vertex<Integer>> set = new HashSet<>();
            set.add(v);
            membershipMap.put(v, set);
        }

        // We make queue of edges to consider all of them, starting with edge with the lowest cost,
        // it is important that Edge's class comparator is not natural (ex. sorting is from the biggest to the lowest)
        PriorityQueue<Edge<Integer>> edgeQueue = new PriorityQueue<>(graph.getEdges());

        while (!edgeQueue.isEmpty()) {
            Edge<Integer> edge = edgeQueue.poll();

            // If from vertex and to vertex are from different parts of tree then add this edge to result and union vertices' parts
            if (!isTheSamePart(edge.getFromVertex(), edge.getToVertex(), membershipMap)) {
                union(edge.getFromVertex(), edge.getToVertex(), membershipMap);
                path.add(edge);
                cost += edge.getCost();
            }
        }


        return (new CostPathPair<>(cost, path));
    }

    private static boolean isTheSamePart(Vertex<Integer> v1, Vertex<Integer> v2, HashMap<Vertex<Integer>, HashSet<Vertex<Integer>>> membershipMap) {
        return membershipMap.get(v1) == membershipMap.get(v2);
    }

    private static void union(Vertex<Integer> v1, Vertex<Integer> v2, HashMap<Vertex<Integer>, HashSet<Vertex<Integer>>> membershipMap) {
        HashSet<Vertex<Integer>> firstSet = membershipMap.get(v1); //first set is the bigger set
        HashSet<Vertex<Integer>> secondSet = membershipMap.get(v2);

        // we want to include smaller set into bigger, so second set cannot be bigger than first
        if (secondSet.size() > firstSet.size()) {
            HashSet<Vertex<Integer>>  tempSet = firstSet;
            firstSet = secondSet;
            secondSet = tempSet;
        }

        // changing part membership of each vertex from smaller set
        for (Vertex<Integer> v : secondSet) {
            membershipMap.put(v, firstSet);
        }

        // adding all vertices from smaller set to bigger one
        firstSet.addAll(secondSet);
    }
}
