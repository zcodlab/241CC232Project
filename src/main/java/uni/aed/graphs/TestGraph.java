package uni.aed.graphs;

import uni.aed.graphs.shortestpath.CostPathPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import uni.aed.graphs.shortestpath.Dijkstra;
import uni.aed.graphs.TopologicalSort.TopologicalSort;
import uni.aed.graphs.recubrimiento.Kruskal;
import uni.aed.graphs.recubrimiento.Prim;

public class TestGraph {
    public static void main(String[] args) { 
//Queda pendiente refactorizar y colocar un menu
//        System.out.println("-----------------PrimUndirected--------------------");
//        testPrimUndirected();
        System.out.println("-----------------KruskalUndirected--------------------");
        testKruskalUndirected();
//        System.out.println("-----------------topologicalSort--------------------");
//        topologicalSortOnDirectedGraph();
//        System.out.println("-----------------undirectedGraph--------------------");
//        UndirectedGraph undirectedGraph = new UndirectedGraph();        
//        System.out.println(undirectedGraph.toString());
//        //probando el algoritmo de Dijkstra
//        testDijkstraUndirected();
//        
//        System.out.println("-----------------directedGraph--------------------");
//        DirectedGraph directedGraph = new DirectedGraph();
//        System.out.println(directedGraph.toString());
//        
//        System.out.println("-----------------directedWithNegativeWeights--------------------");
//        DirectedWithNegativeWeights directedWithNegativeWeights = new DirectedWithNegativeWeights();        
//        System.out.println(directedWithNegativeWeights.graph.toString());
    }
    
    private static class UndirectedGraph{//1.grafo no dirigido
        final List<Vertex<Integer>> verticies = new ArrayList<>();
        final Vertex<Integer> v1 = new Vertex<>(1);
        final Vertex<Integer> v2 = new Vertex<>(2);
        final Vertex<Integer> v3 = new Vertex<>(3);
        final Vertex<Integer> v4 = new Vertex<>(4);
        final Vertex<Integer> v5 = new Vertex<>(5);
        final Vertex<Integer> v6 = new Vertex<>(6);
        final Vertex<Integer> v7 = new Vertex<>(7);
        final Vertex<Integer> v8 = new Vertex<>(8);
        {
        verticies.add(v1);
        verticies.add(v2);
        verticies.add(v3);
        verticies.add(v4);
        verticies.add(v5);
        verticies.add(v6);
        verticies.add(v7);
        verticies.add(v8);}
        
        final List<Edge<Integer>> edges = new ArrayList<>();
        final Edge<Integer> e1_2 = new Edge<>(7, v1, v2);
        final Edge<Integer> e1_3 = new Edge<>(9, v1, v3);
        final Edge<Integer> e1_6 = new Edge<>(14, v1, v6);
        final Edge<Integer> e2_3 = new Edge<>(10, v2, v3);
        final Edge<Integer> e2_4 = new Edge<>(15, v2, v4);
        final Edge<Integer> e3_4 = new Edge<>(11, v3, v4);
        final Edge<Integer> e3_6 = new Edge<>(2, v3, v6);
        final Edge<Integer> e5_6 = new Edge<>(9, v5, v6);
        final Edge<Integer> e4_5 = new Edge<>(6, v4, v5);
        final Edge<Integer> e1_7 = new Edge<>(1, v1, v7);
        final Edge<Integer> e1_8 = new Edge<>(1, v1, v8);
        
        {edges.add(e1_2);
        edges.add(e1_3);
        edges.add(e1_6);
        edges.add(e2_3);
        edges.add(e2_4);
        edges.add(e3_4);
        edges.add(e3_6);
        edges.add(e5_6);
        edges.add(e4_5);
        edges.add(e1_7);
        edges.add(e1_8);}
        
        final Graph<Integer> graph = new Graph<>(verticies, edges);
        @Override
        public String toString() {
            return graph.toString();
        }        
    }
    private static class DirectedGraph{//2.grafo dirigido
        final List<Vertex<Integer>> verticies = new ArrayList<>();
        final Vertex<Integer> v1 = new Vertex<>(1);
        final Vertex<Integer> v2 = new Vertex<>(2);
        final Vertex<Integer> v3 = new Vertex<>(3);
        final Vertex<Integer> v4 = new Vertex<>(4);
        final Vertex<Integer> v5 = new Vertex<>(5);
        final Vertex<Integer> v6 = new Vertex<>(6);
        final Vertex<Integer> v7 = new Vertex<>(7);
        final Vertex<Integer> v8 = new Vertex<>(8);
        
        {verticies.add(v1);
        verticies.add(v2);
        verticies.add(v3);
        verticies.add(v4);
        verticies.add(v5);
        verticies.add(v6);
        verticies.add(v7);
        verticies.add(v8);}
        
