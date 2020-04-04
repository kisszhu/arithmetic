package com.zhl.leetcode.recursive;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/04 09:42
 */
public class LeetCode_42 {
    public int trap(int[] height) {
        // 木桶效应，找到最高的点，然后从最高点，向左右扩散
        if (height.length == 0) {
            return 0;
        }

        int max = 0;
        int idx = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                idx = i;
            }
        }

        // 求左侧面积
        int areaLeft = left(idx, height);
        // 求右侧面积
        int areaRight = right(idx, height);

        return areaLeft + areaRight;
    }

    private int left(int mid, int[] height) {
        if (mid == 0) {
            return 0;
        }
        // 依次找左侧最高点
        int index = mid - 1;
        int max = 0;
        int idx = 0;
        for (; index >= 0; index--) {
            if (height[index] >= max) {
                max = height[index];
                idx = index;
            }
        }

        // 求总面积
        int area = max * (mid - (idx + 1));

        int pillars = 0;
        int i = idx + 1;
        for (; i < mid; i++) {
            pillars += height[i] * 1;
        }
        int water = (area - pillars) + left(idx, height);
        return water;
    }

    private int right(int mid, int[] height) {
        if (mid == height.length - 1) {
            return 0;
        }
        // 依次找到右侧最高点
        int index = mid + 1;
        int max = 0;
        int idx = 0;
        for (; index < height.length; index++) {
            if (height[index] >= max) {
                max = height[index];
                idx = index;
            }
        }
        // 求第一高 与 第二高之间的水面积
        int area = max * (idx - (mid + 1));
        int pillars = 0;
        int i = mid + 1;
        for (; i < idx; i++) {
            pillars += height[i] * 1;
        }

        int water = (area - pillars) + right(idx, height);
        return water;
    }


//    动态规划，是用空间换时间，然后不是直接解决问题，
//    而是去想这个问题最开始是一个什么问题，逐步递推到所求问题。动态规划的基础部分绝大多数问题都是这种思路。


    public static void main(String[] args) {
        LeetCode_42 test = new LeetCode_42();
        System.out.println(test.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
