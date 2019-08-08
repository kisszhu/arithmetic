package com.zhl.learn.dataStructure.tree.avl;


public class AvlNode {

    AvlNode(Comparable theElement) {
        this(theElement, null, null);
    }

    AvlNode(Comparable theElement, AvlNode lt, AvlNode rt) {
        element = theElement;
        left = lt;
        right = rt;
        height = 0;
    }

    Comparable element; // the data in the node
    AvlNode left;
    AvlNode right;
    int height;

}
