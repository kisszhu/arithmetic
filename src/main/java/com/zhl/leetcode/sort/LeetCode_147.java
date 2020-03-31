package com.zhl.leetcode.sort;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/31 09:00
 */
public class LeetCode_147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // 找到当前pre节点
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = tmp;
        }
        return dummy.next;
    }

/// 另一种优化思路
//    public ListNode insertionSortList(ListNode head) {
//        // 数组和链表的区别
//        ListNode dummy = new ListNode(Integer.MIN_VALUE);
//        dummy.next = head;
//        ListNode pre = dummy;
//        ListNode end = dummy;
//        ListNode cur = head;
//
//        while (cur != null) {
//            if (end.val < cur.val) {
//                end.next = cur;
//                end = cur;
//                cur = cur.next;
//            } else {
//                ListNode tmp = cur.next;
//                end.next = tmp;
//                while (pre.next != null && pre.next.val < cur.val) {
//                    pre = pre.next;
//                }
//                cur.next = pre.next;
//                pre.next = cur;
//                pre = dummy;
//                cur = tmp;
//            }
//        }
//        return dummy.next;
//    }

    public static void main(String[] args) {
        // 4->2->1->3
        // -1->5->3->4->0
        ListNode listNode4 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        listNode4.next = listNode2;
        listNode2.next = listNode1;
        listNode1.next = listNode3;

        LeetCode_147 test = new LeetCode_147();
        ListNode list = test.insertionSortList(listNode4);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }


    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}