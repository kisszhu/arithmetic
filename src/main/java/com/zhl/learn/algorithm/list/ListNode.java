package com.zhl.learn.algorithm.list;

public class ListNode {

    public Object element;
    public ListNode next;

    ListNode(Object theElement) {
        this(theElement, null);
    }

    public ListNode(Object theElement, ListNode n) {
        element = theElement;
        next = n;
    }

}
