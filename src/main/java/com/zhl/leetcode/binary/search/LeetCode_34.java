package com.zhl.leetcode.binary.search;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/26 17:24
 */
public class LeetCode_34 {

    //    1、为什么 while 中是 < 而不是 <=?
//
//    答：用相同的方法分析，因为 right = nums.length 而不是 nums.length - 1。因此每次循环的「搜索区间」是 [left, right) 左闭右开。
//
//            while(left < right) 终止的条件是 left == right，此时搜索区间 [left, left) 为空，所以可以正确终止。
//
//    PS：这里先要说一个搜索左右边界和上面这个算法的一个区别，也是很多读者问的：刚才的 right 不是 nums.length - 1 吗，
//    为啥这里非要写成 nums.length 使得「搜索区间」变成左闭右开呢？
//
//    因为对于搜索左右侧边界的二分查找，这种写法比较普遍，我就拿这种写法举例了，保证你以后遇到这类代码可以理解。
//    你非要用两端都闭的写法反而更简单，我会在后面写相关的代码，把三种二分搜索都用一种两端都闭的写法统一起来，你耐心往后看就行了。


    public int[] searchRange(int[] nums, int target) {

        // 查询左边界
        int left = 0;
        int right = nums.length;
        boolean find = false;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                right = mid;
                find = true;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int zuo = find ? left : -1;

        // 查询右边界
        left = 0;
        right = nums.length;
        find = false;
        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] == target) {
                left = mid + 1;
                find = true;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        int rou = find ? left - 1 : -1;

        return new int[]{zuo, rou};
    }

    public static void main(String[] args) {
        LeetCode_34 test = new LeetCode_34();
        int[] index = test.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int i = 0; i < index.length; i++) {
            System.out.println(index[i]);
        }
    }
}
