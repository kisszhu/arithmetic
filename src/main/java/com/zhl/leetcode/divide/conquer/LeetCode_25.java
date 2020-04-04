package com.zhl.leetcode.divide.conquer;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/04 20:43
 */
public class LeetCode_25 {

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

        LeetCode_25 test = new LeetCode_25();
        ListNode list = test.mergeTwoLists(listA1, listB1);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}