import java.util.*;

public class MyGraph<V> implements Graph<V> {
    private final boolean undirected;
    private final Map<V, List<V>> map = new HashMap<>();

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    @Override
    public void addVertex(V v) {
        if (hasVertex(v)) return;
        map.put(v, new LinkedList<>());
    }

    @Override
    public void addEdge(V source, V dest) {
        if (!hasVertex(source)) addVertex(source);
        if (!hasVertex(dest)) addVertex(dest);
        if (hasEdge(source, dest) || source.equals(dest)) return;
        map.get(source).add(dest);
        if (undirected) map.get(dest).add(source);
    }

    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        return map.containsKey(source) && map.get(source).contains(dest);
    }

    @Override
    public List<V> adjacencyList(V v) {
        return map.get(v);
    }
}
