/**
 Calculates the number of connected components on a graph via Depth First Search
 Based on Algorithms, 4th Ed by Robert Sedgewick | Kevin Wayne
 */
public class ConnectedComponents {
    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponents(UndirectedGraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];

        //Cycle through graph and run a dfs on any unvisited vertext, that constitutes a new
        //connected component
        for (int i = 0; i < G.V(); i++) {
            if (marked[i] == false) {
                dfs(G, i);
                count++;
            }
        }
    }

    //Depth First mark each vertext in a given connected component
    private void dfs(UndirectedGraph G, int v) {
        marked[v] = true;
        id[v] = count;

        for (int i : G.adj(v)) {
                if (marked[i] == false) {
                    dfs(G, i);
                }
        }
    }

    //Are first and second in the same component?
    public boolean connected(int first, int second) {
        return (id[first] == id[second]);
    }

    public int id(int vertex) {
        return id[vertex];
    }

    public int count() {
        return count;
    }
}
