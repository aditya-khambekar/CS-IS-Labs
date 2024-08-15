package Crossword;

public class Crossword {

    /**
     * Each element is a Square object with a color (black or white) and a
     * number. puzzle[r][c] represents the square in row r, column c. There is
     * at least one row in the puzzle.
     */
    private Square[][] puzzle;

    /**
     * Constructs a crossword puzzle grid Precondition: There is at least one
     * row in blackSquares Postcondition: The crossword puzzle grid has the same
     * dimensions as blackSquares. The Square object at row r, column c in the
     * crossword puzzle grid is black if and only if blackSquares[r][c] is true.
     * The squares in the puzzle are labeled according to the crossword labeling
     * rule.
     *
     * @param blackSquares
     */
    public Crossword( boolean[][] blackSquares ) {
        puzzle = new Square[blackSquares.length][blackSquares[0].length];
        int maxLabel = 0;
        for(int r = 0; r<blackSquares.length; r++){
            for(int c = 0; c<blackSquares[r].length; c++){
                int curLabel = 0;
                if(toBeLabeled(r, c, blackSquares)){
                    curLabel = ++maxLabel;
                }
                puzzle[r][c] = new Square(blackSquares[r][c], curLabel);
            }
        }
    }

    /**
     * Returns true if the square at row r, column c should be labeled with a
     * positive number; false otherwise. The square at row r, column c is black
     * if and only if blackSquares[r][c] is true. Precondition: r and c are
     * valid indexes in blackSquares.
     *
     * @param r
     * @param c
     * @param blackSquares
     * @return
     */
    private boolean toBeLabeled( int r, int c, boolean[][] blackSquares ) {
       Boolean up = r==0||blackSquares[r-1][c];
       Boolean left = c==0||blackSquares[r][c-1];

       return !blackSquares[r][c]&&(up||left);
    }

    // There may be instance variables, constructors, and
    // methods that are not shown.
}

