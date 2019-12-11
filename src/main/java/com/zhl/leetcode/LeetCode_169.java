package com.zhl.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/11 09:23
 */
public class LeetCode_169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int length = nums.length / 2;
        for (Map.Entry entry : map.entrySet()) {
            if (Long.valueOf(entry.getValue().toString()).intValue() > length) {
                return Long.valueOf(entry.getKey().toString()).intValue();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode_169 test = new LeetCode_169();
        int a = test.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(a);
    }
}
