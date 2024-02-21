package Algorithms;
import java.io.*;
import java.util.*;

// Java program for Kruskal's algorithm to find Minimum Spanning Tree of a given connected, undirected and weighted graph
public class Kruskal {
    // A class to represent a graph edge
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // Comparator function used for sorting edgesBased on their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    // A class to represent a subset for union-find
    static class subset { int parent, rank; }

    private int V;
    private Edge[] edge; // collection of all edges

    // Creates a graph with V vertices and E edges
    private Kruskal(int v, int e) {
        V = v;
        // V-> no. of vertices & E->no.of edges
        edge = new Edge[e];
        for (int i = 0; i < e; ++i) edge[i] = new Edge();
    }

    // A utility function to find set of an element i (uses path compression technique)
    private int find(subset[] subsets, int i) {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i) subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y (uses union by rank)
    private void Union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank) subsets[xroot].parent = yroot;

        else if (subsets[xroot].rank > subsets[yroot].rank) subsets[yroot].parent = xroot;

        // If ranks are same, then make one as root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    private void KruskalMST(String path) throws IOException {
        FileWriter outFile = new FileWriter(path);
        // This will store the resultant MST
        Edge[] result = new Edge[V];

        // An index variable, used for result[]
        int e = 0;

        // An index variable, used for sorted edges
        int i;
        for (i = 0; i < V; ++i) result[i] = new Edge();

        // Step 1: Sort all the edges in non-decreasing order of their weight. If we are not allowed to change the given graph, we can create a copy of array of edges
        Arrays.sort(edge);

        // Allocate memory for creating V's subsets
        subset[] subsets = new subset[V];
        for (i = 0; i < V; ++i) subsets[i] = new subset();

        // Create V subsets with single elements
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0; // Index used to pick next edge

        // Number of edges to be taken is equal to V-1
        while (e < V - 1) {
            // Step 2: Pick the smallest edge. And increment the index for next iteration
            Edge next_edge;
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle, include it in result and increment the index of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        // print the contents of result[] to display the built MST
        System.out.println("Following are the edges in the constructed MST");
        outFile.write("Following are the edges in the constructed MST\n");

        int minimumCost = 0;

        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            outFile.write(result[i].src + " -- " + result[i].dest + " == " + result[i].weight + "\n");
            minimumCost += result[i].weight;
        }

        System.out.println("Minimum Cost Spanning Tree " + minimumCost);
        outFile.write("Minimum Cost Spanning Tree " + minimumCost + "\n");
    }

    // Driver Code
    public static void start(String path) throws IOException {
        System.out.println("Enter Vertex Count:");
        int V = new Scanner(System.in).nextInt();

        System.out.println("Enter Edge Count:");
        int E = new Scanner(System.in).nextInt();

        Kruskal graph = new Kruskal(V, E);

        System.out.println("Enter Source Vertex, Destination Vertex and Edge's Weight (for example 0,2,3) then press Enter");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < V; i++) {
            String[] a = scanner.nextLine().split(",");
            graph.edge[i].src = Integer.parseInt(a[0]);
            graph.edge[i].dest = Integer.parseInt(a[1]);
            graph.edge[i].weight = Integer.parseInt(a[2]);
        }

        // Function call
        graph.KruskalMST(path);
    }
}