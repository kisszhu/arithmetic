package com.zhl.leetcode.hash;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/16 21:14
 */
public class LeetCode_1365 {

//    排序 + 映射
//    时间复杂度 O(nlog(n))O(nlog(n))，空间复杂度 O(n)O(n)
//    你的索引是多少，就有多少个数字小于你
//    严格说应该是 小于等于你

    /**
     * 排序 + 映射
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        Map<Integer, HashSet<Integer>> hash = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            if (hash.containsKey(nums[i])) {
                hash.get(nums[i]).add(i);
            } else {
                HashSet set = new HashSet();
                set.add(i);
                hash.put(nums[i], set);
            }
        }

        int[] sortedArr = Arrays.copyOf(nums, len), res = new int[len];
        // 1, 2, 2, 3, 8
        Arrays.sort(sortedArr);
        for (int si = len - 1; si >= 0; si--) {
            for (int i : hash.get(sortedArr[si])) {
                res[i] = si;
            }
        }
        return res;
    }

    /**
     * 计数排序
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        // 统计出现频率 frequency
        // 索引即数值
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }

        // 对频率(而非对原数组nums)从前到后累加
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i] + freq[i - 1];
        }

        // 输出结果
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (nums[i] > 0) {
                res[i] = freq[nums[i] - 1];
            }
        }
        return res;
    }

    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent3(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] < nums[i]) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_1365 test = new LeetCode_1365();
        int[] nums = {8, 1, 2, 2, 3};
        int[] res = test.smallerNumbersThanCurrent(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
