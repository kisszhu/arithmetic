package com.zhl.leetcode.dp;

import java.util.Arrays;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/01/23 13:40
 */
public class LeetCode_1025 {

    /**
     * 运用动态规划解决
     *
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        boolean[] arra = new boolean[1001];
        Arrays.fill(arra, false);
        arra[1] = false;
        arra[2] = true;

        if (N >= 3) {
            for (int i = 3; i <= N; i++) {
                for (int j = 1; j < i; j++) {
                    if (i % j == 0 && arra[i - j] == false) {
                        arra[i] = true;
                    }
                }
            }
        }
        return arra[N];
    }

    public static void main(String[] args) {
        LeetCode_1025 test = new LeetCode_1025();
        boolean flag = test.divisorGame(4);
        System.out.println(flag);
    }
}
