/**
 Test client code for Graph implementations
 Based on Algorithms, 4th Ed by Robert Sedgewick | Kevin Wayne
 */
public class GraphTester {

    public static void main(String args[]) {
        In in = new In(args[0]);
        UndirectedGraph UD = new UndirectedGraph(in);
        StdOut.println("Generated Graph:");
        StdOut.println(UD);
        StdOut.println("Degree of vertex 3 is " + degree(UD, 3));
        StdOut.println("Max degree is " + maxDegree(UD));
        StdOut.println("Average degree is " + averageDegree(UD));
        DepthFirst dfs = new DepthFirst(UD, 12);
        StdOut.println("Depth First Path from vertex 12 to vertex 9: " + dfs.pathTo(9));
        dfs = new DepthFirst(UD, 9);
        StdOut.println("Depth First Path from vertex 9 to vertex 12: " + dfs.pathTo(12));
        BreadthFirst bfs = new BreadthFirst(UD, 0);
        StdOut.println("Shortest Path from vertex 0 to vertex 5: " + bfs.pathTo(5));


    }

    //Computer the degree of vertex V
    public static int degree(UndirectedGraph G, int V) {
        int degree = 0;
        for (int w : G.adj(V)) {
            degree++;
        }
        return degree;
    }

    //Find the vertex with the largest degree
    public static int maxDegree(UndirectedGraph G) {
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
    public static double averageDegree (UndirectedGraph G) {
        return (2.0 * G.E()/G.V());
    }

}
