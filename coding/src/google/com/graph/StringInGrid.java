package google.com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringInGrid {
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        List<int[]> res = new ArrayList<>();
        int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};

        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                if(word.charAt(0) == grid[i][j]) {
//                    if(foundWord(grid, i, j, m, n, word, 0, vis, moves[0]) || foundWord(grid, i, j, m, n, word, 0, vis, moves[1])
//                        || foundWord(grid, i, j, m, n, word, 0, vis, moves[2]) || foundWord(grid, i, j, m, n, word, 0, vis, moves[3])
//                        || foundWord(grid, i, j, m, n, word, 0, vis, moves[4]) || foundWord(grid, i, j, m, n, word, 0, vis, moves[5])
//                        || foundWord(grid, i, j, m, n, word, 0, vis, moves[6]) || foundWord(grid, i, j, m, n, word, 0, vis, moves[7])) {
//                        res.add(new int[]{i, j});
//                    }
//                }
                if(foundWord(grid, i, j, m, n, word, 0, vis)) {
                    res.add(new int[]{i, j});
                }
            }
        }

        int size = res.size();
        int[][] cast = new int[size][2];
        for (int i = 0; i < size; i++) {
            cast[i][0] = res.get(i)[0];
            cast[i][1] = res.get(i)[1];
        }

        return cast;
    }

    private boolean foundWord(char[][] grid, int i, int j, int m, int n, String word, int index, boolean[][] vis) {
        if(i<0||i>=m||j<0||j>=n) {
            return false;
        }
        else {
            boolean a = false, b = false, c = false, d = false;
            if(!vis[i][j] && grid[i][j] == word.charAt(index)) {
                vis[i][j] = true;
                if(index == word.length()-1) {
                    a = true;
                }
                else {
                    a = foundWord(grid, i+1, j, m, n, word, index+1, vis);
                    b = foundWord(grid, i-1, j, m, n, word, index+1, vis);
                    c = foundWord(grid, i, j+1, m, n, word, index+1, vis);
                    d = foundWord(grid, i, j-1, m, n, word, index+1, vis);
                }
                vis[i][j] = false;
            }
            return a||b||c||d;
        }
    }

    private boolean foundWord(char[][] grid, int i, int j, int m, int n, String word, int index, boolean[][] vis, int[] move) {
        if(i<0||i>=m||j<0||j>=n) {
            return false;
        }
        else {
            boolean a = false;
            if(!vis[i][j] && grid[i][j] == word.charAt(index)) {
                vis[i][j] = true;
                if(index == word.length()-1) {
                    a = true;
                }
                else {
                    a = foundWord(grid, i+move[0], j+move[1], m, n, word, index+1, vis, move);
                }
                vis[i][j] = false;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m=scanner.nextInt(), n = scanner.nextInt();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            grid[i] = scanner.next().toCharArray();
        }

        String word = scanner.next();

        StringInGrid sg = new StringInGrid();
        int[][] res = sg.searchWord(grid, word);

        for (int[] i: res)
            System.out.println(i[0]+" "+i[1]);
    }
}

/*
    private boolean foundWord(char[][] grid, int i, int j, int m, int n, String word, int index, boolean[][] vis) {
        if(i<0||i>=m||j<0||j>=n) {
            return false;
        }
        else {
            boolean a = false, b = false, c = false, d = false;
            if(!vis[i][j] && grid[i][j] == word.charAt(index)) {
                vis[i][j] = true;
                if(index == word.length()-1) {
                    a = true;
                }
                else {
                    a = foundWord(grid, i+1, j, m, n, word, index+1, vis);
                    b = foundWord(grid, i-1, j, m, n, word, index+1, vis);
                    c = foundWord(grid, i, j+1, m, n, word, index+1, vis);
                    d = foundWord(grid, i, j-1, m, n, word, index+1, vis);
                }
                vis[i][j] = false;
            }
            return a||b||c||d;
        }
    }
    */
