package com.zhl.leetcode.math;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/30 08:41
 */
public class LeetCode_62 {

    /**
     * 约瑟夫环问题比较难想的点有两个：
     * 当数到最后一个节点不足m个时，需要跳到第一个节点来继续数，可以通过取余来完成
     * 每轮都是上一轮被删除节点的下一个节点开始数m个
     */
    public int lastRemaining(int n, int m) {
        // 0、1、2、3、4  --2
        // 0 1 3 4 --0
        // 1 3 4 --4
        // 1 3 --1
        // 3

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        LeetCode_62 test = new LeetCode_62();
        System.out.println(test.lastRemaining(5, 3));
    }
}