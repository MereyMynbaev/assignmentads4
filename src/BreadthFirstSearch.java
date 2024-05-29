import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private final Map<V, V> edgeTo = new HashMap<>();
    private final V source;

    public BreadthFirstSearch(Graph<V> graph, V sourceData) {
        this.source = sourceData;
        bfs(graph, source);
    }

    private void bfs(Graph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        Set<V> visited = new HashSet<>();
        queue.offer(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            V current = queue.poll();
            for (V neighbor : graph.adjacencyList(current)) {
                if (!visited.contains(neighbor)) {
                    edgeTo.put(neighbor, current);
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    @Override
    public Iterable<V> pathTo(V destinationData) {
        List<V> path = new ArrayList<>();
        if (!edgeTo.containsKey(destinationData) && !destinationData.equals(source)) {
            return path;
        }
        for (V vertex = destinationData; vertex != null; vertex = edgeTo.get(vertex)) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }
}
