import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create and populate the weighted graph
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        populateWeightedGraph(weightedGraph);

        // Perform Dijkstra's algorithm and print the path
        System.out.println("Dijkstra:");
        Search<String> dijkstraSearch = new DijkstraSearch<>(weightedGraph, "New York");
        printPath(dijkstraSearch, "Los Angeles");

        System.out.println("--------------------------------");

        // Create and populate the unweighted graph
        MyGraph<String> unweightedGraph = new MyGraph<>(true);
        populateUnweightedGraph(unweightedGraph);

        // Perform BFS and print the path
        System.out.println("BFS:");
        Search<String> bfsSearch = new BreadthFirstSearch<>(unweightedGraph, "New York");
        printPath(bfsSearch, "Los Angeles");
    }

    // Method to populate the unweighted graph
    private static void populateUnweightedGraph(Graph<String> graph) {
        graph.addEdge("New York", "Chicago");
        graph.addEdge("Chicago", "Denver");
        graph.addEdge("Denver", "Los Angeles");
        graph.addEdge("New York", "Atlanta");
        graph.addEdge("Atlanta", "Dallas");
        graph.addEdge("Dallas", "Los Angeles");
        graph.addEdge("Denver", "San Francisco");
    }

    // Method to populate the weighted graph
    private static void populateWeightedGraph(WeightedGraph<String> graph) {
        graph.addEdge("New York", "Chicago", 5.0);
        graph.addEdge("Chicago", "Denver", 4.0);
        graph.addEdge("Denver", "Los Angeles", 6.0);
        graph.addEdge("New York", "Atlanta", 3.0);
        graph.addEdge("Atlanta", "Dallas", 2.0);
        graph.addEdge("Dallas", "Los Angeles", 3.5);
        graph.addEdge("Denver", "San Francisco", 4.5);
    }

    // Method to print the path found by the search algorithm
    private static void printPath(Search<String> search, String destination) {
        Iterable<String> path = search.pathTo(destination);
        if (path != null && path.iterator().hasNext()) {
            for (String vertex : path) {
                System.out.print(vertex + " -> ");
            }
            System.out.println("end");
        } else {
            System.out.println("No path found");
        }
    }
}
