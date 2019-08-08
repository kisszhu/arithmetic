package com.zhl.learn.dataStructure.list;


public class LinkedListItr {

    // Current position
    ListNode current;

    LinkedListItr(ListNode theNode) {
        current = theNode;
    }

    public boolean isPastEnd() {
        return current == null;
    }

    public Object retrieve() {
        return isPastEnd() ? null : current.element;
    }

    public void advance() {
        if (!isPastEnd()) {
            current = current.next;
        }
    }
    
}
