package interview.backtracking;

/**
 * @author rajasan
 */
public class NQueenProblem {

    class Position {

        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Position[] solveNQueens(int n) {

        if (n == 0) {
            return new Position[0];
        }

        Position[] pos = new Position[n];

        if (solveNQueensHelper(n, 0, pos)) {
            return pos;
        } else {
            return new Position[0];
        }
    }

    public boolean solveNQueensHelper(int n, int row, Position[] pos) {

        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            boolean foundSafe = true;

            for (int queen = 0; queen < row; queen++) {
                if (pos[queen] != null && (pos[queen].col == col || pos[queen].row == row
                        || pos[queen].row - pos[queen].col == row - col
                        || pos[queen].row + pos[queen].col == row + col)) {
                    foundSafe = false;
                    break;
                }
            }

            if (foundSafe) {
                pos[row] = new Position(row, col);
                if (solveNQueensHelper(n, row + 1, pos)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        NQueenProblem nQueenProblem = new NQueenProblem();
        Position[] pos = nQueenProblem.solveNQueens(4);

        for (Position p : pos) {
            System.out.println(p.row + "::" + p.col);
        }
    }

}
