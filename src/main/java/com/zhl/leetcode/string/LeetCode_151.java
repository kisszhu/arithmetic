package com.zhl.leetcode.string;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/10 10:08
 */
public class LeetCode_151 {

    public String reverseWords(String s) {
        String[] array = s.split(" +");
        int length = array.length - 1;
        StringBuilder sb = new StringBuilder();
        for (; length >= 0; length--) {
            sb.append(array[length] + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        LeetCode_151 test = new LeetCode_151();
        System.out.println(test.reverseWords("a good   example"));
    }
}
