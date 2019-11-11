package com.zhl.learn.algorithm.stack;

import com.zhl.learn.algorithm.list.ListNode;

public class StackLi {

    private ListNode topOfStack;

    public StackLi() {
        topOfStack = null;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return topOfStack == null;
    }

    public void makeEmpty() {
        topOfStack = null;
    }

    /**
     * Insert a new item into the stack
     *
     * @param x
     */
    public void push(Object x) {
        topOfStack = new ListNode(x, topOfStack);
    }

    /**
     * Get the most recently inserted item in the stack
     *
     * @return
     */
    public Object top() {
        if (isEmpty()) {
            return null;
        }
        return topOfStack.element;
    }

    /**
     * Remove the most recently inserted item from teh stack
     */
    public void pop() {
        if (isEmpty()) {
            // ignore
        }
        topOfStack = topOfStack.next;
    }

    /**
     * Return and remove the most recently inserted item from the stack
     *
     * @return
     */
    public Object topAndPop() {
        if (isEmpty()) {
            return null;
        }
        Object topItem = topOfStack.element;
        topOfStack = topOfStack.next;
        return topItem;
    }


}
