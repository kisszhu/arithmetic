package com.zhl.leetcode.sort;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/03/31 09:00
 */
public class LeetCode_147 {


//    本题是对链表进行插入排序
//
//    定义两个指针pre和end从带头结点dummy开始，pre用来确定插入位置的前驱，end用来表示已排序部分的最后一个元素也是当前遍历结点的前驱
//
//            如果当前顺序符合要求则结点指针后移遍历下一个结点
//
//    如果需要改变顺序，则先用tmp指针保存当前结点的后继，方便找到下轮排序的起始位置，同时也防止闭环的产生
//
//    确定好需要移动的元素，应该先判断pre指针所在位置是否为插入位置的前驱，如果不是则向后移动直到满足要求
//
//    每经过一轮排序，记得要将“定位”指针放到适当的位置，最后返回dummy结点后面的元素即可。


    public ListNode insertionSortList(ListNode head) {
        // 数组和链表的区别
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (end.val < cur.val) {
                end.next = cur;
                end = cur;
                cur = cur.next;
            } else {
                ListNode tmp = cur.next;
                end.next = tmp;
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                cur.next = pre.next;
                pre.next = cur;
                pre = dummy;
                cur = tmp;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // 4->2->1->3
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