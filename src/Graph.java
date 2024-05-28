import java.util.List;

public interface Graph<V> {
    void addVertex(V v);
    void addEdge(V source, V dest);
    List<V> adjacencyList(V v);
}
