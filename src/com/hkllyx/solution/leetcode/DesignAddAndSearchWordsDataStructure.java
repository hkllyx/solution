package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;

/**
 * <p>Design a data structure that supports adding new words and finding if a string matches any previously added string.</p>
 *
 * <p>Implement the <code>WordDictionary</code> class:</p>
 *
 * <ul>
 * 	<li><code>WordDictionary()</code>&nbsp;Initializes the object.</li>
 * 	<li><code>void addWord(word)</code> Adds <code>word</code> to the data structure, it can be matched later.</li>
 * 	<li><code>bool search(word)</code>&nbsp;Returns <code>true</code> if there is any string in the data structure that matches <code>word</code>&nbsp;or <code>false</code> otherwise. <code>word</code> may contain dots <code>&#39;.&#39;</code> where dots can be matched with any letter.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * [&quot;WordDictionary&quot;,&quot;addWord&quot;,&quot;addWord&quot;,&quot;addWord&quot;,&quot;search&quot;,&quot;search&quot;,&quot;search&quot;,&quot;search&quot;]
 * [[],[&quot;bad&quot;],[&quot;dad&quot;],[&quot;mad&quot;],[&quot;pad&quot;],[&quot;bad&quot;],[&quot;.ad&quot;],[&quot;b..&quot;]]
 * <strong>Output</strong>
 * [null,null,null,null,false,true,true,true]
 *
 * <strong>Explanation</strong>
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord(&quot;bad&quot;);
 * wordDictionary.addWord(&quot;dad&quot;);
 * wordDictionary.addWord(&quot;mad&quot;);
 * wordDictionary.search(&quot;pad&quot;); // return False
 * wordDictionary.search(&quot;bad&quot;); // return True
 * wordDictionary.search(&quot;.ad&quot;); // return True
 * wordDictionary.search(&quot;b..&quot;); // return True
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= word.length &lt;= 500</code></li>
 * 	<li><code>word</code> in <code>addWord</code> consists lower-case English letters.</li>
 * 	<li><code>word</code> in <code>search</code> consist of&nbsp; <code>&#39;.&#39;</code> or lower-case English letters.</li>
 * 	<li>At most <code>50000</code>&nbsp;calls will be made to <code>addWord</code>&nbsp;and <code>search</code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>深度优先搜索</li><li>设计</li><li>字典树</li><li>字符串</li></div></div><br><div><li>👍 388</li><li>👎 0</li></div>
 *
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