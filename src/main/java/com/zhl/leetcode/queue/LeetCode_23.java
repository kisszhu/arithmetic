package com.zhl.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/13 20:01
 */
public class LeetCode_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue();

        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node.val);
                node = node.next;
            }
        }

        ListNode node = new ListNode(0);
        ListNode dummy = node;
        while (!queue.isEmpty()) {
            dummy.next = new ListNode(queue.poll());
            dummy = dummy.next;
        }
        return node.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode li1_1 = new ListNode(1);
        ListNode li1_4 = new ListNode(4);
        ListNode li1_5 = new ListNode(5);
        li1_1.next = li1_4;
        li1_4.next = li1_5;

        ListNode li2_1 = new ListNode(1);
        ListNode li2_3 = new ListNode(3);
        ListNode li2_4 = new ListNode(4);
        li2_1.next = li2_3;
        li2_3.next = li2_4;

        ListNode li3_2 = new ListNode(2);
        ListNode li3_6 = new ListNode(6);
        li3_2.next = li3_6;

        ListNode[] list = new ListNode[3];
        list[0] = li1_1;
        list[1] = li2_1;
        list[2] = li3_2;

        LeetCode_23 test = new LeetCode_23();

        ListNode res = test.mergeKLists(list);
        System.out.println(res);
    }

//    [
//            1->4->5,
//            1->3->4,
//            2->6
//            ]
}

//
// * Definition for singly-linked list.
//         * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }