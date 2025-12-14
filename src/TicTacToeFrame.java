import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame {
    private final TTTTileButton[][] tiles = new TTTTileButton[3][3];
    private final JLabel statusLabel = new JLabel("Player X's turn", SwingConstants.CENTER);
    private final TTTController controller;

    public TicTacToeFrame() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        TTTGame model = new TTTGame();
        controller = new TTTController(model, this);

        JPanel grid = new JPanel(new GridLayout(3, 3));
        Font tileFont = new Font("MONOSPACED", Font.BOLD, 40);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                final int rr = r, cc = c;
                TTTTileButton b = new TTTTileButton(r, c);
                b.setFont(tileFont);
                b.addActionListener(e -> controller.onTileClicked(rr, cc));
                tiles[r][c] = b;
                grid.add(b);
            }
        }

        JButton quit = new JButton("Quit");
        quit.setFont(new Font("Arial", Font.BOLD, 20));
        quit.addActionListener(e -> {
            int ans = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION) System.exit(0);
        });

        add(grid, BorderLayout.CENTER);
        add(quit, BorderLayout.SOUTH);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updateTile(int row, int col, char ch) {
        tiles[row][col].setText(ch == ' ' ? "" : String.valueOf(ch));
    }

    public void resetBoard() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                tiles[r][c].setText("");
    }
}
