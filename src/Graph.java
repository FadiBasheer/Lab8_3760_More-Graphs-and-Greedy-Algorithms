import java.util.ArrayList;

/**
 * ADD ANOTHER AUTHOR TAG WITH YOUR OWN NAME!
 *
 * @author Tom Magliery
 * @version 37
 */
public class Graph {
    private ArrayList<String> vertices = new ArrayList<String>();
    private ArrayList<String> DFS_results = new ArrayList<String>();
    private ArrayList<String> TopoSort_results = new ArrayList<String>();

    public void Display_DFS_results() {
        System.out.println("DFS results");
        for (String str : DFS_results) {
            System.out.print(str + " ");
        }
        System.out.print("\n");
    }

    public void TopoSort() {
        System.out.println("TopoSort results");
//        for (int i = DFS_results.size() - 1; i >= 0; i--) {
//            TopoSort_results.add(DFS_results.get(i));
//        }
        for (int i = TopoSort_results.size() - 1; i >= 0; i--) {
            System.out.print(TopoSort_results.get(i) + " ");
        }
        System.out.print("\n");
    }

    public ArrayList<String> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<String> vertices) {
        this.vertices = vertices;
    }

    /**
     * Number of vertices in the graph
     */
    private int numVertices = 0;

    /**
     * Adjacency matrix representation of the edges
     */
    private String[][] adjMatrix;

    /**
     * Flag to indicate if this is a directed graph
     */
    private boolean directed = false;

    /**
     * Array of flags for the vertices - used by DFS and BFS algorithms
     */
    private boolean[] visited;

    /**
     * Create a new Graph object.
     *
     * @param N - number of vertices in the graph.
     */
    public Graph(int N) {
        numVertices = N;
        // Initially the graph has no edges ("empty" adjacency matrix)
        adjMatrix = new String[N][N];
        for (int u = 0; u < N; u++) {
            for (int v = 0; v < N; v++) {
                adjMatrix[u][v] = "*";
            }
        }
        // Mark all vertices as un-visited (although the algorithms using it
        // should also enforce it themselves as needed)
        visited = new boolean[N];
        setAllVisitedFlags(false);
        return;
    }

    /**
     * Set the state of whether this graph is directed or undirected.
     *
     * @param val
     */
    public void setDirected(boolean val) {
        directed = val;
        return;
    }

    /**
     * Return true if this is a directed graph.
     *
     * @return
     */
    public boolean isDirected() {
        return directed;
    }

    /**
     * Sets the "visited" flags of all the vertices to the specified value.
     *
     * @param flag
     */
    private void setAllVisitedFlags(boolean flag) {
        for (int v = 0; v < numVertices; v++) {
            visited[v] = flag;
        }
        return;
    }

    /**
     * Add one new edge to the graph, an edge from vertex u to v.
     *
     * @param u
     * @param v
     */
    public void addEdge(int u, int v) {
        if (!directed) {
            // If the graph is undirected, we need two entries in the matrix
            adjMatrix[u][v] = vertices.get(v);
            adjMatrix[v][u] = vertices.get(u);
        } else {
            // For directed graphs, we only need one entry in the matrix
            adjMatrix[u][v] = vertices.get(v);
        }
        return;
    }

    /**
     * Return the degree of a vertex if the graph is undirected.
     * For directed graphs this method is irrelevant and returns -1.
     *
     * @param v
     * @return Degree of the given vertex if the graph is undirected
     * @return -1 if the graph is directed
     */
    public int degree(int v) {
        if (directed) {
            return -1;
        } else {
            int count = 0;
            for (int i = 0; i < numVertices; i++) {
                if (!adjMatrix[v][i].equals("*")) {
                    count++;
                }
            }
            return count;
        }
    }

    /**
     * @param v
     * @return
     */
    public int inDegree(int v) {
        if (!directed) {
            return -1;
        } else {
            int count = 0;
            for (int i = 0; i < numVertices; i++) {
                if (!adjMatrix[i][v].equals("*")) {
                    count++;
                }
            }
            return count;
        }
    }

    /**
     * @param v
     * @return
     */
    public int outDegree(int v) {
        if (!directed) {
            return -1;
        } else {
            int count = 0;
            for (int i = 0; i < numVertices; i++) {
                if (!adjMatrix[v][i].equals("*")) {
                    count++;
                }
            }
            return count;
        }
    }

    /**
     *
     */
    public String toString() {
        String str = "Adjacency matrix:\n";
        for (int u = 0; u < numVertices; u++) {
            str += (vertices.get(u)) + ": ";
            for (int v = 0; v < numVertices; v++) {
                str += (adjMatrix[u][v]) + " ";
            }
            str += "\n";
        }
        if (!directed) {
            str += "Vertex degrees: ";
            for (int v = 0; v < numVertices; v++) {
                str += Integer.toString(degree(v)) + ",";
            }
            str += "\n";
            return str;
        } else {
            str += "In-degrees: ";
            for (int v = 0; v < numVertices; v++) {
                str += Integer.toString(inDegree(v)) + ",";
            }
            str += "\nOut-degrees: ";
            for (int v = 0; v < numVertices; v++) {
                str += Integer.toString(outDegree(v)) + ",";
            }
            str += "\n";
            return str;
        }
    }

    /**
     * Perform a Depth-First Search on the graph.
     */
    public void DFS_driver() {
        setAllVisitedFlags(false);
        for (int v = 0; v < numVertices; v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }
        return;
    }

    /**
     * @param v
     */
    private void dfs(int v) {
        //System.out.println("Visiting vertex " + v);
        DFS_results.add(vertices.get(v));
        visited[v] = true;
        for (int w = 0; w < numVertices; w++) {
            if (!adjMatrix[v][w].equals("*")) {
                if (!visited[w]) {
                    dfs(w);
                }
            }
        }
        TopoSort_results.add(vertices.get(v));
        return;
    }

}
