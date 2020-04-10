package com.zhl.leetcode.math;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/07 21:59
 */
public class LeetCode_17 {

    /**
     * 朴素解法
     */
    public int[] printNumbers(int n) {
        // Math.pw(10,n) 得到10的几次方，得到不同位数的最大值
        // 两位数的最大值，就是10的平方，三位数的最大值就是100的立方，所以这里使用Math.pow函数
        ///  Math.pow(10, n);
        int max = (int) fastRow(10, n);
        int[] ans = new int[max - 1];
        for (int i = 1; i <= max - 1; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }

    /**
     * 自己尝试采用Math.pow(int a,int b)
     *
     * @param base
     * @param index
     * @return
     */
    private int fastRow(int base, int index) {
        int ans = 1;

        /*
          符号%表示求余。求余运算的结果是两数相除后的余数。因此，参与运算的值必须为整数
          符号/表示除法，注意，浮点类型的除法运算得到一个浮点数结果，而整数除法运算1/2结果为0

          数A/数B，A小于B，商为0，余数就是它自己，例如1/2的商为0，余数为1
         */
        while (index > 0) {
            if (index % 2 == 1) {
                ans *= base;
            }
            index /= 2;
            base *= base;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_17 test = new LeetCode_17();
        int[] nums = test.printNumbers(4);
    }
}
