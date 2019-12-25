package com.zhl.leetcode.sort;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/22 14:20
 */
public class LeetCode_147 {

    /**
     * 插入排序的原理其实很简单,就是选出一个元素之后，和之前的元素进行对比
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode newNode = new ListNode(0);
        newNode.val = head.val;

        while (head != null) {
            ListNode secod = head.next;

            while (newNode != null) {
                if (secod.val > newNode.val) {
                    break;
                } else {
                    
                }
            }
            head = secod;
        }
//        ListNode newNode = new ListNode(0);
//        // 从第二个元素开始
//        while (head != null) {
//            ListNode temp = head.next;
//
//
//            // 比较当前元素之前的所有元素
//            while (head != null) {
////                if (temp.val > head.val) {
////                    break;
////                } else {
////                    // 元素右移动
////                    head.next = head.next.next;
////                }
//                if (temp.val > head.val && temp.val < head.next.val) {
//                    ListNode a = head.next;
//                    head.next = temp;
//                    temp.next = a;
//                }
//            }
//
//        }
        return null;
    }

//    public int[] insertionSort(int[] num) {
//        int i, j, temp;
//        // 从第二个元素开始
//        for (i = 1; i < num.length; i++) {
//            temp = num[i];
//            // 比较当前元素之前的所有元素
//            for (j = i - 1; j >= 0; j--) {
//
//                if (temp > num[j]) {
//                    break;
//                } else {
//                    // 元素右移动
//                    num[j + 1] = num[j];
//                }
//            }
//            num[j + 1] = temp;
//        }
//        return num;
//    }

    public static void main(String[] args) {
        LeetCode_147 test = new LeetCode_147();

        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        node1.next = node3;
        node2.next = node1;
        node4.next = node2;
        test.insertionSortList(node4);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}