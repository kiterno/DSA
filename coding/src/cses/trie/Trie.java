package cses.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
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

    boolean search(Trie node, String word) {
        Trie temp = node;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!temp.children.containsKey(ch))
                return false;

            temp = temp.children.get(ch);
        }

        return temp.endOfWord;
    }

    public static void main(String[] args) {
        Trie node = new Trie();

        node.insert(node, "geeks");
        System.out.print(node.search(node, "geeks") + " ");

        node.insert(node, "for");
        System.out.print(node.search(node, "for") + " ");

        System.out.print(node.search(node, "geekk") + " ");

        node.insert(node, "gee");
        System.out.print(node.search(node, "gee") + " ");

        node.insert(node, "science");
        System.out.print(node.search(node, "science") + " ");

        node.insert(node, "scienc");
        System.out.println(node.search(node, "scienc"));
    }
}
