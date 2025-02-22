# 🏆 Algorithm Implementations in Java

This project contains implementations of various **fundamental algorithms** in Java, including **graph traversal, sorting, optimization, and scheduling algorithms**. The program allows users to **select an algorithm** and execute it dynamically.

## 📌 Features

- **Graph Algorithms**: BFS, Kruskal’s MST
- **Sorting Algorithms**: Quick Sort
- **Optimization Problems**: Stable Matching, Weighted Interval Scheduling
- **Greedy Algorithms**: Cashier’s Algorithm for minimum denominations

## 📂 Project Structure

    AlgorithmProject/
    ├── src/
    │   ├── Main.java                        # Entry point for selecting and running algorithms
    │   ├── Algorithms/
    │   │   ├── BFS.java                     # Breadth-First Search (Graph Traversal)
    │   │   ├── Cashier.java                 # Greedy Algorithm for Minimum Denominations
    │   │   ├── Kruskal.java                 # Kruskal’s Algorithm for Minimum Spanning Tree
    │   │   ├── QuickSort.java               # Quick Sort Algorithm
    │   │   ├── StableMatching.java          # Stable Matching Algorithm (Gale-Shapley)
    │   │   ├── WeightedIntervalScheduling.java # Dynamic Programming: Weighted Interval Scheduling
    ├── AlgorithmProject.iml                 # IntelliJ IDEA project file
    ├── README.md                            # Project Documentation

## 🚀 Installation & Usage

1. **Clone the Repository**

    ```bash
    git clone https://github.com/YOUR_GITHUB/AlgorithmProject.git
    cd AlgorithmProject
    ```

2. **Compile the Java Files**

    ```bash
    javac src/Main.java src/Algorithms/*.java
    ```

3. **Run the Program**

    ```bash
    java -cp src Main
    ```

    The program will prompt you to:
    - Select an algorithm to run.
    - Provide input values.
    - View the computed result.

## 📜 Algorithms Included

### 🔹 **Graph Algorithms**
- **BFS (Breadth-First Search)** (`Algorithms/BFS.java`)
  - Explores all vertices of a graph using a queue.
  - **Input:** Number of vertices, edges, and starting node.
  - **Output:** Prints BFS traversal order.

- **Kruskal’s Algorithm (Minimum Spanning Tree)** (`Algorithms/Kruskal.java`)
  - Finds the MST of a connected, weighted graph.
  - **Input:** Number of vertices, edges, and edge weights.
  - **Output:** Displays MST edges and total cost.

### 🔹 **Sorting**
- **QuickSort Algorithm** (`Algorithms/QuickSort.java`)
  - Efficient in-place sorting algorithm using partitioning.
  - **Input:** Array of numbers.
  - **Output:** Sorted array.

### 🔹 **Optimization & Matching**
- **Stable Matching (Gale-Shapley)** (`Algorithms/StableMatching.java`)
  - Solves the stable marriage problem.
  - **Input:** Preference tables for men and women.
  - **Output:** Matching pairs.

- **Weighted Interval Scheduling** (`Algorithms/WeightedIntervalScheduling.java`)
  - Dynamic programming approach to maximize job profit.
  - **Input:** Job start/end times with profits.
  - **Output:** Maximum achievable profit.

### 🔹 **Greedy Algorithm**
- **Cashier’s Algorithm** (`Algorithms/Cashier.java`)
  - Determines the minimum number of coins required for change.
  - **Input:** Denominations and total value.
  - **Output:** Coins used.

## ✨ Technologies Used

- **Java**
- **Data Structures** (Linked Lists, HashMaps, Priority Queues)
- **Graph Algorithms** (BFS, Kruskal)
- **Sorting** (QuickSort)
- **Greedy Algorithms**
- **Dynamic Programming**

## 🔧 Requirements

- Java 8 or later

## 🔹 Sample Execution


```plaintext
    Select Your Algorithm:
    1. Stable Matching
    2. BFS
    3. Cashier
    4. Kruskal
    5. Quick Sort
    6. Weighted Interval Scheduling
    7. Exit
```

For example, if you select BFS, the program will prompt:

```plaintext
    Enter vertex count and starting vertex:
    5 0
    Enter Edge Count:
    4
    Enter Edges: [Starting Node, Ending Node]
    0,1
    0,2
    1,3
    2,4
```

 BFS Expected Output:
```plaintext
     Following is Breadth First Traversal (starting from vertex 0):
     0 1 2 3 4
```
