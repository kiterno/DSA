package google.com.backtrack;
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean vis[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!vis[i][j] && dfs(board, i, j, word, 0, vis))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int count, boolean[][] vis) {
        if(i>=0 && i<board.length && j>=0 && j<board[0].length && word.charAt(count) == board[i][j]) {
            if(vis[i][j])
                return false;

            vis[i][j] = true;

            if(count == word.length()-1)
                return true;

            boolean up = dfs(board, i-1, j, word, count+1, vis);
            boolean down = dfs(board, i+1, j, word, count+1, vis);
            boolean left = dfs(board, i, j-1, word, count+1, vis);
            boolean right = dfs(board, i, j+1, word, count+1, vis);

            vis[i][j] = false;

            return up || down || left || right;
        }
        return false;
    }
}
