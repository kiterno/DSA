package leetcode.practice.dp;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
    public List<String> wordBreak(List<String> wordDict) {
        List<String> result  = new ArrayList<>();

        for(String s: wordDict) {
            createWords(s, wordDict, 0, "", "", result);
        }
        return result;
    }

    private void createWords(String s, List<String> wordDict, int i, String temp, String word, List<String> result) {
        if(s.length()<=i && word.length()>s.length()) {
            result.add(s);
            return;
        }

        while(i<s.length()) {
            temp = temp+s.charAt(i);

            if(wordDict.contains(temp) && !temp.equals(s)) {
                createWords(s, wordDict, i+1, "", word+temp+" ", result);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        ConcatenatedWords concatenatedWords = new ConcatenatedWords();

        List<String> wordDict = List.of("cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat");
        System.out.println(concatenatedWords.wordBreak(wordDict));

        wordDict = List.of("apple", "pen","applepen","pine","pineapple");
        System.out.println(concatenatedWords.wordBreak(wordDict));

        wordDict = List.of("cats","dog","sand","and","cat");
        System.out.println(concatenatedWords.wordBreak(wordDict));
        System.out.println(concatenatedWords.wordBreak(List.of("cat","dog","catdog")));
    }
}
