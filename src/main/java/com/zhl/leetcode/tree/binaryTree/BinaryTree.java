package com.zhl.leetcode.tree.binaryTree;

import java.util.List;

/**
 * @ClassName BinaryTree
 * @Description TODO
 * @Author yuguang
 * @Date 2021/7/1 10:03 上午
 * @Version 1.0
 **/
public class BinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public void preOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		// 根
		System.out.println(root.val);
		// 左
		preOrderTraversal(root.left);
		// 右
		preOrderTraversal(root.right);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		//           1
		//      3        2
		//  4      5  6     7
		TreeNode t_4 = new TreeNode(4, null, null);
		TreeNode t_5 = new TreeNode(5, null, null);
		TreeNode t_3 = new TreeNode(3, t_4, t_5);

		TreeNode t_6 = new TreeNode(6, null, null);
		TreeNode t_7 = new TreeNode(7, null, null);
		TreeNode t_2 = new TreeNode(2, t_6, t_7);

		TreeNode t_1 = new TreeNode(1, t_3, t_2);

		tree.preOrderTraversal(t_1);
	}

}


//
//public void preOrder(TreeNode root, List<Integer> res) {
//		if (root == null)
//		return;
//		//先打印当前节点，然后打印左子树，最后再打印右子树
//		res.add(root.val);
//		preOrder(root.left, res);
//		preOrder(root.right, res);
//		}
//		看一下运行结果
