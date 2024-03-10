package design.pattern.systemdesign.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if (board[row][column] != null)
            return false;

        board[row][column] = playingPiece;
        return true;
    }

    public List<int[]> getFreeCells() {
        List<int[]> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    int[] rowCol = {i, j};
                    freeCells.add(rowCol);
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] == null ? "\t|" :  " " +board[i][j].getPieceType()+"\t|");
            }
            System.out.println();
        }
    }
}
