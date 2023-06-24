
// IATRAKIS IOANNIS AM 5116
import java.util.Scanner;

class MemoryGame {
    public static void main(String[] args) {
        int corverter = Integer.parseInt(args[0]);
        Board board = new Board(corverter);
        Scanner input = new Scanner(System.in);
        System.out.print("Press 1 for Player-Player or Press 2 for Player-PC: ");
        int game = input.nextInt();
        while (game != 1 && game != 2) {
            System.out.print("Press 1 for Player-Player or Press 2 for Player-PC: ");
            game = input.nextInt();
        }
        if (game == 1) {
            HumanPlayer player1 = new HumanPlayer("John");
            HumanPlayer player2 = new HumanPlayer("George");
            while (!board.allPairsFound()) {
                player1.play(board);
                if (!board.allPairsFound()) {
                    player2.play(board);
                }
                System.out.println(player1.toString() + "\'s Points : " + player1.getPoints());
                System.out.println(player2.toString() + "\'s Points : " + player2.getPoints());
            }
            if (player1.getPoints() > player2.getPoints()) {
                System.out.println(player1.toString() + "WINNER");
            } else if (player2.getPoints() > player1.getPoints()) {
                System.out.println(player2.toString() + "WINNER");
            } else {
                System.out.println("DRAW");
            }

        } else {
            HumanPlayer player1 = new HumanPlayer("John");
            ComputerPlayer PC = new ComputerPlayer("HAL", corverter);
            while (!board.allPairsFound()) {
                player1.play(board);
                if (!board.allPairsFound()) {
                    PC.play(board);
                }
                System.out.println(player1.toString() + "\'s Points : " + player1.getPoints());
                System.out.println(PC.toString() + "\'s Points : " + PC.getPoints());
            }
            if (player1.getPoints() > PC.getPoints()) {
                System.out.println(player1.toString() + "WINNER");
            } else if (PC.getPoints() > player1.getPoints()) {
                System.out.println(PC.toString() + "WINNER");
            } else {
                System.out.println("DRAW");
            }
        }
    }
}
