package com.zhl.leetcode.tree.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BinaryTree
 * @Description TODO
 * @Author yuguang
 * @Date 2021/7/1 10:03 上午
 * @Version 1.0
 **/
public class BinaryTree {
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

		// 前序遍历
		tree.preorderTraversal(t_1);

		// 中序遍历
		tree.inorderTraversal(t_1);

		// 后序遍历
		tree.postorderTraversal(t_1);

		// 层序遍历
		int[] res = tree.levelOrder(t_1);

		// 路径总和
		System.out.println("路径总和：" + tree.hasPathSum(t_1, 8));

		// 找出二叉树的最大深度: 自底向上写法
		System.out.println("二叉树的最大深度 " + tree.maxDepth(t_1));
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return root.val == targetSum;
		}
		return hasPathSum(root.left, targetSum - root.val)
				|| hasPathSum(root.right, targetSum - root.val);
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	/**
	 * 层序遍历
	 *
	 * @param root
	 * @return
	 */
	public int[] levelOrder(TreeNode root) {
		if (root == null) {
			return new int[]{};
		}
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);

		List<Integer> list = new ArrayList<>();
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			for (int i = 0; i < levelNum; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
			System.out.println("层序遍历 " + list.get(i));
		}
		return res;
	}

	/**
	 * 前序遍历
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		preorderTraversal(root, list);

		for (Integer i : list) {
			System.out.println("前序遍历 " + i);
		}
		return list;
	}

	private List<Integer> preorderTraversal(TreeNode root, List<Integer> list) {
		// 跟左右
		if (root == null) {
			return null;
		}
		list.add(root.val);
		preorderTraversal(root.left, list);
		preorderTraversal(root.right, list);
		return list;
	}

	/**
	 * 中序遍历
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorderTraversal(root, list);
		for (Integer i : list) {
			System.out.println("中序遍历 " + i);
		}
		return list;
	}

	private List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null) {
			return null;
		}
		inorderTraversal(root.left, list);
		list.add(root.val);
		inorderTraversal(root.right, list);
		return list;
	}

	/**
	 * 后序遍历
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		postorderTraversal(root, list);
		return list;
	}

	private List<Integer> postorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null) {
			return null;
		}
		// 左
		postorderTraversal(root.left, list);
		// 右
		postorderTraversal(root.right, list);
		// 根
		list.add(root.val);
		return list;
	}

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

}