package com.zhl.leetcode.tree.binaryTree;

/**
 * @ClassName LeetCode_938
 * @Description TODO
 * @Author yuguang
 * @Date 2021/6/30 8:58 上午
 * @Version 1.0
 **/
public class LeetCode_938 {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {

		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}
		if (root.val > high) {
			return rangeSumBST(root.left, low, high);
		}
		if (root.val < low) {
			return rangeSumBST(root.right, low, high);
		}

		return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
	}

	public static void main(String[] args) {

		TreeNode t_3 = new TreeNode(3, null, null);
		TreeNode t_7 = new TreeNode(7, null, null);
		TreeNode t_5 = new TreeNode(5, t_3, t_7);

		TreeNode t_18 = new TreeNode(18, null, null);
		TreeNode t_15 = new TreeNode(15, null, t_18);

		TreeNode t_10 = new TreeNode(10, t_5, t_15);

		LeetCode_938 test = new LeetCode_938();
		System.out.println(test.rangeSumBST(t_10, 7, 15));
	}

}
