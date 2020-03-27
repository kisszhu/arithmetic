package com.zhl.leetcode.string;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/27 09:47
 */
public class LeetCode_58_II {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        LeetCode_58_II test = new LeetCode_58_II();
        System.out.println(test.reverseLeftWords("abcdefg", 2));
    }
}
