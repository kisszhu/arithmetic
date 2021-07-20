package com.zhl.leetcode.tree.BST;

import java.util.ArrayList;

/**
 * @ClassName BST
 * @Description TODO
 * @Author yuguang
 * @Date 2021/7/18 11:06 上午
 * @Version 1.0
 **/
public class ValidBST {

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

	public static void main(String[] args) {
		TreeNode t_3 = new TreeNode(3, null, null);
		TreeNode t_6 = new TreeNode(6, null, null);
		TreeNode t_4 = new TreeNode(4, t_3, t_6);

		TreeNode t_1 = new TreeNode(1, null, null);
		TreeNode t_5 = new TreeNode(5, t_1, t_4);
		System.out.println(new ValidBST().isValidBST(t_5));
	}

	public boolean isValidBST(TreeNode root) {
		ArrayList<TreeNode> list = new ArrayList<>();
		dfs(root, list);
		if (list.size() == 1) {
			return true;
		}
		for (int i = 1; i <= list.size(); i++) {
			if (list.get(i - 1).val >= list.get(i).val) {
				return false;
			}
		}
		return true;
	}

	private void dfs(TreeNode treeNode, ArrayList<TreeNode> treeNodes) {
		if (treeNode == null) {
			return;
		}
		dfs(treeNode.left, treeNodes);
		treeNodes.add(treeNode);
		dfs(treeNode.right, treeNodes);
	}
}
