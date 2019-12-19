package com.zhl.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/18 10:23
 */
public class LeetCode_728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> nums = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean flag = true;
            int num = i;
            while (num != 0) {
                int temp = num % 10;
                if (temp == 0 || i % temp != 0) {
                    flag = false;
                    // 添加了一个break，性能提升了两秒
                    break;
                }
                num = num / 10;
            }
            if (flag) {
                nums.add(i);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        LeetCode_728 test = new LeetCode_728();
        List<Integer> list = test.selfDividingNumbers(1, 22);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