        final List<Edge<Integer>> edges = new ArrayList<>();
        final Edge<Integer> e1_2 = new Edge<>(7, v1, v2);
        final Edge<Integer> e1_3 = new Edge<>(9, v1, v3);
        final Edge<Integer> e1_6 = new Edge<>(14, v1, v6);
        final Edge<Integer> e2_3 = new Edge<>(10, v2, v3);
        final Edge<Integer> e2_4 = new Edge<>(15, v2, v4);
        final Edge<Integer> e3_4 = new Edge<>(11, v3, v4);
        final Edge<Integer> e3_6 = new Edge<>(2, v3, v6);
        final Edge<Integer> e6_5 = new Edge<>(9, v6, v5);
        final Edge<Integer> e6_8 = new Edge<>(14, v6, v8);
        final Edge<Integer> e4_5 = new Edge<>(6, v4, v5);
        final Edge<Integer> e4_7 = new Edge<>(16, v4, v7);
        final Edge<Integer> e1_8 = new Edge<>(30, v1, v8);
        
        {edges.add(e1_2);
        edges.add(e1_3);
        edges.add(e1_6);
        edges.add(e2_3);
        edges.add(e2_4);
        edges.add(e3_4);
        edges.add(e3_6);
        edges.add(e6_5);
        edges.add(e6_8);
        edges.add(e4_5);
        edges.add(e4_7);
        edges.add(e1_8);}
        
        final Graph<Integer> graph = new Graph<>(Graph.TYPE.DIRECTED, verticies, edges);        
        
        @Override
        public String toString() {
            return graph.toString();
        }
    }
    public static class DirectedWithNegativeWeights{//3.Grafos dirigidos con pesos negativos
        final List<Vertex<Integer>> verticies = new ArrayList<>();
        final Vertex<Integer> v1 = new Vertex<>(1);
        final Vertex<Integer> v2 = new Vertex<>(2);
        final Vertex<Integer> v3 = new Vertex<>(3);
        final Vertex<Integer> v4 = new Vertex<>(4);
        
        {verticies.add(v1);
        verticies.add(v2);
        verticies.add(v3);
        verticies.add(v4);}
        
        final List<Edge<Integer>> edges = new ArrayList<>();
        final Edge<Integer> e1_4 = new Edge<>(2, v1, v4);  // w->z
        final Edge<Integer> e2_1 = new Edge<>(6, v2, v1);  // x->w
        final Edge<Integer> e2_3 = new Edge<>(3, v2, v3);  // x->y
        final Edge<Integer> e3_1 = new Edge<>(4, v3, v1);  // y->w
        final Edge<Integer> e3_4 = new Edge<>(5, v3, v4);  // y->z
        final Edge<Integer> e4_2 = new Edge<>(-7, v4, v2); // z->x
        final Edge<Integer> e4_3 = new Edge<>(-3, v4, v3); // z->y
        
        {edges.add(e1_4);
        edges.add(e2_1);
        edges.add(e2_3);
        edges.add(e3_1);
        edges.add(e3_4);
        edges.add(e4_2);
        edges.add(e4_3);}
        
        final Graph<Integer> graph = new Graph<>(Graph.TYPE.DIRECTED, verticies, edges);
        
        @Override
        public String toString() {
            return graph.toString();
        } 
    }
    
