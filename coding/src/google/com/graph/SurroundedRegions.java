package google.com.graph;

public class SurroundedRegions {

    public static void main(String[] args) {
//        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        new SurroundedRegions().solve(board);

        println(board);
    }

    private static void println(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static void println(boolean[][] vis) {
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                System.out.print(vis[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if(!vis[i][0] && board[i][0] == 'O')
                dfs(board, vis, i, 0);
            if(!vis[i][n-1] && board[i][n-1] == 'O')
                dfs(board, vis, i, n-1);
        }
        for (int i = 0; i < n; i++) {
            if(!vis[0][i] && board[0][i] == 'O')
                dfs(board, vis, 0, i);
            if(!vis[m-1][i] && board[m-1][i] == 'O')
                dfs(board, vis, m-1, i);
        }

        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if(!vis[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private static void dfs(char[][] board, boolean[][] vis, int x, int y) {
        vis[x][y] = true;

        if(validMove(board, vis, x+1, y))
            dfs(board, vis, x+1, y);
        if(validMove(board, vis, x-1, y))
            dfs(board, vis, x-1, y);
        if(validMove(board, vis, x, y+1))
            dfs(board, vis, x, y+1);
        if(validMove(board, vis, x, y-1))
            dfs(board, vis, x, y-1);
    }

    private static boolean validMove(char[][] board, boolean[][] vis, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && !vis[x][y] && board[x][y] == 'O';
    }
}
