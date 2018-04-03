package interview.TicToeGame;

import java.util.Scanner;

/**
 * @author rajasan
 */
public class TicTacToe {

    // matrix 3*3

    private char[][] board;
    private char playerCharacter;

    public TicTacToe() {
        board = new char[3][3];
        playerCharacter = 'X';
        initialize();
    }

    // initialize with -

    public void initialize() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    public boolean addToken(int row, int col, char c) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == '-') {
                board[row][col] = c;
                return true;
            }
        }
        return false;
    }

    public boolean playAI() throws Exception {
        boolean isSuccess = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (addToken(i, j, 'O')) {
                    isSuccess = true;
                    break;
                }
            }
            if (isSuccess) {
                break;
            }
        }

        if (!isSuccess) {
            throw new Exception("There is no free location on the board");
        }
        return isSuccess;
    }

    public static void main(String[] args) throws Exception {
        TicTacToe game = new TicTacToe();

        //x top row mid col
        // row =0, col = 1

        boolean isSuccessful = game.addToken(0, 1, 'X');

        game.printBoard();

        for (int i = 0; i < 9; i++) {
            game.playAI();
            game.printBoard();
        }
        Scanner s = new Scanner(System.in);

//        while () {
        //
        //            String x = s.nextLine();
        //
        //            int row = Integer.parseInt(x);
        //        }
    }
}
