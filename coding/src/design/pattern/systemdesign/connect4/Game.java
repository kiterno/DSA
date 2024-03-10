package design.pattern.systemdesign.connect4;

import design.pattern.systemdesign.connect4.model.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {
    static Deque<Player> deque;
    static Board board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        initializeGame(sc);

        System.out.println(startGame(sc));

    }

    private static String startGame(Scanner sc) {

        while (true) {
            displayBoard();
            if (board.isBoardFull()) {
                break;
            }
            Player player = deque.removeFirst();
            System.out.println(player.getFirstName() + "'s move");

            System.out.println("Please Enter the position where to insert piece");
            int y = sc.nextInt();

            if (!board.isCellEmpty(y)) {
                System.out.println("Column is already full");
                deque.addFirst(player);
                continue;
            }

            int x = board.move(y, player.getPiece());

            if (board.checkIfGameEnded(x, y, player.getPiece())) {
                displayBoard();
                return "And the winner is: " + player.getFirstName() + " with piece: " + player.getPiece();

            }
            else {
                deque.addLast(player);
            }
        }

        return "Tie";
    }

    private static void displayBoard() {
        board.display();
    }

    private static void initializeGame(Scanner sc) {
        Player playerA = new Player("Dheerendra", new RedPiece());
        Player playerB = new Player("Ozone", new YellowPiece());

        deque = new ArrayDeque<>();

        System.out.println("Please enter the size of game board... x and y");
        int n = sc.nextInt(), m = sc.nextInt();

        board = new Board(n, m);
        deque.add(playerA);
        deque.add(playerB);

        System.out.println("Player 1 = " + playerA.toString());
        System.out.println("Player 2 = " + playerB.toString());
    }
}
