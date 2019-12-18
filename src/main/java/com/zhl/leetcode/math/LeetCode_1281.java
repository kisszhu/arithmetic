package com.zhl.leetcode.math;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/18 09:17
 */
public class LeetCode_1281 {

    public int subtractProductAndSum(int n) {
        int mult = 1;
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            mult *= temp;
            sum += temp;
            n = n / 10;
        }
        return mult - sum;
    }

    public static void main(String[] args) {
        LeetCode_1281 test = new LeetCode_1281();
        int result = test.subtractProductAndSum(234);
        System.out.println(result);
    }
}
