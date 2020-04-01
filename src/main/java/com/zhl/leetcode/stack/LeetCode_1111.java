package com.zhl.leetcode.stack;


/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/01 08:58
 */
public class LeetCode_1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray()) {
            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
            System.out.println(idx & 1);
            System.out.println((idx + 1) & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_1111 test = new LeetCode_1111();
        int[] res = test.maxDepthAfterSplit("(()())");
        for (int i : res) {
            System.out.println(i);
        }
    }
}
