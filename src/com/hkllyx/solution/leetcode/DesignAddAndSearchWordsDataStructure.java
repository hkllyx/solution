package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;

/**
 * @author hkllyx
 * @date 2021-10-19
 */
@Solution(no = "211", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/")
public class DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assertions.assertEquals(wordDictionary.search("pad"), false);
        Assertions.assertEquals(wordDictionary.search("bad"), true);
        Assertions.assertEquals(wordDictionary.search(".ad"), true);
        Assertions.assertEquals(wordDictionary.search("b.."), true);
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
    }

    public void addWord(String word) {
        if (root ==null) {
            root = new TrieNode(true);
        }
        TrieNode cur = root;
        for (int i = 0, last = word.length() - 1; i <= last; i++) {
            cur = cur.addChild(word.charAt(i), i == last);
        }
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int i, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (i == word.length()) {
            return node.isEndpoint();
        }
        TrieNode[] children = node.getChildren();
        if (children == null) {
            return false;
        }
        char c = word.charAt(i++);
        if (c == '.') {
            for (TrieNode child : children) {
                if (search(word, i, child)) {
                    return true;
                }
            }
        } else {
            return search(word, i, children[c - 'a']);
        }
        return false;
    }

    private static class TrieNode {
        private boolean isEndpoint;
        private TrieNode[] children;

        public TrieNode(boolean isEndpoint) {
            this.isEndpoint = isEndpoint;
        }

        public TrieNode addChild(char c, boolean isEndpoint) {
            if (children == null) {
                children = new TrieNode[26];
            }
            int i = c - 'a';
            if (children[i] == null) {
                children[i] = new TrieNode(isEndpoint);
            } else if (isEndpoint && !children[i].isEndpoint) {
                children[i].isEndpoint = true;
            }
            return children[i];
        }

        public boolean isEndpoint() {
            return isEndpoint;
        }

        public TrieNode[] getChildren() {
            return children;
        }
    }
}