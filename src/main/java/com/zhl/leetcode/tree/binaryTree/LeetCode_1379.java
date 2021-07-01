package com.zhl.leetcode.tree.binaryTree;

/**
 * @ClassName LeetCode_1379
 * @Description TODO
 * @Author yuguang
 * @Date 2021/6/30 8:22 上午
 * @Version 1.0
 **/
public class LeetCode_1379 {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x, TreeNode left, TreeNode right) {
			this.left = left;
			this.right = right;
			this.val = x;
		}
	}

	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		return search(cloned, target);
	}

	public TreeNode search(TreeNode root, TreeNode target) {
		if (root == null) {
			return null;
		}
		if (root.val == target.val) {
			return root;
		}
		TreeNode res1 = search(root.left, target);
		TreeNode res2 = search(root.right, target);

		return res1 == null ? res2 : res1;
	}

	public static void main(String[] args) {
		TreeNode t_4 = new TreeNode(4, null, null);

		TreeNode t_6 = new TreeNode(6, null, null);
		TreeNode t_19 = new TreeNode(19, null, null);
		TreeNode t_3 = new TreeNode(3, t_6, t_19);
		TreeNode t_7 = new TreeNode(7, t_4, t_3);

		LeetCode_1379 test = new LeetCode_1379();
		System.out.println(test.getTargetCopy(t_7, t_7, t_3));
	}
}
