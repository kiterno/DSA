package design.pattern.systemdesign.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    Deque<Player> players;
    Board board;

    Scanner sc = new Scanner(System.in);

    public TicTacToeGame() {
        initializeGame();
    }

    private void initializeGame() {
        players = new LinkedList<>();

        PlayingPieceO pieceO = new PlayingPieceO();
        Player player1 = new Player("Player1", pieceO);

        PlayingPieceX pieceX = new PlayingPieceX();
        Player player2 = new Player("Player2", pieceX);

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;

        while (noWinner) {
            Player playingPlayer = players.removeFirst();

            board.printBoard();
            List<int[]> freePiece = board.getFreeCells();

            if (freePiece.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.println("Player: " + playingPlayer.getName() + " Enter row, column: ");
            String s = sc.nextLine();
            String[] values = s.split(",");

            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            boolean pieceAddedSuccessFully = board.addPiece(row, col, playingPlayer.getPiece());
            if (!pieceAddedSuccessFully) {
                System.out.println("Incorrect Position chosen, try again");
                players.addFirst(playingPlayer);
                continue;
            }


            players.addLast(playingPlayer);
            boolean winner = isThereWinner(row, col, playingPlayer.getPiece().getPieceType());

            if (winner) {
                return playingPlayer.getName();
            }
        }
        return "Tie";
    }

    private boolean isThereWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean revDiagonalMatch = true;

        for (int i = 0; i < board.size; i++) {
            if (board.board[row][i] == null || board.board[row][i].getPieceType() != pieceType) {
                rowMatch = false;
            }
        }

        for (int i = 0; i < board.size; i++) {
            if (board.board[i][col] == null || board.board[i][col].getPieceType() != pieceType) {
                colMatch = false;
            }
        }

        for (int i = 0, j=0; i < board.size; i++, j++) {
            if (board.board[i][j] == null || board.board[i][j].getPieceType() != pieceType) {
                diagonalMatch = false;
            }
        }

        for (int i = 0, j= board.size-1; i < board.size; i++, j--) {
            if (board.board[i][j] == null || board.board[i][j].getPieceType() != pieceType) {
                revDiagonalMatch = false;
            }
        }

        return rowMatch || colMatch || diagonalMatch || revDiagonalMatch;
    }


    public static void main(String[] args) {

    }
}
