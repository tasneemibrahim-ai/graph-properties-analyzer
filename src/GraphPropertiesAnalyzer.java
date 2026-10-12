import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

    class GraphPropertiesAnalyzer {

    private int[][] adjacencyMatrix;
    private int[][] incidenceMatrix;
    private int VerticesNum;

    public static void main(String[] args) {
        GraphPropertiesAnalyzer analyzer = new GraphPropertiesAnalyzer();
        analyzer.readAdjacencyMatrix("adjacency_matrix.txt");
        analyzer.readIncidenceMatrix("incidence_matrix.txt");

        System.out.println("Reflexive: " + analyzer.isReflexive());
        System.out.println("Symmetric: " + analyzer.isSymmetric());
        System.out.println("Transitive: " + analyzer.isTransitive());
        System.out.println("Acyclicity: " + analyzer.isAcyclic());
        System.out.println("Connectivity: " + analyzer.isConnected());
        System.out.println("Eulerian Path: " + analyzer.hasEulerianPath());
    }

    public void readAdjacencyMatrix(String fileName) {
        try {
            Scanner Tasneem = new Scanner(new File(fileName));
            VerticesNum= Tasneem.nextInt();
            adjacencyMatrix = new int[VerticesNum][VerticesNum];

            for (int i = 0; i < VerticesNum; i++) {
                for (int j = 0; j < VerticesNum; j++) {
                    adjacencyMatrix[i][j] = Tasneem.nextInt();
                }
            }

            Tasneem.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readIncidenceMatrix(String fileName) {
        try {
            Scanner Tasneem = new Scanner(new File(fileName));
            VerticesNum = Tasneem.nextInt();
            int numEdges = Tasneem.nextInt();
            incidenceMatrix = new int[VerticesNum][numEdges];

            for (int i = 0; i < VerticesNum; i++) {
                for (int j = 0; j < numEdges; j++) {
                    incidenceMatrix[i][j] = Tasneem.nextInt();
                }
            }

            Tasneem.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isReflexive() {
        for (int i = 0; i < VerticesNum; i++) {
            if (adjacencyMatrix[i][i] == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetric() {
        for (int i = 0; i < VerticesNum; i++) {
            for (int j = i + 1; j < VerticesNum; j++) {
                if (adjacencyMatrix[i][j] != adjacencyMatrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isTransitive() {
        int[][] result = matrixMultiply(adjacencyMatrix, adjacencyMatrix);
        for (int i = 0; i < VerticesNum; i++) {
            for (int j = 0; j < VerticesNum; j++) {
                if (adjacencyMatrix[i][j] != 0 && result[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] matrixMultiply(int[][] matrix1, int[][] matrix2) {
        int[][] MultiplicationResult = new int[VerticesNum][VerticesNum];
        for (int i = 0; i < VerticesNum; i++) {
            for (int j = 0; j < VerticesNum; j++) {
                for (int k = 0; k < VerticesNum; k++) {
                    MultiplicationResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return MultiplicationResult;
    }

    public boolean isAcyclic() {
        boolean[] visited = new boolean[VerticesNum];
        boolean[] recursionStack = new boolean[VerticesNum];

        for (int i = 0; i < VerticesNum; i++) {
            if (isCyclicUtil(i, visited, recursionStack)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCyclicUtil(int vertex, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[vertex]) {
            return true;
        }

        if (visited[vertex]) {
            return false;
        }

        visited[vertex] = true;
        recursionStack[vertex] = true;

        for (int i = 0; i < VerticesNum; i++) {
            if (adjacencyMatrix[vertex][i] != 0 && isCyclicUtil(i, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[vertex] = false;

        return false;
    }

    public boolean isConnected() {
        boolean[] visited = new boolean[VerticesNum];
        dfs(0, visited);

        for (int i = 0; i < VerticesNum; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int i = 0; i < VerticesNum; i++) {
            if (adjacencyMatrix[vertex][i] != 0 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    public boolean hasEulerianPath() {
        int CountoddDegree = 0;

        for (int i = 0; i < VerticesNum; i++) {
            int degree = 0;
            for (int j = 0; j < VerticesNum; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    degree++;
                }
            }
            if (degree % 2 != 0) {
                CountoddDegree++;
            }
        }

        return CountoddDegree == 0 || CountoddDegree == 2;
    }
}