import Algorithms.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter File path you need to save");
        String path = scanner.nextLine().trim();
        if (path.isEmpty()) path = "D:\\File.txt";
        System.out.println("Select Your algorithm: \nStable Matching \nBFS \nCashier \nKruskal \nQuick Sort \nWeighted Interval Scheduling \nExit");
        String AlgorithmName = scanner.nextLine().trim();
        while (!AlgorithmName.equals("Exit")) {
            switch (AlgorithmName) {
                case "Stable Matching":
                    StableMatching.start(path);
                    break;
                case "BFS":
                    BFS.start(path);
                    break;
                case "Cashier":
                    System.out.println("Enter value");
                    new Cashier(scanner.nextInt(), path);
                    break;
                case ("Kruskal"):
                    Kruskal.start(path);
                    break;
                case "Quick Sort":
                    QuickSort.start(path);
                    break;
                case "Weighted Interval Scheduling":
                    WeightedIntervalScheduling.start(path);
                    break;
                default:
                    System.out.println("No Algorithm Found");
                    break;
            }
            scanner = new Scanner(System.in);
            System.out.println("Select Your algorithm: \nStable Matching \nBFS \nCashier \nKruskal \nQuick Sort \nWeighted Interval Scheduling \nExit");
            AlgorithmName = scanner.nextLine().trim();
        }
    }
}
