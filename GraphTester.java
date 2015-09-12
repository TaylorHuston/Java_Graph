/**
 Test client code for Graph implementations
 Based on Algorithms, 4th Ed by Robert Sedgewick | Kevin Wayne
 */
public class GraphTester {

    public static void main(String args[]) {
        In in = new In(args[0]);
        In in2 = new In(args[0]);
        Graph UD = new Graph(in2);
        Digraph DG = new Digraph(in);

        StdOut.println("Generated Undirected Graph:");
        StdOut.println(UD);
        StdOut.println("Degree of vertex 3 is " + degree(UD, 3));
        StdOut.println("Max degree is " + maxDegree(UD));
        StdOut.println("Average degree is " + averageDegree(UD));

        DepthFirst dfs = new DepthFirst(UD, 12);
        StdOut.println("Depth First Path from vertex 12 to vertex 9: " + dfs.pathTo(9));
        dfs = new DepthFirst(UD, 9);
        StdOut.println("Depth First Path from vertex 9 to vertex 12: " + dfs.pathTo(12));
        BreadthFirst bfs = new BreadthFirst(UD, 9);
        StdOut.println("Shortest Path from vertex 9 to vertex 12: " + bfs.pathTo(12));
        StdOut.println();

        ConnectedComponents cc = new ConnectedComponents(UD);
        int count = cc.count();

        StdOut.println("There are " + count + " connected components:");
        Queue<Integer>[] comps = (Queue<Integer>[]) new Queue[count];

        for (int i = 0; i < count; i++) {
            comps[i] = new Queue<Integer>();
        }

        for (int v = 0; v < UD.V(); v++) {
            comps[cc.id(v)].enqueue(v);
        }

        for (int i = 0; i < count; i++) {
            for (int v : comps[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

        StdOut.println();
        StdOut.println("Generated Directed Graph:");
        StdOut.println(DG);
        StdOut.println("Degree of vertex 5 is " + degree(DG, 5));
        StdOut.println("Max degree is " + maxDegree(DG));
        StdOut.println("Average degree is " + averageDegree(DG));

        dfs = new DepthFirst(DG, 12);
        StdOut.println("Depth First Path from vertex 12 to vertex 9: " + dfs.pathTo(9));
        dfs = new DepthFirst(DG, 9);
        StdOut.println("Depth First Path from vertex 9 to vertex 12: " + dfs.pathTo(12));
        bfs = new BreadthFirst(DG, 9);
        StdOut.println("Shortest Path from vertex 9 to vertex 12: " + bfs.pathTo(12));
        StdOut.println();

        cc = new ConnectedComponents(DG);
        count = cc.count();

        StdOut.println("There are " + count + " connected components:");
        comps = (Queue<Integer>[]) new Queue[count];

        for (int i = 0; i < count; i++) {
            comps[i] = new Queue<Integer>();
        }

        for (int v = 0; v < DG.V(); v++) {
            comps[cc.id(v)].enqueue(v);
        }

        for (int i = 0; i < count; i++) {
            for (int v : comps[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }


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
    public static double averageDegree (Graph G) {
        return (2.0 * G.E()/G.V());
    }

}
