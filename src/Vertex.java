import java.util.*;

public class Vertex<V> {
    private final V data;
    private final Map<Vertex<V>, Double> adjacentVertices = new HashMap<>();

    public Vertex(V data) {
        this.data = data;
    }

    public V getData() {
        return data;
    }

    public void addAdjacent(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public Map<Vertex<V>, Double> getAdjacent() {
        return adjacentVertices;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
