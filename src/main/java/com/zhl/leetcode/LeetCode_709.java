package com.zhl.leetcode;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/12 10:06
 */
public class LeetCode_709 {

///    public String toLowerCase(String str) {
//        return str = str.toLowerCase();
//    }

    /**
     * 寻找更多的解决思路，而不是直接使用toLowerCase()
     *
     * @param str
     * @return
     */
    public String toLowerCase(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char i : str.toCharArray()) {
            if (i >= 65 && i <= 90) {
                sb.append((char) (i + 32));
            } else {
                sb.append(i);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LeetCode_709 test = new LeetCode_709();
        String result = test.toLowerCase("Hello");
        System.out.println(result);
    }
}
