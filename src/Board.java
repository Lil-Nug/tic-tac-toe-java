import java.util.HashMap;

public class Board {
    private int sign = 1;
    private int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    private int moveCounter = 0;

    public void getBoard() {
        HashMap<Integer, String> signMap = new HashMap<Integer, String>();
        signMap.put(0, "0");
        signMap.put(1, "X");
        signMap.put(2, "O");
        for (int[] line : board) {
            for (int cell : line) {
                System.out.print(signMap.get(cell) + "  ");
            }
            System.out.println();
        }
    }

    public void switchSign() {
        if (this.sign == 1) {
            this.sign = 2;
        } else {
            this.sign = 1;
        }
    }

    public int getSign() {
        return this.sign;
    }

    public String turn(String location) {
        char locationArray[] = location.toCharArray();
        if ((locationArray.length != 2) || (locationArray[0] < 'a') || (locationArray[0] > 'c')
                || (locationArray[1] < '1') || (locationArray[1] > '3')) {
            this.getBoard();
            return "Invalid move";

        }

        int col = (int) locationArray[0] - 97;
        int row = Integer.parseInt(String.valueOf(locationArray[1])) - 1;
        if (this.board[row][col] == 0) {
            this.board[row][col] = this.sign;
            this.getBoard();
            moveCounter++;
            return "";
        } else {
            this.getBoard();
            return "Invalid move";
        }

    }

    public String checkWin() {
        for (int i = 0; i < 3; i++) {
            if (this.board[i][0] == this.board[i][1] && this.board[i][1] == this.board[i][2] && this.board[i][0] != 0) {
                return "Player " + this.board[i][0] + " wins";
            }
            if (this.board[0][i] == this.board[1][i] && this.board[1][i] == this.board[2][i] && this.board[0][i] != 0) {
                return "Player " + this.board[0][i] + " wins";
            }
        }
        if (this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2] && this.board[0][0] != 0) {
            return "Player " + this.board[0][0] + " wins";
        }
        if (this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0] && this.board[0][2] != 0) {
            return "Player " + this.board[0][2] + " wins";
        }

        if (moveCounter == 9) {
            return "Draw";
        }
        return "";
    }

}
