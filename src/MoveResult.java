
public enum MoveResult {
    ILLEGAL,    // attempted move on occupied square
    CONTINUE,   // move accepted, game continues
    WIN,        // move produced a win for current player
    TIE_FULL    // full-board tie (all cells full, no winner)
}
