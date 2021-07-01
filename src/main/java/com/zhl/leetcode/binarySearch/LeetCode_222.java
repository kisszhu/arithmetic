package com.zhl.leetcode.binarySearch;


/**
 * @ClassName LeetCode_222
 * @Description TODO
 * @Author yuguang
 * @Date 2021/6/23 8:35 上午
 * @Version 1.0
 **/
public class LeetCode_222 {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode() {

		}

		public TreeNode(int val) {
			this.val = val;
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int level = 0;
		TreeNode node = root;
		while (node.left != null) {
			level++;
			node = node.left;
		}

		int mid = 0;
		int left = 1 << level;
		int right = (1 << (level + 1)) - 1;
		while (left < right) {
			mid = (right - left + 1) / 2 + left;
			if (exists(root, level, mid)) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return mid;
	}

	public boolean exists(TreeNode root, int level, int k) {
		int bits = 1 << (level - 1);
		TreeNode node = root;
		while (node != null && bits > 0) {
			if ((bits & k) == 0) {
				node = node.left;
			} else {
				node = node.right;
			}
			bits >>= 1;
		}
		return node != null;
	}

	public static void main(String[] args) {
		LeetCode_222 test = new LeetCode_222();
		TreeNode left4 = new TreeNode(4);
		TreeNode right5 = new TreeNode(5);
		TreeNode left2 = new TreeNode(2, left4, right5);

		TreeNode left6 = new TreeNode(6);
		TreeNode right7 = new TreeNode(7);
		TreeNode right3 = new TreeNode(3, null, null);
		TreeNode root = new TreeNode(1, left2, right3);

		System.out.println(test.countNodes(root));
	}
}

