package com.zhl.leetcode.tree.BST;

/**
 * @ClassName InsertBST
 * @Description TODO
 * @Author yuguang
 * @Date 2021/7/20 10:08 下午
 * @Version 1.0
 **/
public class InsertBST {
	public ValidBST.TreeNode insertIntoBST(ValidBST.TreeNode root, int val) {
		if (root == null) {
			return new ValidBST.TreeNode(val);
		}
		if (val > root.val) {
			root.right = insertIntoBST(root.right, val);
		} else {
			root.left = insertIntoBST(root.left, val);
		}
		return root;
	}

	public static void main(String[] args) {
		ValidBST.TreeNode t1 = new ValidBST.TreeNode(1, null, null);
		ValidBST.TreeNode t3 = new ValidBST.TreeNode(3, null, null);
		ValidBST.TreeNode t2 = new ValidBST.TreeNode(2, t1, t3);

		ValidBST.TreeNode t7 = new ValidBST.TreeNode(7, null, null);

		ValidBST.TreeNode t4 = new ValidBST.TreeNode(4, t2, t7);

		InsertBST bst = new InsertBST();
		ValidBST.TreeNode root = bst.insertIntoBST(t4, 5);
		System.out.println(root.val);
	}
}
