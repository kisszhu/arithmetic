package com.zhl.learn.dataStructure.tree.adt;

public class BinarySearchTree {

    private BinaryNode root; // the root


    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Comparable find(Comparable x) {
        return elementAt(find(x, root));
    }

    public Comparable findMin() {
        return elementAt(findMin(root));
    }

    public Comparable findMax() {
        return elementAt(findMax(root));
    }

    public void insert(Comparable x) {
        root = insert(x, root);
    }

    public void remove(Comparable x) {
        root = remove(x, root);
    }

    public void printTree() {

    }


    // Various private methods; mostly recursive
    private Comparable elementAt(BinaryNode t) {
        return t == null ? null : t.element;
    }

    // 二叉查找树的find操作
    // 尾递归
    private BinaryNode find(Comparable x, BinaryNode t) {
        if (t == null)
            return null;
        if (x.compareTo(t.element) < 0)
            return find(x, t.left);
        else if (x.compareTo(t.element) > 0)
            return find(x, t.right);
        else
            return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     */
    private BinaryNode findMin(BinaryNode t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    private BinaryNode findMax(BinaryNode t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    private BinaryNode insert(Comparable x, BinaryNode t) {
        if (t == null) {
            t = new BinaryNode(x, null, null);
        } else if (x.compareTo(t.element) < 0) {
            t.left = insert(x, t.left);
        } else if (x.compareTo(t.element) > 0) {
            t.right = insert(x, t.right);
        } else
            ;
        return t;
    }

    /**
     * 这个代码似乎有点问题呢
     */
    private BinaryNode remove(Comparable x, BinaryNode t) {
        if (t == null) {
            return t;
        }
        if (x.compareTo(t.element) < 0) {
            t.left = remove(x, t.left);
        } else if (x.compareTo(t.element) > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) { // tow children
            t.element = findMin(t.right).element;
            t.right = remove(x, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    private BinaryNode removeMin(BinaryNode t) {
        return null;
    }

    private void printTree(BinaryNode t) {
    }

}
