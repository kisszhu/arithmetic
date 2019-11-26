package com.zhl.leetcode;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/13 08:45
 */
public class LeetCode_2 {
    /**
     * 重做
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2 4 3  = 342
        // 5 6 4  = 465

        // 这道题，只能采用前序遍历，不能采用后续遍历，因为两个数字的长度可能是不对应的
        // 采用for循环的问题，主要在于每次遍历都是独立的，所以不能构建出新ListNode的next关系
        // 可以采用前序遍历+后续遍历的结合

        ListNode node = new ListNode(0);
        addTwoNumbers(node, l1, l2, 0);
        node = node.next;
        return node;
    }

    public int addTwoNumbers(ListNode node, ListNode l1, ListNode l2, int ten) {
        if (l1 == null && l2 == null) {
            return 0;
        }

        // 获取 num1
        ListNode firstParam;
        int num1 = 0;
        if (l1 != null) {
            num1 = l1.val;
            firstParam = l1.next;
        } else {
            firstParam = null;
        }

        // 获取 num2
        ListNode secondParam;
        int num2 = 0;
        if (l2 != null) {
            num2 = l2.val;
            secondParam = l2.next;
        } else {
            secondParam = null;
        }

        int num = num1 + num2 + ten;
        if (num >= 10) {
            ListNode temp = new ListNode(num - 10);
            node.next = temp;
            if (firstParam == null && secondParam == null) {
                temp.next = new ListNode(1);
            }
            addTwoNumbers(temp, firstParam, secondParam, 1);
        } else {
            ListNode temp = new ListNode(num);
            node.next = temp;
            addTwoNumbers(temp, firstParam, secondParam, 0);
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode_2 leetCode = new LeetCode_2();

        ListNode node1 = new ListNode(5);
        //ListNode node2 = new ListNode(8);
        //ListNode node3 = new ListNode(3);
        //node1.next = node2;
        //node2.next = node3;

        ListNode node4 = new ListNode(5);
        //ListNode node5 = new ListNode(6);
        //ListNode node6 = new ListNode(4);
        //node4.next = node5;
        //node5.next = node6;

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