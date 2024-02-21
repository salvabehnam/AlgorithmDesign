package Algorithms;
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list representation
public class BFS {
    private int V;   // No. of vertices
    private LinkedList[] adj; //Adjacency Lists

    // Constructor
    private BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    private void addEdge(int v, int w) { adj[v].add(w); }

    // prints BFS traversal from a given source s
    private void BFS(int s, String path) throws IOException {
        FileWriter outFile = new FileWriter(path);

        // Mark all the vertices as not visited(By default set as false)
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");
            outFile.write(s + " " + "/n");
            // Get all adjacent vertices of the deQueued vertex s If a adjacent has not been visited, then mark it visited and enqueue it
            for (int n : (Iterable<Integer>) adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        outFile.close();
    }

    // Driver method to
    public static void start(String path) throws IOException {
        System.out.println("Enter vertex counts and starting vertex");
        int n = new Scanner(System.in).nextInt(), m = new Scanner(System.in).nextInt();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Edge Count");
        int k = new Scanner(System.in).nextInt();
        System.out.println("Enter Edges : [Starting Node,Ending Node]");
        BFS g = new BFS(n);
        String[] a;
        for (int i = 0; i < k; i++) {
            a = scanner.nextLine().split(",");
            g.addEdge(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
        }
        System.out.println("Following is Breadth First Traversal "+ "(starting from vertex "+ m + ")");
        g.BFS(m,path);
    }
}