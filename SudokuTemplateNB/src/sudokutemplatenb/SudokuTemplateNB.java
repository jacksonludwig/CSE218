// incorrect -- download correct ver **************
// ******************************************************************88

package sudokutemplatenb;

// import javax.swing.JOptionPane;
public class SudokuTemplateNB {

    static int nCols = 9; // number of columns
    static int nRows = nCols;
    static int[][] board = new int[nRows][nCols]; // the puzzle

    public static void main(String[] args) {
        boolean success = false;
        intialize();
        outputBoard();
        success = makeNextValidMove(5, 5);

        if (success == true) {
            outputBoard();
        } else {
            System.out.print("no solution");
            outputBoard();
        }
    }

    public static boolean makeNextValidMove(int row, int col) {
        boolean atGoal = false;
        int choice = 1;
        int nChoices = 9;
        int nextMove;

        while (board[row][col] != 0) {
            if (row == 8 && col == 8) {
                return true;
            }
            if (col != 8) {
                col++;
            } else {
                col = 0;
                row++;
            }
        }

        while (atGoal == false && choice <= nChoices) {
            nextMove = chooseNextMove(choice);
            if (isValid(row, col, choice)) {
                record(row, col, choice);
                if (goalReached(row, col)) {
                    return true;
                } else {
                    if (col != 8) {
                        atGoal = makeNextValidMove(row, col+1); // check
                    } else {
                        atGoal = makeNextValidMove(row+1, 0); // check
                    }

                    if (atGoal == false)// backtrack
                    {
                        unrecord(row, col);
                    }

                }
            }
            choice++;
        }
        return atGoal;
    }// end of 

    // subprograms, problem specific
    public static int chooseNextMove(int choice) {
        return choice;
    }

    public static boolean goalReached(int row, int col) {
        if (row == 8 && col == 8) {
            return true;
        }
        return false;
    }

    public static void record(int row, int col, int choice) {
        board[row][col] = choice;
    }

    public static void unrecord(int row, int col) {
        board[row][col] = 0;
    }

    public static boolean isValid(int row, int col, int choice) { // check row
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == choice) {
                return false;
            }
        }
        for (int r = 0; r < 9; r++) {
            if (board[col][r] == choice) { // check col
                return false;
            }
        }
//        int r = (row / 3) * 3;
//        int c = (col / 3) * 3;
        for (int r = row / 3 * 3; r <= row / 3 * 3 + 2; r++) {
            for (int c = col / 3 * 3; c <= col / 3 * 3 + 2; c++) {
                if (board[r][c] == choice) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void outputBoard() {
        for (int i = 0; i < nRows; i++) {
            System.out.println();
            for (int j = 0; j < nCols; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void intialize() {
        board[0][2] = 9;
        board[0][7] = 6;
        board[1][2] = 6;
        board[1][3] = 3;
        board[1][4] = 4;
        board[1][7] = 2;
        board[1][8] = 9;
        board[2][0] = 2;
        board[2][1] = 3;
        board[2][3] = 5;
        board[2][6] = 7;
        board[3][1] = 6;
        board[3][2] = 7;
        board[4][1] = 4;
        board[4][4] = 3;
        board[4][7] = 9;
        board[5][6] = 6;
        board[5][7] = 8;
        board[6][2] = 2;
        board[6][5] = 1;
        board[6][7] = 3;
        board[6][8] = 4;
        board[7][0] = 4;
        board[7][1] = 9;
        board[7][4] = 2;

        board[7][5] = 5;
        board[7][6] = 1;
        board[8][1] = 7;
        board[8][6] = 8;
    }
}
