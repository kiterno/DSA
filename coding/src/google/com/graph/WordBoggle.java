package google.com.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBoggle {
    public static void main(String[] args) {
        char[][] boggle = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };

        String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};

        new WordBoggle().wordBoggle(boggle, dictionary);
    }

    public String[] wordBoggle(char[][] board, String[] dictionary)
    {
        // Write your code here
        Set<String> res = new HashSet<>();

        for (String dict: dictionary) {
            getListOfWords(board, res, dict);
        }

        int size = res.size(), k=0;
        String[] finalRes = new String[size];
        for(String s: res) {
            finalRes[k++] = s;
        }

        return finalRes;
    }

    private void getListOfWords(char[][] board, Set<String> res, String dict) {
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j< board[0].length; j++) {
                if(board[i][j] == dict.charAt(0) && dfs(board, "", i, j, dict, 0, new boolean[board.length][board[0].length])) {
                    res.add(dict);
                    return;
                }
            }
        }
    }

    private boolean dfs(char[][] board, String str, int i, int j, String dict, int index, boolean[][] vis) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return false;

        if(dict.charAt(index) != board[i][j])
            return false;

        if(vis[i][j])
            return false;

        if(str.length() == dict.length())
            return true;

        str += board[i][j];
        vis[i][j] = true;

        boolean a = dfs(board, str, i-1, j-1, dict, index+1, vis);
        boolean b = dfs(board, str, i-1, j, dict, index+1, vis);
        boolean c = dfs(board, str, i-1, j+1, dict, index+1, vis);
        boolean d = dfs(board, str, i, j-1, dict, index+1, vis);
        boolean e = dfs(board, str, i, j+1, dict, index+1, vis);
        boolean f = dfs(board, str, i+1, j-1, dict, index+1, vis);
        boolean g = dfs(board, str, i+1, j, dict, index+1, vis);
        boolean h = dfs(board, str, i+1, j+1, dict, index+1, vis);

        vis[i][j] = false;
        return a||b||c||d||e||f||g||h;
    }
}
