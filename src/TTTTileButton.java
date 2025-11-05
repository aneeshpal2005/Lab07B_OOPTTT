import javax.swing.JButton;

/**
 * A tile button for the Tic Tac Toe board.
 * This is the subclassed tile used in the GUI (Ass 01 style).
 */
public class TTTTileButton extends JButton {
    private final int row;
    private final int col;

    /**
     * Constructs a tile with its board coordinates.
     *
     * @param row row index (0..2)
     * @param col column index (0..2)
     */
    public TTTTileButton(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }

    public int getCol() { return col; }
}
