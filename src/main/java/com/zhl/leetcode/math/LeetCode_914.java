package com.zhl.leetcode.math;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/27 08:55
 */
public class LeetCode_914 {

    public boolean hasGroupsSizeX(int[] deck) {
        int[] group = new int[10000];
        for (int cnt : deck) {
            group[cnt]++;
        }

        int x = -1;
        for (int cnt : group) {
            if (cnt > 0) {
                // 求最大公约数
                x = x == -1 ? cnt : gcd(x, cnt);
                if (x == 1) {
                    return false;
                }
            }
        }
        return x >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        LeetCode_914 test = new LeetCode_914();
        System.out.println(test.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 4, 4, 3, 2, 1}));
    }
}

