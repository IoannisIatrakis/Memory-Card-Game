
// IATRAKIS IOANNIS AM 5116
import java.util.Random;
import java.util.*;

class Board {
    private int[] board;
    private ArrayList<Integer> positions;
    private ArrayList<Integer> notAvailablePosition;
    private HashMap<Integer, String> Stars;
    private int size;
    private Random randomGenerator = new Random();
    private int randomPosition;

    public Board(int pairs) {
        this.size = 2 * pairs;
        board = new int[size];
        positions = new ArrayList<Integer>();
        notAvailablePosition = new ArrayList<Integer>();
        Stars = new HashMap<Integer, String>();
        for (int i = 0; i < size; i++) {
            positions.add(i);
        }
        for (int i = 0; i < pairs; i++) {
            notAvailablePosition.add(i);
        }
        for (int j = 0; j < size; j++) {
            Stars.put(j, "*");

        }

        for (int i = 0; i < pairs; i++) {

            board[i] = i;
            board[size - i - 1] = i;
        }

        for (int i = 0; i < board.length; i++) {
            randomPosition = randomGenerator.nextInt(board.length);
            int help = board[i];
            board[i] = board[randomPosition];
            board[randomPosition] = help;

        }
    }

    public void print() {
        for (int elem : positions) {
            System.out.print(elem + "   ");
        }
        System.out.println();
        for (int i = 0; i < positions.size(); i++) {
            System.out.print("----");
        }
        System.out.println();

        for (int elem : Stars.keySet()) {
            System.out.print(Stars.get(elem) + "   ");
        }
        System.out.print("\r");
    }

    public void flash(int position1, int position2) {
        print();
        for (int i = 0; i < positions.size(); i++) {
            if (position1 == i) {
                System.out.print(board[position1] + "  ");
            } else if (position2 == i) {
                System.out.print(board[position2] + "   ");
            } else {
                System.out.print(Stars.get(i) + "   ");
            }
        }
        delay(10);
        System.out.print("\r");
        for (int elem : Stars.keySet()) {
            System.out.print(Stars.get(elem) + "   ");
        }
        System.out.println();
        System.out.println();
    }

    private void delay(int sec) {
        try {
            Thread.currentThread().sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean openPositions(int position1, int position2) {
        if (board[position1] == board[position2]) {
            Stars.put(position1, " ");
            Stars.put(position2, " ");
            System.out.println("Found pair: " + board[position1] + " " + board[position2]);
            print();
            System.out.println();
            return true;
        }
        flash(position1, position2);
        return false;
    }

    public int getRandomPosition() {
        randomPosition = randomGenerator.nextInt(size);

        while (Stars.get(randomPosition).equals(" ")) {
            randomPosition = randomGenerator.nextInt(size);
        }
        return randomPosition;
    }

    public int getRandomPosition(int position) {
        int randomPosition1 = randomGenerator.nextInt(size);
        while (position == randomPosition1 || !Stars.get(randomPosition1).equals("*")) {
            randomPosition1 = randomGenerator.nextInt(size);
        }
        return randomPosition1;
    }

    public boolean containsCard(int position) {
        if (Stars.get(position).equals("*")) {
            return true;
        }
        return false;
    }

    public int getCard(int position) {
        return board[position];
    }

    public boolean allPairsFound() {
        return !Stars.containsValue("*");
    }

    private int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Board test = new Board(3);
        test.print();
        System.out.println();
        for (int i = 0; i < test.getSize(); i++) {
            System.out.println("Position " + i + " has " + test.getCard(i));
        }
        int random1 = test.getRandomPosition();
        int random2 = test.getRandomPosition(random1);
        test.flash(random1, random2);
        while (test.getCard(random1) != test.getCard(random2)) {
            random1 = test.getRandomPosition();
            random2 = test.getRandomPosition(random1);
        }
        test.openPositions(random1, random2);
        System.out.println("containsCard: " + test.containsCard(random1));

        while (test.getCard(random1) == test.getCard(random2)) {
            random1 = test.getRandomPosition();
            random2 = test.getRandomPosition(random1);
        }
        test.openPositions(random1, random2);
        System.out.println("containsCard: " + test.containsCard(random1));
        random1 = test.getRandomPosition();
        random2 = test.getRandomPosition(random1);
        test.openPositions(random1, random2);

        random1 = test.getRandomPosition();
        random2 = test.getRandomPosition(random1);
        test.openPositions(random1, random2);
        System.out.println("allPairsFound: " + test.allPairsFound());
    }
}
