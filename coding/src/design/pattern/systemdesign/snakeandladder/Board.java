package design.pattern.systemdesign.snakeandladder;

import java.util.HashSet;
import java.util.Set;

public class Board {
    int size;
    int[][] board;
    Set<Snake> snakes;
    int scount;
    Set<Ladder> ladders;
    int lcount;

    public Board(int size, int scount, int lcount) {
        this.size = size;
        board = new int[size][size];
        this.scount = scount;
        this.lcount = lcount;
        snakes = new HashSet<>();
        ladders = new HashSet<>();

        initilizeBoard();
    }

    private void initilizeBoard() {
        while (snakes.size() < scount) {

        }
    }


}