    public static void testDijkstraUndirected() {
        final UndirectedGraph undirected = new UndirectedGraph();
        final Vertex<Integer> start = undirected.v1;
        final Vertex<Integer> end = undirected.v5;
        
        {
        final Map<Vertex<Integer>, CostPathPair<Integer>> map 
                = Dijkstra.getShortestPaths(undirected.graph, start);
        
        // Compare results
        CostPathPair<Integer> path,pair;
        System.out.println("****Dijkstra.getShortestPaths del vertice inicial: "+start.getValue()+" ****");
        for (Vertex<Integer> v : map.keySet()) {
            System.out.println("v=" + v.getValue());
            path = map.get(v);
            System.out.println("Dijkstra's shortest path=" + path);
        }
        
        System.out.println("****Dijkstra.getShortestPath del vertice inicial: "+start.getValue()+" vertice final: "+end.getValue()+" ****");
        pair = Dijkstra.getShortestPath(undirected.graph, start, end);
        System.out.println("Ruta desde " + start.getValue() + " to " + 
                end.getValue()+ " (pair != null)= " + (pair != null));        
        System.out.println(pair);
    }          
  }
  public static void topologicalSortOnDirectedGraph() {
    // DIRECTED GRAPH
    final List<Vertex<Integer>> verticies = new ArrayList<>();
    final Vertex<Integer> cv1 = new Vertex<>(1);
    verticies.add(cv1);
    final Vertex<Integer> cv2 = new Vertex<>(2);
    verticies.add(cv2);
    final Vertex<Integer> cv3 = new Vertex<>(3);
    verticies.add(cv3);
    final Vertex<Integer> cv4 = new Vertex<>(4);
    verticies.add(cv4);
    final Vertex<Integer> cv5 = new Vertex<>(5);
    verticies.add(cv5);
    final Vertex<Integer> cv6 = new Vertex<>(6);
    verticies.add(cv6);

    final List<Edge<Integer>> edges = new ArrayList<>();
    final Edge<Integer> ce1_2 = new Edge<>(1, cv1, cv2);
    edges.add(ce1_2);
    final Edge<Integer> ce2_4 = new Edge<>(2, cv2, cv4);
    edges.add(ce2_4);
    final Edge<Integer> ce4_3 = new Edge<>(3, cv4, cv3);
    edges.add(ce4_3);
    final Edge<Integer> ce3_6 = new Edge<>(4, cv3, cv6);
    edges.add(ce3_6);
    final Edge<Integer> ce5_6 = new Edge<>(5, cv5, cv6);
    edges.add(ce5_6);
    final Edge<Integer> ce4_5 = new Edge<>(6, cv4, cv5);
    edges.add(ce4_5);

    final Graph<Integer> digraph = new Graph<>(Graph.TYPE.DIRECTED, verticies, edges);

    final List<Vertex<Integer>> results1 = TopologicalSort.sort(digraph);
    System.out.println("Los elementos del Digrafo es");
    System.out.println(digraph.toString());

    System.out.println("Las aristas del digrafo");
    System.out.println(digraph.getEdges().toString());

    System.out.println("Topological sort. results="+results1);
        
    }    
    public static void testKruskalUndirected() {
        final UndirectedGraph undirected = new UndirectedGraph();
        final CostPathPair<Integer> resultMST = Kruskal.getMinimumSpanningTree(undirected.graph);
        System.out.println("Kruskal's minimum spanning tree. resultMST=" + resultMST);        
    }
    public static void testPrimUndirected() {
        final UndirectedGraph undirected = new UndirectedGraph();

        Vertex<Integer> start = undirected.v1;
        {
            final CostPathPair<Integer> resultMST = Prim.getMinimumSpanningTree(undirected.graph, start);
            {
                // Ideal MST
                final int cost = 35;
                final List<Edge<Integer>> list = new ArrayList<>();
                list.add(undirected.e1_7);
                list.add(undirected.e1_8);
                list.add(undirected.e1_2);
                list.add(undirected.e1_3);
                list.add(undirected.e3_6);
                list.add(new Edge<>(9, undirected.v6, undirected.v5));
                list.add(new Edge<>(6, undirected.v5, undirected.v4));
                final CostPathPair<Integer> idealMST = new CostPathPair<>(cost, list);
                System.out.println("Prim's minimum spanning tree error. resultMST="+resultMST+" idealMST="+idealMST);
                
            }

            // Prim on a graph with cycles
            final List<Vertex<Integer>> cyclicVerticies = new ArrayList<>();
            final Vertex<Integer> cv1 = new Vertex<>(1);
            cyclicVerticies.add(cv1);
            final Vertex<Integer> cv2 = new Vertex<>(2);
            cyclicVerticies.add(cv2);
            final Vertex<Integer> cv3 = new Vertex<>(3);
            cyclicVerticies.add(cv3);
            final Vertex<Integer> cv4 = new Vertex<>(4);
            cyclicVerticies.add(cv4);
            final Vertex<Integer> cv5 = new Vertex<>(5);
            cyclicVerticies.add(cv5);

            final List<Edge<Integer>> cyclicEdges = new ArrayList<>();
            final Edge<Integer> ce1_2 = new Edge<>(3, cv1, cv2);
            cyclicEdges.add(ce1_2);
            final Edge<Integer> ce2_3 = new Edge<>(2, cv2, cv3);
            cyclicEdges.add(ce2_3);
            final Edge<Integer> ce3_4 = new Edge<>(4, cv3, cv4);
            cyclicEdges.add(ce3_4);
            final Edge<Integer> ce4_1 = new Edge<>(1, cv4, cv1);
            cyclicEdges.add(ce4_1);
            final Edge<Integer> ce4_5 = new Edge<>(1, cv4, cv5);
            cyclicEdges.add(ce4_5);

            final Graph<Integer> cyclicUndirected = new Graph<>(Graph.TYPE.UNDIRECTED, cyclicVerticies, cyclicEdges);

            start = cv1;

            final CostPathPair<Integer> pair4 = Prim.getMinimumSpanningTree(cyclicUndirected, start);
            {
                // Ideal MST
                final int cost = 7;
                final List<Edge<Integer>> list = new ArrayList<>();
                list.add(new Edge<>(1, cv1, cv4));
                list.add(ce4_5);
                list.add(ce1_2);
                list.add(ce2_3);
                final CostPathPair<Integer> result4 = new CostPathPair<>(cost, list);
                System.out.println("Prim's minimum spanning tree error. pair4="+pair4+" result4="+result4);                
            }
        }
    }
  
}
