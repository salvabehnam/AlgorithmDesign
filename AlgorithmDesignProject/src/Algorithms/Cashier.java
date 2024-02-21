package Algorithms;

import java.io.*;
import java.util.*;

// Java program to find minimum number of denominations

public class Cashier {
    // All denominations of Indian Currency

    public Cashier(int V, String path) throws IOException {
        System.out.println("Enter Your Cash Array Type a character to end");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<>();

        while (scanner.hasNextInt()) a.add(scanner.nextInt());

        int[] cashes = a.stream().filter(Objects::nonNull).mapToInt(i -> i).toArray();

        FileWriter outFile = new FileWriter(path);
        // Initialize result
        Vector<Integer> ans = new Vector<>();

        // Traverse through all denomination
        for (int i = cashes.length - 1; i >= 0; i--) {
            // Find denominations
            while (V >= cashes[i]) {
                V -= cashes[i];
                ans.add(cashes[i]);
            }
        }

        // Print result
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(" " + ans.elementAt(i));
            outFile.write(" " + ans.elementAt(i));
        }
        outFile.close();
    }
}