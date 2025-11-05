import java.util.ArrayList;
import java.util.List;

/**
 * Board model holding 3x3 cells.
 * Cells contain 'X', 'O', or ' '.
 */
public class TTTBoard {
    private final char[][] cells = new char[3][3];

    public TTTBoard() { reset(); }

    public char get(int r, int c) {
        return cells[r][c];
    }

    public void set(int r, int c, char ch) {
        cells[r][c] = ch;
    }

    public void reset() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                cells[r][c] = ' ';
    }

    public boolean isFull() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (cells[r][c] == ' ')
                    return false;
        return true;
    }

    /** Return list of empty cell coords as int[2] pairs. */
    public List<int[]> emptyCells() {
        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (cells[r][c] == ' ')
                    list.add(new int[]{r, c});
        return list;
    }
}
