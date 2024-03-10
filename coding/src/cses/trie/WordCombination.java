package cses.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int n = sc.nextInt();
        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(trie, sc.next());
        }

        long[] dp= new long[s.length()+1];
        dp[s.length()] = 1;

        for (int i = s.length()-1; i >= 0; i--) {
            dp[i] = trie.search(trie, s, i, dp);
        }

        System.out.println(dp[0]);
    }

    public static class Trie {
        static int mod = 1000000007;
        Map<Character, Trie> children;
        boolean endOfWord;

        Trie() {
            children = new HashMap<>();
            endOfWord = false;
        }

        void insert(Trie node, String word) {
            Trie temp = node;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!temp.children.containsKey(ch)) {
                    temp.children.put(ch, new Trie());
                }

                temp = temp.children.get(ch);
            }

            temp.endOfWord = true;
        }

        long search(Trie node, String word, int start, long[] dp) {
            Trie temp = node;
            long ans = 0;

            for (int i = start; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!temp.children.containsKey(ch))
                    return ans;

                temp = temp.children.get(ch);

                if (temp.endOfWord)
                    ans = (ans + dp[i+1]) % mod;
            }

            return ans;
        }
    }
}
