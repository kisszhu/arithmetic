package com.zhl.leetcode.string;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/03 09:37
 */
public class LeetCode_8 {

    public int myAtoi(String str) {
        // 去除前后空格
        str = str.trim();

        // 字符为空或字符串仅包含空白字符时，返回0
        if (str.length() == 0) {
            return 0;
        }

        // 得到首字母
        char first = str.charAt(0);

        int ans = 0;
        boolean negative = false;
        if (first == '-') {
            // 处理负数
            negative = true;
        } else if (first == '+') {
            // 处理正数

        } else if (first >= '0' && first <= '9') {
            // 处理数字
            ans = first - '0';
        } else {
            //第一个非空格字符不是一个有效整数字符
            return 0;
        }

        char[] array = str.toCharArray();
        for (int i = 1; i < array.length; i++) {
            int value = array[i] - '0';
            if (value >= 0 && value <= 9) {
                if ((ans > (Integer.MAX_VALUE - value) / 10)) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans * 10 + value;
            } else {
                break;
            }
        }
        return negative ? -ans : ans;
    }

    public static void main(String[] args) {
        LeetCode_8 test = new LeetCode_8();
        System.out.println(test.myAtoi(" 23444444444449988448484848484848484848484848884848484848 b"));
    }
}
