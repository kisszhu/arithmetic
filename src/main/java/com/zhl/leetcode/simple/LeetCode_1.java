package com.zhl.leetcode.simple;


import java.util.HashMap;
import java.util.Map;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/11 09:03
 */
public class LeetCode_1 {
    /**
     * 求解两数之和，除了暴力算法之外，其核心应该就是根据差值去寻找下一个数值。
     * 那么如何根据差值找到下一个数值呢？
     * 这里的做法，是将差值变换为index，来找到下一个数值。
     * <p>
     * 我的第一个解法，就体现了这个思路在里面，只不过map不支持相同的key导致该解法的覆盖度有问题。
     * 所以，所以我转化为了第二种解法。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        // 第二种解决：成功
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                index[0] = map.get(nums[i]);
                index[1] = i;
            }
            map.put(target - nums[i], i);
        }

        return index;

//        // 第一种解法：将数值与索引反转，但是Map无法处理相同key问题，顾失败
//        Map<Integer, Integer> map = new HashMap<>(16);
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int difference = target - entry.getKey();
//            Integer others = map.get(difference);
//            if (others != null) {
//                return new int[]{entry.getValue(), others};
//            }
//        }
//        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] str = new LeetCode_1().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(str[0]);
        System.out.println(str[1]);
    }
}