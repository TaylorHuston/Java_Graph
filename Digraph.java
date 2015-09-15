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
        DepthOrder sorted = new DepthOrder(DG);
        DirectedCycle hasCycle = new DirectedCycle(DG);
        Topological topSort = new Topological(DG);

        StdOut.println("Generated Directed Graph:");
        StdOut.println(DG);

        StdOut.println("This Directed Graph contains a cycle: " + hasCycle.hasCycle());

        StdOut.println("Preorder: " + sorted.pre());
        StdOut.println("Postorder: " + sorted.post());
        StdOut.println("Reverse Postorder: " + sorted.reversePost());

        if (topSort.isDAG() == true) {
            StdOut.println("Topological sort: " + topSort.order());
        }

    }
}

