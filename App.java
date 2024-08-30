
import javax.swing.*;
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
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                grid[i][j] = new JTextField();
                grid[i][j].setHorizontalAlignment(JTextField.CENTER);
                sudokuPanel.add(grid[i][j]);
            }
        }

        // Add components
        frame.add(sudokuPanel, BorderLayout.CENTER);

        // Making the frame visible
        frame.setVisible(true);
    }

}
