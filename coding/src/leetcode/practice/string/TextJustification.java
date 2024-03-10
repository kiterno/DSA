package leetcode.practice.string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (String word: words) {
            if (sb.length() + word.length() >= maxWidth) {
                result.add(sb.toString());
                sb.setLength(0);
            }
            sb.append(word);
            sb.append(" ");
        }

        if (!sb.isEmpty()) {
            result.add(sb.toString());
        }

        List<String> finalResult = new ArrayList<>();
        System.out.println(result);
        for(String dx: result) {
            dx = dx.trim();

            StringBuilder stringBuilder = getStringBuilder(words, maxWidth, dx);

            finalResult.add(stringBuilder.toString());
            System.out.println(finalResult);
            stringBuilder.setLength(0);
        }

        return finalResult;
    }

    private static StringBuilder getStringBuilder(String[] words, int maxWidth, String dx) {
        int size = dx.length();
        int needSpace = maxWidth -size;
        String[] wordsInRow = dx.split(" ");
        needSpace+=wordsInRow.length;
        int eachAddition = needSpace/wordsInRow.length;
        int extra = needSpace - eachAddition*wordsInRow.length;
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<wordsInRow.length-1;i++) {
            stringBuilder.append(words[i]);
            for(int j=0;j<eachAddition+extra;j++) {
                stringBuilder.append(" ");
            }
            extra = 0;
        }
        stringBuilder.append(wordsInRow[wordsInRow.length-1]);
        return stringBuilder;
    }
}
