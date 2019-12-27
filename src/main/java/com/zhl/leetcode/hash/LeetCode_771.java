package com.zhl.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/19 09:22
 */
public class LeetCode_771 {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>(16);
        for (char i : J.toCharArray()) {
            set.add(i);
        }
        int num = 0;
        for (char i : S.toCharArray()) {
            if (set.contains(i)) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode_771 test = new LeetCode_771();
        int result = test.numJewelsInStones("z", "ZZZ");
        System.out.println(result);
    }
}
