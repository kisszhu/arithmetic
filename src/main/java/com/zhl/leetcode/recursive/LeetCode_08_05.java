package com.zhl.leetcode.recursive;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/02 09:31
 */
public class LeetCode_08_05 {
    /**
     * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
     */

    public int multiply(int A, int B) {
        if (B == 1) {
            return A;
        }

        A = A + multiply(A, --B);
        return A;
    }

    public static void main(String[] args) {
        LeetCode_08_05 test = new LeetCode_08_05();
        int result = test.multiply(1, 10);
        System.out.println(result);
    }
}
