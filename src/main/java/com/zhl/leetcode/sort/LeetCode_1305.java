package com.zhl.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/01/22 10:08
 */
public class LeetCode_1305 {
    /**
     * 算法设计：
     * 先对两颗二叉树进行排序，形成两个有序数组，然后在进行归并排序
     *
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ansList1 = new ArrayList<>();
        List<Integer> ansList2 = new ArrayList<>();
        dfs(root1, ansList1);
        dfs(root2, ansList2);

        return merge(ansList1, ansList2);
    }
    
    /**
     * 中序遍历
     * 前提：这两颗树都是二叉搜索树(BST)，而一颗BST中旭遍历的结果就是排好序的
     * 这里时间复杂度是O(n)
     *
     * @param root
     * @param ansList
     */
    private void dfs(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }
        dfs(root.left, ansList);
        ansList.add(root.val);
        dfs(root.right, ansList);
    }

    /**
     * 归并操作，时间复杂度是O(n)
     *
     * @param list1
     * @param list2
     * @return
     */
    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> ansList = new ArrayList<>();
        int size1 = list1.size();
        int size2 = list2.size();
        int index1, index2;
        for (index1 = 0, index2 = 0; index1 < size1 && index2 < size2; ) {
            int num1 = list1.get(index1);
            int num2 = list2.get(index2);
            if (num1 < num2) {
                ansList.add(num1);
                index1++;
            } else {
                ansList.add(num2);
                index2++;
            }
        }

        while (index1 < size1) {
            ansList.add(list1.get(index1++));
        }

        while (index2 < size2) {
            ansList.add(list2.get(index2++));
        }
        return ansList;
    }


    public static void main(String[] args) {
        LeetCode_1305 test = new LeetCode_1305();

        TreeNode root1 = new TreeNode(2);
        TreeNode root1Left = new TreeNode(1);
        TreeNode root1Right = new TreeNode(4);
        root1.left = root1Left;
        root1.right = root1Right;

        TreeNode root2 = new TreeNode(1);
        TreeNode root2Left = new TreeNode(0);
        TreeNode root2Right = new TreeNode(3);
        root2.left = root2Left;
        root2.right = root2Right;

        List<Integer> list = test.getAllElements(root1, root2);
        System.out.println(list);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}