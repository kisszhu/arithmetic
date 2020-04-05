package com.zhl.leetcode.divide.conquer;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/04 20:43
 */
public class LeetCode_25_finish {

    /**
     * 引入伪头节点：初始化一个辅助节点作为合并链表的头节点，循环开始将各节点添加至此辅助节点之后
     * 本文引入伪头节点，以提升代码的简洁性和可读性
     * 初始化：伪头节点head(作为整个合并链表的头部)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        while (l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;

            if (a <= b) {
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            dummy.next = l1;
        }
        if (l2 != null) {
            dummy.next = l2;
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listA1 = new ListNode(1);
        ListNode listA2 = new ListNode(2);
        ListNode listA4 = new ListNode(4);
        listA1.next = listA2;
        listA2.next = listA4;

        ListNode listB1 = new ListNode(1);
        ListNode listB2 = new ListNode(3);
        ListNode listB4 = new ListNode(4);
        listB1.next = listB2;
        listB2.next = listB4;

        LeetCode_25_finish test = new LeetCode_25_finish();
        ListNode list = test.mergeTwoLists(listA1, listB1);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}