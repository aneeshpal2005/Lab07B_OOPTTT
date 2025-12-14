import javax.swing.JOptionPane;

public class TTTController {
    private final TTTGame game;
    private final TicTacToeFrame view;

    public TTTController(TTTGame game, TicTacToeFrame view) {
        this.game = game;
        this.view = view;
    }

    public void onTileClicked(int row, int col) {
        MoveResult result = game.makeMove(row, col);
        switch (result) {
            case ILLEGAL:
                JOptionPane.showMessageDialog(view, "Illegal move. Choose another square.");
                break;
            case CONTINUE:
                view.updateTile(row, col, game.getMark(row, col));
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
        } else {
            System.exit(0);
        }
    }
}
