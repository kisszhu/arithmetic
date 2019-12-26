package com.zhl.leetcode.list;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/25 21:34
 */
public class LeetCode_237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        LeetCode_237 test = new LeetCode_237();
        // test.deleteNode();
    }
}


// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }