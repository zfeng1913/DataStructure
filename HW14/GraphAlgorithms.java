import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Your implementation of various graph traversal algorithms.
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
      Map<Vertex<T>, List<VertexDistance<T>>> adjList = graph.getAdjList();
      List<Vertex<T>> visited = new ArrayList<>();
      Queue<Vertex<T>> queue = new LinkedList<>();
      visited.add(start);
      queue.add(start);
      while (!queue.isEmpty()) {
        Vertex<T> v = queue.remove();
        for (VertexDistance<T> w : adjList.get(v)){
          if (!visited.contains(w.getVertex())){
            visited.add(w.getVertex());
            queue.add(w.getVertex());
          }
        }
      }
      return visited;

    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
     private static <T> void dfs_helper(Vertex<T> vertex, Graph<T> graph,
                                 Set<Vertex<T>> vs, List<Vertex<T>> result) {
         result.add(vertex);
         vs.add(vertex);

         for (VertexDistance<T> vd : graph.getAdjList().get(vertex)) {
             if (!vs.contains(vd.getVertex())) {
                 dfs_helper(vd.getVertex(), graph, vs, result);
             }
         }
     }
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        Set<Vertex<T>> visited = new HashSet<>();
        List<Vertex<T>> result = new ArrayList<>();
        dfs_helper(start, graph, visited, result);
        return result;
    }



    public static <T> Map<Vertex<T>, Integer> dijkstras(Vertex<T> start,
                                                        Graph<T> graph) {
        Queue<VertexDistance<T>> queue = new PriorityQueue<>();
        Map<Vertex<T>, Integer> result = new HashMap<>();

        for (Vertex<T> v : graph.getAdjList().keySet()) {
            if (v.equals(start)) {
                result.put(v, 0);
            } else {
                result.put(v, Integer.MAX_VALUE);
            }
        }

        queue.add(new VertexDistance<>(start, 0));
        while (!queue.isEmpty()) {
            VertexDistance<T> tmp = queue.remove();
            for (VertexDistance<T> vd
                    : graph.getAdjList().get(tmp.getVertex())) {
                int distance = tmp.getDistance() + vd.getDistance();
                if (result.get(vd.getVertex()) > distance) {
                    result.put(vd.getVertex(), distance);
                    queue.add(new VertexDistance<>(vd.getVertex(), distance));
                }
            }
        }
        return result;
    }
}
