import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The GUI. Builds an 800x800 window and displays the board.
 * The GUI forwards clicks to the controller (no game logic here).
 */
public class TicTacToeFrame extends JFrame {
    private final TTTTileButton[][] tiles = new TTTTileButton[3][3];
    private final JLabel statusLabel = new JLabel("Player X's turn", SwingConstants.CENTER);
    private final TTTController controller;

    public TicTacToeFrame() {
        super("Tic Tac Toe GUI - Engineered");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Model + controller
        TTTGame model = new TTTGame();
        controller = new TTTController(model, this);

        // Top status
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(statusLabel, BorderLayout.NORTH);

        // Grid
        JPanel grid = new JPanel(new GridLayout(3, 3));
        Font tileFont = new Font("Arial", Font.BOLD, 100);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                final int rr = r, cc = c;
                TTTTileButton b = new TTTTileButton(r, c);
                b.setFont(tileFont);
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // only forward coordinates - no logic here
                        controller.onTileClicked(rr, cc);
                    }
                });
                tiles[r][c] = b;
                grid.add(b);
            }
        }

        // Quit button
        JButton quit = new JButton("Quit");
        quit.setFont(new Font("Arial", Font.BOLD, 24));
        quit.addActionListener(e -> {
            int ans = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION) System.exit(0);
        });

        add(grid, BorderLayout.CENTER);
        add(quit, BorderLayout.SOUTH);

        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /** Called by controller to update a tile visually. */
    public void updateTile(int row, int col, char ch) {
        tiles[row][col].setText(ch == ' ' ? "" : String.valueOf(ch));
    }

    /** Reset UI board for a new game. */
    public void resetBoard() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                tiles[r][c].setText("");
    }

    /** Update the top status label text. */
    public void updateStatus(String text) {
        statusLabel.setText(text);
    }
}
