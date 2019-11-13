package com.zhl.leetcode.simple;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LeetCode_83 {

    /**
     * 第一种正确解法：递归的好处，相比于循环遍历来说，就是可以进行后续遍历，先遍历到链表的底部，
     * 然后在逐层的回返，在回返的过程中，如果发现父亲和儿子的值是相同的，那么直接就用儿子来替代父亲。
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        head.next = deleteDuplicates(head.next);
        if (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    /**
     * 第二种正确解法：通过循环遍历的方式
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates3(ListNode head) {
        ListNode pre = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return pre;
    }

    /**
     * 第一种错误解法：通过循环遍历，无很难解决这个问题，因为循环遍历，会遍历到链表的底，这个时候，是无法返回
     * 整个链表的，即head的值为链表3而不是1。
     *
     * @param head
     */
    public ListNode deleteDuplicates2(ListNode head) {
        int val = head.val;
        ListNode next = head.next;
        while (next != null) {
            if (val != next.val) {
                val = next.val;
                head.next = next;
                head = next;
            }
            next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode_83 test = new LeetCode_83();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        test.deleteDuplicates(node1);
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int x) {
            val = x;
        }
    }

}

