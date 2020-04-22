import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int vertexAmount;
    private int edgeAmount;
    private LinkedList<Integer>[] adjacencyList;
    private static int countAddVertex = 0;
    private int[] vertexArray;

    public Graph(int vertexAmount) {
        if (vertexAmount <= 0) {
            throw new IllegalArgumentException("Количество вершин графа должно быть положительным числом. Ваше значение: " + vertexAmount);
        }

        this.vertexAmount = vertexAmount;
        edgeAmount = 0;
        adjacencyList = new LinkedList[vertexAmount];
        vertexArray = new int[vertexAmount];
        Arrays.fill(vertexArray, -1);

        for (int i=0; i < vertexAmount; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public int getVertexAmount() {
        return countAddVertex;
    }

    public int getEdgeAmount() {
        return edgeAmount;
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return (LinkedList<Integer>[])adjacencyList.clone();
    }

    public void addVertex(int index) {
        if (incorrectIndex(index)) {
            throw new IndexOutOfBoundsException("Вершина графа должна иметь значение от 0 до " + (vertexAmount-1) + ". Ваше значение: " + index);
        }
        if (containsVertex(index)) {
            return;
        } else {
            vertexArray[countAddVertex] = index;
            countAddVertex++;
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        if (containsEdge(vertex1, vertex2) || vertex1 == vertex2) {
            return;
        }

        if (incorrectIndex(vertex1) || incorrectIndex(vertex2)) {
            throw new IndexOutOfBoundsException("Вершина графа должна иметь значение от 0 до " + (vertexAmount-1));
        }

        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);
        edgeAmount++;
    }

    public void showAdjacency() {
        for (int i=0; i < adjacencyList.length; i++) {
            System.out.print("Вершина " + i + ": ");
            for (int j=0; j < adjacencyList[i].size(); j++) {
                System.out.print(adjacencyList[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    private boolean containsVertex(int vertex) {
        for (int i=0; i < vertexArray.length; i++) {
            if (vertexArray[i] == vertex) {
                return true;
            }
        }
        return false;
    }

    private boolean containsEdge(int vertex1, int vertex2) {
        for (int i=0; i < adjacencyList[vertex1].size(); i++) {
            if (adjacencyList[vertex1].get(i) == vertex2) {
                return true;
            }
        }
        return false;
    }

    private boolean incorrectIndex(int index) {
        return index < 0 || index >= vertexAmount;
    }


}