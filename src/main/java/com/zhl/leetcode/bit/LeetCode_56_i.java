package com.zhl.leetcode.bit;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/28 09:59
 */
public class LeetCode_56_i {

    /**
     * 一个整型数组nums里除了两个数字之外，其余数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * 要求时间复杂度为O(n)，空间复杂度为O(1)
     * <p>
     * 解析题目：
     * 由于数组中存在着两个数字不重复的情况，我们将所有的数字异或操作起来，最终得到的结果是这两个数字的异或结果：
     * （相同的两个数字互相异或，值为0），最后结果一定不为0，因为有两个数字不重复
     * <p>
     * 重复的数字进行分组，很简单，只需要有一个统一的规则，就可以把相同的数字分到同一组了。
     * 例如：奇偶分组，因为重复的数字，数值都是一样的，所以一定会分到同一组
     * <p>
     * 此时的难点在于，对两个不同数字的分组。此时我们要找到一个操作，让两个数字进行这个操作后，分为两组
     * 我们最容易想到的就是 &1 操作，当我们对奇偶分组时，容易地想到 &1，即用于判断最后一位二进制是否为1，来辨别奇偶。
     * 你看，通过&运算来判断一个数字不同即可分为两组，那么我们随便两个不同的数字至少也有一位不同吧
     * 我们只需要找出那位不同的数字mask，即可完成分组(&mask)操作
     * <p>
     * 示例：
     * 为了操作方便，我们只去找最低位的mask:
     * num1:101110 110 1111
     * num2:111110 001 1001
     * mask:010000 001 0010
     * 由于两个数异或的结果就是两个数数位不同结果的直观表现，所以我们可以通过异或后的结果去找最低位的mask!
     */

    public int[] singleNumbers(int[] nums) {
        // 用于将所有的数异或起来
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }

        // 获得k中最低位的1
        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        LeetCode_56_i test = new LeetCode_56_i();
        int[] res = test.singleNumbers(new int[]{4, 1, 4, 6});
        for (int num : res) {
            System.out.println(num);
        }
    }
}
