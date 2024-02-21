package Algorithms;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// Java program for Weighted Job Scheduling in O(nLog(n)) time

// Class to represent a job
class Job {
    int start, finish, profit;

    Job(int start, int finish, int profit) {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }
}

// Used to sort job according to finish times
class JobComparator implements Comparator<Job> { public int compare(Job a, Job b) { return Integer.compare(a.finish, b.finish); }}

public class WeightedIntervalScheduling {
    /* A Binary Search based function to find the latest job
    (before current job) that doesn't conflict with current
    job. "index" is index of the current job. This function
    returns -1 if all jobs before index conflict with it.
    The array jobs[] is sorted in increasing order of finish
    time. */
    private static int binarySearch(Job[] jobs, int index) {
        // Initialize 'lo' and 'hi' for Binary Search
        int lo = 0, hi = index - 1;

        // Perform binary Search iteratively
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (jobs[mid].finish <= jobs[index].start) {
                if (jobs[mid + 1].finish <= jobs[index].start) lo = mid + 1;
                else return mid;
            } else hi = mid - 1;
        }
        return -1;
    }

    // The main function that returns the maximum possible profit from given array of jobs
    private static int schedule(Job[] jobs) {
        // Sort jobs according to finish time
        Arrays.sort(jobs, new JobComparator());

        // Create an array to store solutions of subProblems. table[i] stores the profit for jobs till jobs[i] (including jobs[i])
        int n = jobs.length;
        int[] table = new int[n];
        table[0] = jobs[0].profit;

        // Fill entries in M[] using recursive property
        for (int i=1; i<n; i++) {
            // Find profit including the current job
            int inclProf = jobs[i].profit;
            int l = binarySearch(jobs, i);
            if (l != -1)
                inclProf += table[l];

            // Store maximum of including and excluding
            table[i] = Math.max(inclProf, table[i - 1]);
        }

        return table[n - 1];
    }

    // Driver method to test above
    public static void start(String path) throws IOException {
        FileWriter outFile = new FileWriter(path);

        System.out.println("Enter item count");
        int n = new Scanner(System.in).nextInt();

        System.out.println("Enter Starting, Ending and Profit values (for example 10,20,30) then press Enter");
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            String[] a = new Scanner(System.in).nextLine().split(",");
            jobs[i] = new Job(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]));
        }
        int answer = schedule(jobs);
        System.out.println("Optimal profit is " + answer);
        outFile.write("Optimal profit is " + answer + "\n");
    }
}