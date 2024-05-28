import java.util.*;

public class WeightedGraph<V> {
    private final Map<V, Vertex<V>> vertices = new HashMap<>();
    private final boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V sourceData, V destData, double weight) {
        addVertex(sourceData);
        addVertex(destData);
        Vertex<V> source = vertices.get(sourceData);
        Vertex<V> dest = vertices.get(destData);
        source.addAdjacent(dest, weight);
        if (!directed) {
            dest.addAdjacent(source, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Collection<Vertex<V>> getAllVertices() {
        return vertices.values();
    }
}
