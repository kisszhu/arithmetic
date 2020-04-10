package com.zhl.leetcode.math;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/03 22:43
 */
public class LeetCode1342 {
    public int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0) {
            // 2&1 =0  3&1 =1 可以用来处理奇偶
            if ((num & 1) == 0) {
                // >>=1 除以2  >>=2 除以2的平方
                num >>= 1;
            } else {
                num--;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1342 test = new LeetCode1342();
        System.out.println(test.numberOfSteps(123));
    }
}
