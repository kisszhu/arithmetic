package com.zhl.leetcode.bit;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/20 09:02
 */
public class LeetCode_1290 {

    public int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num = num * 2 + head.val;
            head = head.next;
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode_1290 test = new LeetCode_1290();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(0);
        ListNode third = new ListNode(1);
        second.next = third;
        head.next = second;
        int result = test.getDecimalValue(head);

        System.out.println(result);

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}