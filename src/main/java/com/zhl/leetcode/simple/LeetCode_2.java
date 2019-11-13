package com.zhl.leetcode.simple;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/13 08:45
 */
public class LeetCode_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2 4 3  = 342
        // 5 6 4  = 465
        //

        return null;
    }

    public static void main(String[] args) {
        LeetCode_2 leetCode = new LeetCode_2();

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode result = leetCode.addTwoNumbers(node1, node4);
        System.out.println(result);
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int x) {
            val = x;
        }
    }
}