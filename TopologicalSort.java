/**
 Calculates the
 Based on Algorithms, 4th Ed by Robert Sedgewick | Kevin Wayne
 */
public class TopologicalSort {
    private boolean[] marked; //Keep track of already visited vertices
    private Stack<Integer> topSorted;

    public TopologicalSort(Graph G, int source) {
        topSorted = new Stack<Integer>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            dfs(G, v);
        }
    }

    //Recursively traverse each path until you reach a 'dead end'
    private void dfs(Graph G, int current) {
        marked[current] = true;
        for (int next : G.adj(current)) {
            if (marked[next] == false) {
                dfs(G, next);
            }
            topSorted.push(current);
        }
    }

    //Return the stack
    public Iterable<Integer> sorted() {
        return topSorted;
    }
}
