
// IATRAKIS IOANNIS AM 5116
import java.util.*;

class ComputerPlayer {
    private String name;
    private int[] pcMemory;
    private HashMap<Integer, Integer> pcMemory1;
    private int points;

    public ComputerPlayer(String name, int pair) {
        this.name = name;
        pcMemory = new int[pair];
        for (int i = 0; i < pair; i++) {
            pcMemory[i] = -1;
        }
        pcMemory1 = new HashMap<Integer, Integer>();
        for (int j = 0; j < pair; j++) {
            pcMemory1.put(j, -1);
        }
        points = 0;
    }

    public void play(Board board) {
        int position1 = board.getRandomPosition();
        int position2;

        if (pcMemory[board.getCard(position1)] != -1 && pcMemory[board.getCard(position1)] != position1) {
            position2 = pcMemory1.get(board.getCard(position1));
        } else {
            position2 = board.getRandomPosition(position1);
        }
        System.out.println(name + " selected positions : " + position1 + " " + position2);
        board.openPositions(position1, position2);

        if (board.getCard(position1) == board.getCard(position2)) {
            points++;

        } else {
            pcMemory[board.getCard(position1)] = position1;
            pcMemory[board.getCard(position2)] = position2;

            pcMemory1.put(board.getCard(position1), position1);
            pcMemory1.put(board.getCard(position2), position2);
        }
    }

    public int getPoints() {
        return points;
    }

    public String toString() {
        return name + " ";
    }

    public static void main(String[] args) {
        ComputerPlayer player = new ComputerPlayer("john", 3);
        Board board = new Board(3);
        player.play(board);
        player.play(board);
        player.play(board);
    }
}
