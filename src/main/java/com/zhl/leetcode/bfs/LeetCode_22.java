package com.zhl.leetcode.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/09 10:33
 */
public class LeetCode_22 {

    /**
     * 广度遍历：
     * 创建节点对象，使用队列完成广度优先遍历
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        return list;
    }

    public static void main(String[] args) {
        LeetCode_22 test = new LeetCode_22();
        List<String> list = test.generateParenthesis(3);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
