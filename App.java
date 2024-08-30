
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

        frame.setVisible(true);
    }
}
