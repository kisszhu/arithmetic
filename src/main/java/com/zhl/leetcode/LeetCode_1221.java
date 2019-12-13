package com.zhl.leetcode;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/13 09:53
 */
public class LeetCode_1221 {

    public int balancedStringSplit(String s) {
        int num = 0;
        int r = 0;
        int l = 0;
        for (char i : s.toCharArray()) {
            if (i == 'R') {
                r++;
            }
            if (i == 'L') {
                l++;
            }
            if (r == l) {
                num++;
                r = 0;
                l = 0;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode_1221 test = new LeetCode_1221();
        int result = test.balancedStringSplit("LLLLRRRR");
        System.out.println(result);
    }
}
