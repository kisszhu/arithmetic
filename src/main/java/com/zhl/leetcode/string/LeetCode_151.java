package com.zhl.leetcode.string;

import java.util.*;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/10 10:08
 */
public class LeetCode_151 {

    ///
//    public String reverseWords(String s) {
//        // 除去开头和末尾的空白字符
//        s = s.trim();
//
//        // 正则匹配连续的空白字符作为分隔符分割
//        List<String> wordList = Arrays.asList(s.split("\\s+"));
//        Collections.reverse(wordList);
//        return String.join(" ", wordList);
//    }

    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;

        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 思路和算法，由于双端队列支持从队列头部插入的方法，因此我们可以沿着字符串一个一个单词处理
        // 然后将单词压入队列的头部，在将队列转成字符串即可
        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if (word.length() != 0 && c == ' ') {
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());
        return String.join(" ", d);
    }

    public static void main(String[] args) {
        LeetCode_151 test = new LeetCode_151();
        System.out.println(test.reverseWords("a good   example"));
    }
}
