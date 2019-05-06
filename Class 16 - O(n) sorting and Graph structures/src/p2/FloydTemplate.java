
public class FloydTemplate {

    public static void main(String[] args) {
        int[][] adj = {
            {0, 10, 5, 4, 0},
            {10, 0, 3, 0, 1},
            {5, 3, 0, 0, 0},
            {4, 0, 0, 0, 2},
            {0, 1, 0, 2, 0}
        };

        int[][] aCopy = floyd(5, adj);
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print(aCopy[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floyd(int nVertices, int[][] adj) {
        int[][] aCopy = new int[nVertices][nVertices];

        for (int row = 0; row < nVertices; row++) {
            for (int col = 0; col < nVertices; col++) {
                if (adj[row][col] == 0) {
                    aCopy[row][col] = 99; // impossibly high number
                } else {
                    aCopy[row][col] = adj[row][col];
                }
            }
        }

        for (int b = 0; b < nVertices; b++) { // intermediate
            for (int a = 0; a < nVertices; a++) { // start
                for (int c = 0; c < nVertices; c++) { // destination
                    if (aCopy[a][c] > aCopy[a][b] + aCopy[b][c]) {
                        aCopy[a][c] = aCopy[a][b] + aCopy[b][c];
                    }
                }
            }
        }

        return aCopy;
    }

}
