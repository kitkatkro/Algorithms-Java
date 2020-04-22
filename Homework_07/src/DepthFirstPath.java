import java.util.LinkedList;

public class DepthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int start;

    public DepthFirstPath(Graph g, int start) {
        this.start = start;
        edgeTo = new int[g.getVertexAmount()];
        marked = new boolean[g.getVertexAmount()];
        dfs(g, start);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w: g.getAdjacencyList()[v]) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean hashPathTo(int v) {
        return marked[v];
    }

    public LinkedList<Integer> pathTo(int v) {
        if(!hashPathTo(v)) {
            return null;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;

        while (vertex != start) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }

        return stack;
    }
}
