/**
 * The game model encapsulating rules and board state.
 */
public class TTTGame {
    private final TTTBoard board = new TTTBoard();
    private char currentPlayer = 'X';
    private int moveCount = 0;

    public TTTGame() { }

    /** Resets the game state. */
    public void reset() {
        board.reset();
        currentPlayer = 'X';
        moveCount = 0;
    }

    public char getCurrentPlayer() { return currentPlayer; }

    public char getMark(int r, int c) { return board.get(r, c); }

    /**
     * Attempt to make a move at row,col for the current player.
     * Returns a MoveResult describing the outcome.
     */
    public MoveResult makeMove(int row, int col) {
        if (board.get(row, col) != ' ')
            return MoveResult.ILLEGAL;

        board.set(row, col, currentPlayer);
        moveCount++;

        // Check for win (rows, cols, diagonals)
        if (checkForWin(currentPlayer)) {
            return MoveResult.WIN;
        }

        // If board full -> tie (full-board tie)
        if (board.isFull()) {
            return MoveResult.TIE_FULL;
        }

        // Switch player and continue
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        return MoveResult.CONTINUE;
    }

    /** Basic win check (rows, columns, diagonals) */
    private boolean checkForWin(char player) {
        // rows
        for (int r = 0; r < 3; r++) {
            if (board.get(r,0) == player && board.get(r,1) == player && board.get(r,2) == player)
                return true;
        }
        // columns
        for (int c = 0; c < 3; c++) {
            if (board.get(0,c) == player && board.get(1,c) == player && board.get(2,c) == player)
                return true;
        }
        // diagonals
        if (board.get(0,0) == player && board.get(1,1) == player && board.get(2,2) == player) return true;
        if (board.get(0,2) == player && board.get(1,1) == player && board.get(2,0) == player) return true;

        return false;
    }
}
