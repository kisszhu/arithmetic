package com.zhl.leetcode.tree.BST;

/**
 * @ClassName SearchBST
 * @Description TODO
 * @Author yuguang
 * @Date 2021/7/20 6:58 下午
 * @Version 1.0
 **/
public class SearchBST {
	public ValidBST.TreeNode searchBST(ValidBST.TreeNode root, int val) {
		if (root == null) {
			return null;
		}

		if (root.val == val) {
			return root;
		}

		if (val < root.val) {
			return searchBST(root.left, val);
		} else {
			return searchBST(root.right, val);
		}
	}

	public static void main(String[] args) {
		ValidBST.TreeNode t9 = new ValidBST.TreeNode(9, null, null);
		ValidBST.TreeNode t20 = new ValidBST.TreeNode(20, null, null);
		ValidBST.TreeNode t15 = new ValidBST.TreeNode(15, t9, t20);


		ValidBST.TreeNode t3 = new ValidBST.TreeNode(3, null, null);

		ValidBST.TreeNode t7 = new ValidBST.TreeNode(7, t3, t15);

		SearchBST bst = new SearchBST();
		System.out.println(bst.searchBST(t7, 20));
	}
}
