import java.util.ArrayList;
import java.util.Arrays;

/**
 * ADD ANOTHER AUTHOR TAG WITH YOUR OWN NAME!
 *
 * @author Tom Magliery
 * @version 37
 */
public class Main {

    public static void main(String[] args) {

        // One of the example graphs from the Lab7 handout
        // NOT a directed graph - remove for Lab8
        System.out.println();
        Graph G1 = makeG1();
        System.out.println("Graph G1:");
        System.out.print("G1 ");
        G1.DFS_driver();
        G1.Display_DFS_results();
        G1.TopoSort();

        System.out.println();
        Graph G2 = makeG2();
        System.out.println("Graph G2:");
        System.out.print("G2 ");
        G2.DFS_driver();
        G2.Display_DFS_results();
        G2.TopoSort();

        // Another example graph from the Lab7 handout
        // NOT a directed graph - remove for Lab8
        System.out.println();
        Graph G3 = makeG3();
        System.out.println("Graph G3:");
        System.out.print("G3 ");
        G3.DFS_driver();
        G3.Display_DFS_results();
        G3.TopoSort();

        // This is the directed-graph example from the Lab7 handout
        // It is harmless to use here for another example in Lab8, but
        // it is not one of the examples given in the Lab8 handout.
        // However, look at the "makeG4()" function to see how this 
        // Graph class requires you to set a flag for a directed graph.
        System.out.println();
        Graph G4 = makeG4();
        System.out.println("Graph G4:");
        G4.DFS_driver();
        G4.Display_DFS_results();
        G4.TopoSort();


        // This is the 8-vertex example from the DFS and BFS section
        // of the lecture notes. It is NOT a directed graph so you can
        // remove it for Lab8.
        System.out.println();
        Graph GL = makeG5();
        System.out.println("Graph G5:");
        GL.DFS_driver();
        GL.Display_DFS_results();
        GL.TopoSort();

    }

    /**
     * Just a helper function to reduce the clutter in main()
     */
    private static Graph makeG1() {
        Graph G1 = new Graph(6);
        G1.setDirected(true); // superfluous
        G1.setVertices(new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f")));
        G1.addEdge(0, 1); //ab
        G1.addEdge(0, 5); //ae
        G1.addEdge(1, 2); //af
        G1.addEdge(3, 2); //bf
        G1.addEdge(3, 1); //bg
        G1.addEdge(4, 3); //cd
        G1.addEdge(5, 4); //cg
        G1.addEdge(5, 2); //dh
        return G1;
    }

    /**
     * Just a helper function to reduce the clutter in main()
     */
    private static Graph makeG2() {
        Graph G2 = new Graph(4);
        G2.setDirected(true); // superfluous
        G2.setVertices(new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        G2.addEdge(0, 1); //ab
        G2.addEdge(0, 2); //ae
        G2.addEdge(0, 3); //af
        G2.addEdge(1, 3); //ab
        G2.addEdge(2, 2); //ae
        return G2;
    }

    /**
     * Just a helper function to reduce the clutter in main()
     */
    private static Graph makeG3() {
        Graph G3 = new Graph(9);
        G3.setDirected(true); // superfluous
        G3.setVertices(new ArrayList<>(Arrays.asList("shirt", "tie", "suspenders", "jacket", "belt", "pants", "shoes", "socks", "underware")));
        G3.addEdge(0, 1); //ab
        G3.addEdge(0, 2); //ae
        G3.addEdge(0, 3); //af
        G3.addEdge(1, 3); //bf
        G3.addEdge(2, 3); //bg
        G3.addEdge(4, 3); //cd
        G3.addEdge(5, 4); //cg
        G3.addEdge(5, 2); //dh
        G3.addEdge(5, 6); //dh
        G3.addEdge(7, 6); //dh
        G3.addEdge(8, 5); //dh
        return G3;
    }

    /**
     * Just a helper function to reduce the clutter in main()
     */
    private static Graph makeG4() {
        Graph G4 = new Graph(6);
        // need to set this flag so the Graph knows it is directed
        G4.setDirected(true);
        G4.setVertices(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6")));
        G4.addEdge(4, 5);
        G4.addEdge(4, 0);
        G4.addEdge(4, 1);
        G4.addEdge(5, 1);
        G4.addEdge(5, 2);
        G4.addEdge(0, 3);
        G4.addEdge(3, 2);
        G4.addEdge(1, 3);
        G4.addEdge(1, 2);
        return G4;
    }

    private static Graph makeG5() {
        Graph G = new Graph(5);
        G.setDirected(true); // superfluous
        G.setVertices(new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e")));
        G.addEdge(0, 1); //ab
        G.addEdge(0, 2); //ae
        G.addEdge(1, 2); //af
        G.addEdge(1, 4); //bf
        G.addEdge(2, 4); //bg
        G.addEdge(3, 0); //cd
        G.addEdge(3, 1); //cg
        G.addEdge(3, 2); //dh
        G.addEdge(3, 4); //dh
        return G;
    }
}
