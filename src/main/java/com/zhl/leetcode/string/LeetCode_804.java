package com.zhl.leetcode.string;

import java.util.HashSet;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/17 09:35
 */
public class LeetCode_804 {

    public int uniqueMorseRepresentations(String[] words) {
        // 千万不要第一印象的就采用HashMap来存储
        String[] map = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                /// sb.append(map[c - 97]);
                sb.append(map[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        LeetCode_804 test = new LeetCode_804();
        int num = test.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
        System.out.println(num);
    }
}
