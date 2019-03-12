package com.qihoo.zhuhailong.dataStructure.tree;

import java.util.List;

/**
 * 计算二叉/多叉树的高度
 */
public class Depth {

    /**
     * 伪代码：
     */

    private static Integer abs = - 1;

    public static void main(String[] args) {
        // 构造测试数据
        BinaryNode node = new BinaryNode(0);
        BinaryNode node1 = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);

        node5.left = node4;
        node3.left = node5;

        node1.left = node3;
        node1.right = node4;

        node.left = node1;
        node.right = node2;

        // depth(node, 0);
        System.out.println("the depth is " + abs);
    }

    /**
     * 方法3：多叉树
     */
    private void depth(Node node, int deep) {
        if (node.children.isEmpty()) {
            abs = Math.max(abs, deep);
            return;
        } else {
            for (int i = 0; i < node.children.size(); i++) {
                depth(node.children.get(i), deep + 1);
            }
        }
    }

    /**
     * 方法2：depth(node, 0); 先遍历左树,如果左数最深,则返回abs，否则继续向下遍历右树
     */
    public static void depth(BinaryNode node, Integer deep) {
        if (node == null) {
            abs = Math.max(abs, deep);
            return;
        } else {
            depth(node.left, deep + 1);
            depth(node.right, deep + 1);
        }
    }

    /**
     * 方法1：先遍历左树,在遍历右树,最后比较两颗树的高度
     */
    public static void depthLeft(BinaryNode node, Integer deep) {
        if (node.left == null) {
            abs = Math.max(abs, deep);
            return;
        } else {
            depthLeft(node.left, deep + 1);
        }
    }

    public static void depthRight(BinaryNode node, Integer deep) {
        if (node.right == null) {
            abs = Math.max(abs, deep);
            return;
        } else {
            depthRight(node.right, deep + 1);
        }
    }
}

class BinaryNode {

    int data;
    BinaryNode left, right;

    public BinaryNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Node {

    int data;
    List<Node> children;
}