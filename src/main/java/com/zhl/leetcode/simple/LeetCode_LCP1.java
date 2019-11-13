package com.zhl.leetcode.simple;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/13 08:27
 */
public class LeetCode_LCP1 {

    public int game(int[] guess, int[] answer) {
        int num = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode_LCP1 leetCode = new LeetCode_LCP1();
        int num = leetCode.game(new int[]{2, 2, 3}, new int[]{3, 2, 1});
        System.out.println(num);
    }
}
