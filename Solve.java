public class Solve {

    private static final int SIZE = 9;

    // Backtracking algorithm to solve the Sudoku puzzle
    public boolean solve(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) { // Find an empty cell
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursively try to solve the rest of the board
                            if (solve(board)) {
                                return true;
                            }

                            // If the number doesn't lead to a solution, backtrack
                            board[row][col] = 0;
                        }
                    }
                    return false; // No valid number found, backtrack
                }
            }
        }
        return true; // Solved
    }

    // Helper method to check if placing a number is valid
    private boolean isValid(int[][] board, int row, int col, int num) {
        // Check if num is not already present in the row, column, or 3x3 subgrid
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num ||
                board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}

