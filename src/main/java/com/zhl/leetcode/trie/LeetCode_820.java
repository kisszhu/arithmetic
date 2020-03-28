package com.zhl.leetcode.trie;

import java.util.Arrays;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/28 09:09
 */
public class LeetCode_820 {

    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先按字符串长度进行排序
        Arrays.sort(words, (w1, w2) -> Integer.compare(w2.length(), w1.length()));

        // 单词插入trie，返回该单词增加的编码长度
        // 单词插入trie，返回该单词增加的编码长度
        for (String word : words) {
            len += trie.insert(word);
        }

        return len;
    }

    public static void main(String[] args) {
        LeetCode_820 test = new LeetCode_820();
        int res = test.minimumLengthEncoding(new String[]{"me", "time", "bell"});
        System.out.println(res);
    }


    /**
     * 定义Trie
     */
    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int insert(String word) {
            TrieNode cur = root;
            boolean isNew = false;

            // 倒着插入单词
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    // 是新单词
                    isNew = true;
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            // 如果是新单词的话编码长度增加新单词的长度+1，否则不变
            return isNew ? word.length() + 1 : 0;
        }

    }

    /**
     * 定义TrieNode
     */
    class TrieNode {
        char val;

        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        public TrieNode(char val) {
            this.val = val;
        }
    }
}
