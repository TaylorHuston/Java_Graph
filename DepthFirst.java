/**
 Depth First search of a graph
 Based on Algorithms, 4th Ed by Robert Sedgewick | Kevin Wayne
 */
public class DepthFirst {
    private boolean[] marked; //Keep track of already visited vertices
    private int[] edgeTo; //Last vertex on known path to this vertex
    private final int source; //Starting vertex

    public DepthFirst(UndirectedGraph G, int source) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.source = source;
        dfs(G, source);
    }

    //Recursively traverse each path until you reach a 'dead end'
    private void dfs(UndirectedGraph G, int current) {
        marked[current] = true;
        for (int next : G.adj(current)) {
            if (marked[next] == false) {
                edgeTo[next] = current;
                dfs(G, next);
            }
        }
    }

    //Has the vertex v been visited?
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    //Return the path from the source to vertex v
    public Iterable<Integer> pathTo(int v) {
        if (hasPathTo(v) == false) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int i = v; i != source; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(source);
        return path;
    }

}
