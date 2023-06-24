
// IATRAKIS IOANNIS AM 5116
import java.util.Scanner;

class HumanPlayer {
    private String name;
    private int points;

    public HumanPlayer(String name) {
        this.name = name;
        points = 0;
    }

    public void play(Board board) {
        Scanner input = new Scanner(System.in);
        System.out.print(name + ", select two positions to open:");
        int firstPick = input.nextInt();
        int secondPick = input.nextInt();
        while (firstPick == secondPick || !board.containsCard(firstPick) || !board.containsCard(secondPick)) {
            System.out.print("Selection not valid. Try again ");
            firstPick = input.nextInt();
            secondPick = input.nextInt();
        }
        board.openPositions(firstPick, secondPick);
        if (board.getCard(firstPick) == board.getCard(secondPick)) {
            points++;
        }
    }

    public int getPoints() {
        return points;
    }

    public String toString() {
        return name + " ";
    }

    public static void main(String[] args) {
        HumanPlayer kati = new HumanPlayer("John");
        Board tester = new Board(3);
        kati.play(tester);
        kati.play(tester);
        kati.play(tester);
    }
}
