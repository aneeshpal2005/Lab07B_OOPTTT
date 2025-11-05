import javax.swing.JOptionPane;

/**
 * Controller coordinates between view (frame) and model (game).
 */
public class TTTController {
    private final TTTGame game;
    private final TicTacToeFrame view;

    public TTTController(TTTGame game, TicTacToeFrame view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Called by view when user clicks a tile.
     */
    public void onTileClicked(int row, int col) {
        MoveResult result = game.makeMove(row, col);
        switch (result) {
            case ILLEGAL:
                JOptionPane.showMessageDialog(view, "Illegal move! That square is already taken.");
                break;
            case CONTINUE:
                view.updateTile(row, col, game.getMark(row, col));
                view.updateStatus("Player " + game.getCurrentPlayer() + "'s turn");
                break;
            case WIN:
                view.updateTile(row, col, game.getMark(row, col));
                JOptionPane.showMessageDialog(view, "Player " + game.getMark(row, col) + " wins!");
                askReplayOrQuit();
                break;
            case TIE_FULL:
                view.updateTile(row, col, game.getMark(row, col));
                JOptionPane.showMessageDialog(view, "It's a tie!");
                askReplayOrQuit();
                break;
        }
    }

    private void askReplayOrQuit() {
        int choice = JOptionPane.showConfirmDialog(view, "Do you want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            game.reset();
            view.resetBoard();
            view.updateStatus("Player X's turn");
        } else {
            System.exit(0);
        }
    }
}
