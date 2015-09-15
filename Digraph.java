/**
 * Directed Graph implementation
 * Based on Algorithms, 4th Ed by Robert Sedgewick | Kevin Wayne
 */
public class Digraph extends Graph {
    Digraph(int V) {
        super(V);
    }

    Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();

        for (int i = 0; i < E; i++) {
            int first = in.readInt();
            int second = in.readInt();
            addEdge(first, second);
        }
    }

    public void addEdge(int first, int second) {
        adjLists[first].add(second);
        E++;
    }

    //Return this graph with all of the edges reversed
    public Digraph reverse() {
        Digraph reversed = new Digraph(V);
        for (int first = 0; first < V; first++) {
            for (int second : adj(first)) {
                reversed.addEdge(second, first);
            }
        }
        return reversed;
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";

        for (int v = 0; v < V; v++) {
            for (int e : this.adj(v)) {
                s += v + " -> " + e + "\n";
            }
        }
        return s;
    }


    public static void main(String args[]) {
        In in = new In(args[0]);
        Digraph DG = new Digraph(in);
        TopologicalSort sorted = new TopologicalSort(DG);

        StdOut.println("Generated Directed Graph:");
        StdOut.println(DG);

        DirectedCycle hasCycle = new DirectedCycle(DG);
        StdOut.println("This Directed Graph contains a cycle: " + hasCycle.hasCycle());

        StdOut.println("Preorder: " + sorted.pre());
        StdOut.println("Postorder: " + sorted.post());
        StdOut.println("Reverse Postorder: " + sorted.reversePost());

        DepthFirst dfs = new DepthFirst(DG, 12);
        StdOut.println("Depth First Path from vertex 12 to vertex 9: " + dfs.pathTo(9));
        dfs = new DepthFirst(DG, 9);
        StdOut.println("Depth First Path from vertex 9 to vertex 12: " + dfs.pathTo(12));
        BreadthFirst bfs = new BreadthFirst(DG, 9);
        StdOut.println("Shortest Path from vertex 9 to vertex 12: " + bfs.pathTo(12));
        StdOut.println();

    }

    //Computer the degree of vertex V
    public static int degree(Graph G, int V) {
        int degree = 0;
        for (int w : G.adj(V)) {
            degree++;
        }
        return degree;
    }

    //Find the vertex with the largest degree
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            int temp = degree(G, v);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    //Compute the average degree
    public static double averageDegree(Graph G) {
        return (2.0 * G.E() / G.V());
    }
}

