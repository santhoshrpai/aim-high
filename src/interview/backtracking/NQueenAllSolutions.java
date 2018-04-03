package interview.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rajasan
 */
public class NQueenAllSolutions {

    class Position {

        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<List<String>> solveNQueens(int n) {

        if (n <= 0) {
            return new ArrayList<>();
        }

        List<List<String>> distinct = new ArrayList<>();
        List<Position> pos = new ArrayList<>(n);
        int row = 0;

        solveNQueensHelper(n, row, pos, distinct);

        return distinct;
    }

    public boolean solveNQueensHelper(int n, int row, List<Position> pos, List<List<String>> distinct) {
        if (row == n) {
            distinct.add(convertPosToList(pos, n));
            return true;
        }

        for (int col = 0; col < n; col++) {
            boolean isSafe = true;

            for (int q = 0; q < row; q++) {
                if (pos.get(q).row == row || pos.get(q).col == col || pos.get(q).row + pos.get(q).col == row + col
                        || pos.get(q).row - pos.get(q).col == row - col) {
                    isSafe = false;
                    break;
                }
            }

            if (isSafe) {
                pos.add(new Position(row, col));
                solveNQueensHelper(n, row + 1, pos, distinct);
                pos.remove(row);
            }
        }
        return false;
    }

    public List<String> convertPosToList(List<Position> pos, int n) {
        List<String> sol = new ArrayList<>();
        for (Position p : pos) {
            StringBuffer s = new StringBuffer(n);
            s.append(appendNDots(p.col - 1));
            s.append("Q");
            s.append(appendNDots(n - p.col - 2));
            sol.add(s.toString());
        }
        return sol;
    }

    public String appendNDots(int count) {
        int n = count;
        StringBuffer s = new StringBuffer();
        while (n >= 0) {
            s.append(".");
            n--;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        NQueenAllSolutions nQueenProblem = new NQueenAllSolutions();
        List<List<String>> sols = nQueenProblem.solveNQueens(4);

        for (List<String> each : sols) {
            for (String s : each) {
                System.out.println(s);
            }
            System.out.println("========");
        }
    }
}
