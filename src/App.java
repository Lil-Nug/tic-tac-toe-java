import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Board board = new Board();
        board.getBoard();

        Scanner scanner = new Scanner(System.in);

        int loop = 1;
        while (loop == 1) {
            System.out.println("Player " + board.getSign() + "'s turn");
            String tempTurn = scanner.nextLine();
            String output = board.turn(tempTurn);

            if (output.equals("")) {
                board.switchSign();

            } else {
                System.out.println(output);
                continue;
            }

            output = board.checkWin();
            if (output.equals("")) {
                continue;
            } else {
                System.out.println(output);
                loop = 0;
            }
        }

        scanner.close();
    }
}
