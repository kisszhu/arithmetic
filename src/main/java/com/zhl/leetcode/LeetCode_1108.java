package com.zhl.leetcode;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/12 09:55
 */
public class LeetCode_1108 {

    /**
     * 运行时间比较低，同时内存需求也比较低
     *
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        StringBuilder ans = new StringBuilder();
        for (char i : address.toCharArray()) {
            if (i != '.') {
                ans.append(i);
            } else {
                ans.append("[.]");
            }
        }
        return ans.toString();
    }

//    /**
//     * 比较耗时，但是内存要求低
//     * @param address
//     * @return
//     */
//    public String defangIPaddr(String address) {
//        address = address.replaceAll("\\.", "[.]");
//        return address;
//    }

    public static void main(String[] args) {
        LeetCode_1108 test = new LeetCode_1108();
        String result = test.defangIPaddr("1.1.1.1");
        System.out.println(result);
    }
}
