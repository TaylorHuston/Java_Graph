/**
 Undirected Graph implementation
 Based on Algorithms, 4th Ed by Robert Sedgewick | Kevin Wayne
 */
public class UndirectedGraph {

    private final int V; //# of vertices
    private int E; //# of edges
    private Bag<Integer>[] adjLists;  //Array of adjacency lists

    //Constructor with a pre-supplied number of vertices
    UndirectedGraph (int V) {
        this.V = V;
        this.E = 0;
        adjLists = (Bag<Integer>[]) new Bag[V];

        for (int i = 0; i < V; i++) {
            adjLists[i] = new Bag<Integer>();
        }

    }

    //Constructor with a graph built from input stream
    UndirectedGraph (In in) {
        this(in.readInt());
        int E = in.readInt();

        for (int i = 0; i < E; i++) {
            int first = in.readInt();
            int second = in.readInt();
            addEdge(first, second);
        }

    }

    //Number of vertices
    public int V() {
        return V;
    }

    //Number of edges
    public int E() {
        return E;
    }

    //Connect two vertices (first to second)
    public void addEdge(int first, int second) {
        adjLists[first].add(second);
        adjLists[second].add(first);
        E++;
    }

    //Retieve iterable list of vertices adjacent to vertex
    public Iterable<Integer> adj(int vertex) {
        return adjLists[vertex];
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";

        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int e : this.adj(v)) {
                s += e + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main (String args[]) {
        In in = new In(args[0]);
        UndirectedGraph G = new UndirectedGraph(in);
        StdOut.println(G);

    }
}
