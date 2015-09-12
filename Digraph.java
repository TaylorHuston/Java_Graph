/**
 * Created by Taylor on 9/11/2015.
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

    public static void main (String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        StdOut.println(G);

    }
}

