# 🔗 Graph Properties Analyzer

> A Java program that reads graph representations from matrix files and determines key mathematical properties using discrete mathematics algorithms.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Algorithms Used](#algorithms-used)
- [Project Structure](#project-structure)
- [Input File Format](#input-file-format)
- [Getting Started](#getting-started)
- [Example Output](#example-output)
- [Limitations](#limitations)
- [Future Improvements](#future-improvements)

---

## 📌 Overview

The **Graph Properties Analyzer** is an academic Java project built as part of a Discrete Mathematics course. It reads an **adjacency matrix** and an **incidence matrix** from plain text files and programmatically determines whether the graph satisfies a set of fundamental graph-theoretic properties.

This project bridges the gap between abstract mathematical graph theory and practical software implementation, demonstrating how matrix-based representations and traversal algorithms can be used to classify graphs.

---

## ✨ Features

The analyzer checks for the following properties:

| Property | Description | Matrix Used |
|---|---|---|
| **Reflexive** | Every vertex has a self-loop (`A[i][i] = 1` for all `i`) | Adjacency |
| **Symmetric** | All edges are bidirectional (`A[i][j] == A[j][i]`) | Adjacency |
| **Transitive** | A path of length 2 implies a direct edge (via matrix multiplication A²) | Adjacency |
| **Acyclic** | The graph contains no cycles (via DFS with recursion stack) | Adjacency |
| **Connected** | Every vertex is reachable from any other vertex (via DFS) | Adjacency |
| **Eulerian Path** | A path traversing every edge exactly once exists (degree condition check) | Adjacency |

---

## ⚙️ Algorithms Used

- **Matrix Multiplication (A²):** Used to check transitivity — if there's a path of length 2 from vertex `i` to `j`, a direct edge must also exist.
- **Depth-First Search (DFS) + Recursion Stack:** Used to detect cycles. A cycle is found if a vertex is revisited while still on the current recursion path.
- **DFS for Connectivity:** A single DFS traversal from vertex 0 is used; if all vertices are visited, the graph is connected.
- **Degree Parity Check (Eulerian Path):** An Eulerian path exists if the graph has exactly 0 or 2 vertices with an odd degree.

---

## 📁 Project Structure

```text
graph-properties-analyzer/
├── docs/                               # Academic documents
│   ├── Project_Main_Description.pdf
│   ├── Project_Requirements.pdf
│   ├── Bonus_Project_Requirements.pdf
│   └── Bonus_Project_Requirements.docx
├── src/                                # Source code and input data
│   ├── GraphPropertiesAnalyzer.java    # Main program
│   ├── adjacency_matrix.txt            # Sample adjacency matrix input
│   └── incidence_matrix.txt            # Sample incidence matrix input
├── .gitignore
└── README.md
```

---

## 📄 Input File Format

### `adjacency_matrix.txt`
- **Line 1:** A single integer `n` — the number of vertices.
- **Lines 2 to n+1:** An `n × n` matrix of `0`s and `1`s (space-separated), where `A[i][j] = 1` means there is a directed edge from vertex `i` to vertex `j`.

**Example (4 vertices):**
```
4
0 1 1 0
1 0 0 1
1 0 0 1
0 1 1 0
```

---

### `incidence_matrix.txt`
- **Line 1:** Two integers — `n` (vertices) and `m` (edges).
- **Lines 2 to n+1:** An `n × m` matrix where:
  - `1` = edge leaves this vertex
  - `-1` = edge enters this vertex
  - `0` = edge is not incident to this vertex

**Example (4 vertices, 5 edges):**
```
4 5
 1  0  0  1  0
-1  1  0  0  1
 0 -1  1 -1  0
 0  0 -1  0 -1
```

---

## 🚀 Getting Started

### Prerequisites
- **Java Development Kit (JDK) 8 or higher**
- Verify your installation:
  ```bash
  java -version
  ```

### Steps

**1. Clone the repository:**
```bash
git clone https://github.com/<your-username>/graph-properties-analyzer.git
cd graph-properties-analyzer/src
```

**2. Compile the source file:**
```bash
javac GraphPropertiesAnalyzer.java
```

**3. Run the program:**
```bash
java GraphPropertiesAnalyzer
```

> **Important:** The program reads `adjacency_matrix.txt` and `incidence_matrix.txt` from the **current working directory**. Make sure to run the command from inside the `src/` folder, or update the file paths in the source code.

---

## 🖥️ Example Output

Using the provided sample input files, the program produces:

```
Reflexive: false
Symmetric: true
Transitive: false
Acyclicity: false
Connectivity: true
Eulerian Path: true
```

---

## ⚠️ Limitations

- Assumes the input files are correctly formatted (no validation or error messages for malformed input).
- Uses fixed-size integer arrays — not optimized for very large or sparse graphs.
- The incidence matrix is read but currently not used in the property checks (adjacency matrix drives all analysis).
- Does not support weighted graphs or multigraphs.

---

## 🔭 Future Improvements

- [ ] Add robust input validation with clear error messages.
- [ ] Support dynamically generated or randomly created graphs.
- [ ] Use the incidence matrix directly in the analysis (e.g., for Eulerian path via edge traversal).
- [ ] Add support for weighted graphs and multigraphs.
- [ ] Implement a simple CLI or GUI for interactive input.
- [ ] Add unit tests for each property checker.

---

## 🛠️ Technologies

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

---

## 📚 Concepts Covered

`Graph Theory` · `Discrete Mathematics` · `Adjacency Matrix` · `Incidence Matrix` · `DFS` · `Matrix Multiplication` · `Eulerian Path` · `Cycle Detection`

---

## Author

Tasneem Ibrahim
