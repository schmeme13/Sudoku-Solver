
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class App {
    
    private static final int SIZE = 9;
    private static JTextField[][] grid = new JTextField[SIZE][SIZE];

    public App() {
        // Creating the main window
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Creating the sudoku grid
        JPanel sudokuPanel = new JPanel();
        sudokuPanel.setLayout(new GridLayout(SIZE, SIZE));

        // Add text fields to the grid
        for (int row = 0; row < SIZE; row++) {
    for (int col = 0; col < SIZE; col++) {
        grid[row][col] = new JTextField();
        grid[row][col].setHorizontalAlignment(JTextField.CENTER);
        grid[row][col].setFont(new Font("Arial", Font.BOLD, 20)); // Set a larger font

        // Add borders to highlight the 3x3 subgrids
        Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
        grid[row][col].setBorder(blackline);

        // Highlight the borders of the 3x3 grids with thicker lines
        if (row % 3 == 0 && col % 3 == 0) {
            grid[row][col].setBorder(BorderFactory.createMatteBorder(3, 3, 1, 1, Color.BLACK));
        } else if (row % 3 == 0) {
            grid[row][col].setBorder(BorderFactory.createMatteBorder(3, 1, 1, 1, Color.BLACK));
        } else if (col % 3 == 0) {
            grid[row][col].setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, Color.BLACK));
        } else {
            grid[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        }

        // Add some padding
        grid[row][col].setMargin(new Insets(5, 5, 5, 5));
        sudokuPanel.add(grid[row][col]);
    }
}

        // Add button to call solveSudoku
        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(e -> solveSudoku());

        // Add components
        frame.add(sudokuPanel, BorderLayout.CENTER);
        frame.add(solveButton, BorderLayout.SOUTH);

        // Making the frame visible
        frame.setVisible(true);
    }

    //Method to call upon the class with the backtracking algorithm
    private void solveSudoku() {
        int[][] board = new int[SIZE][SIZE];

        // Populate the board array with the data from the JTextField grid
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                String text = grid[row][col].getText();
                if (text.isEmpty()) {
                    board[row][col] = 0; // Empty cells are treated as 0
                } else {
                    board[row][col] = Integer.parseInt(text);
                }
            }
        }

        // Create an instance of the Solve class and pass the board to it
        Solve solver = new Solve();
        if (solver.solve(board)) {
            // If solved, update the grid with the solution
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    grid[row][col].setText(String.valueOf(board[row][col]));
                }
            }
        } else {
            // Display an error message if no solution exists
            JOptionPane.showMessageDialog(null, "No solution exists!");
        }
    }

}
