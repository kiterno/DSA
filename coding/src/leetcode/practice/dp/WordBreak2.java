package leetcode.practice.dp;

import java.util.ArrayList;
import java.util.List;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result  = new ArrayList<>();

        createWords(s, wordDict, 0, "", "", result);
        return result;
    }

    private void createWords(String s, List<String> wordDict, int i, String temp, String word, List<String> result) {
        if(s.length()<=i) {
            result.add(word.trim());
            return;
        }

        while(i<s.length()) {
            temp = temp+s.charAt(i);

            if(wordDict.contains(temp)) {
                createWords(s, wordDict, i+1, "", word+temp+" ", result);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        WordBreak2 break2 = new WordBreak2();

        String s = "catsanddog";
        List<String> wordDict = List.of("cat","cats","and","sand","dog");
        System.out.println(break2.wordBreak(s, wordDict));

        s = "pineapplepenapple";
        wordDict = List.of("apple", "pen","applepen","pine","pineapple");
        System.out.println(break2.wordBreak(s, wordDict));

        s = "catsandog";
        wordDict = List.of("cats","dog","sand","and","cat");
        System.out.println(break2.wordBreak(s, wordDict));
    }
}
