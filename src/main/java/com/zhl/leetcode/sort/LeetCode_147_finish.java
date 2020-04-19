package com.zhl.leetcode.sort;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/31 09:00
 */
public class LeetCode_147_finish {

    /**
     * 在插入排序中，List和Array的最大的区别在于，Array可以向前遍历，而List则不能
     * 所以List是缺少排序空间的，所以这里通过创建一个新的ListNode list来作为排序空间
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode list = new ListNode(Integer.MIN_VALUE);
        ListNode pro = list;
        ListNode cur = head;

        while (cur != null) {

            // 寻找插入的中间节点的位置
            while (pro.next != null && pro.next.val < cur.val) {
                pro = pro.next;
            }
            ListNode tmp = cur.next;

            // 把中间节点之后的节点保留
            cur.next = pro.next;
            // 插入当前值 + 之后节点的值
            pro.next = cur;
            // 回到起始位置
            pro = list;

            // 开始下一个数字的遍历
            cur = tmp;
        }

        return list.next;
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

        LeetCode_147_finish test = new LeetCode_147_finish();
        ListNode list = test.insertionSortList(listNode4);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}