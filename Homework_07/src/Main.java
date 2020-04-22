import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addVertex(9);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(2,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(3,6);

        BreadthFirstPath path = new BreadthFirstPath(graph, 0);
        System.out.println(path.pathTo(3));

    }
}
