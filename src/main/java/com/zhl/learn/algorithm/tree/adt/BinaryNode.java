package com.zhl.learn.algorithm.tree.adt;

public class BinaryNode {

    // Consturctors
    BinaryNode(Comparable theElement) {

    }

    BinaryNode(Comparable theElement, BinaryNode lt, BinaryNode rt) {
        element = theElement;
        left = lt;
        right = rt;
    }
    
    Comparable element; // the data in the node
    BinaryNode left; // left child
    BinaryNode right; // right child

}
