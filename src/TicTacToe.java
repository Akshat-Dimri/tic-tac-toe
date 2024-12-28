public class TicTacToe {
    private char[] board;
    private boolean gameOver;

    public TicTacToe() {
        board = new char[9];
        reset();
    }

    public void reset() {
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
        gameOver = false;
    }

    public char getCell(int index) {
        return board[index];
    }

    public void setCell(int index, char value) {
        board[index] = value;
    }

    public boolean checkWin() {
        // Check rows, columns, and diagonals
        return (checkLine(0, 1, 2) || checkLine(3, 4, 5) || checkLine(6, 7, 8) ||
                checkLine(0, 3, 6) || checkLine(1, 4, 7) || checkLine(2, 5, 8) ||
                checkLine(0, 4, 8) || checkLine(2, 4, 6));
    }

    private boolean checkLine(int a, int b, int c) {
        return board[a] == board[b] && board[b] == board[c] && board[a] != ' ';
    }

    public boolean isGameOver() {
        return gameOver || isBoardFull();
    }

    private boolean isBoardFull() {
        for (char c : board) {
            if (c == ' ') return false;
        }
        return true;
    }
}
