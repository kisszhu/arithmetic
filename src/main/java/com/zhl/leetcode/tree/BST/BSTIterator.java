package com.zhl.leetcode.tree.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BSTIterator
 * @Description TODO
 * @Author yuguang
 * @Date 2021/7/20 6:26 下午
 * @Version 1.0
 **/
public class BSTIterator {

	public BSTIterator(ValidBST.TreeNode root) {
		dfs(root);
	}

	List<Integer> list = new ArrayList<>();
	Integer position = 0;

	public void dfs(ValidBST.TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		list.add(root.val);
		dfs(root.right);
	}

	public int next() {
		Integer num = list.get(position);
		position++;
		return num;
	}

	public boolean hasNext() {
		if (list.size() > position) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ValidBST.TreeNode t9 = new ValidBST.TreeNode(9, null, null);
		ValidBST.TreeNode t20 = new ValidBST.TreeNode(20, null, null);
		ValidBST.TreeNode t15 = new ValidBST.TreeNode(15, t9, t20);


		ValidBST.TreeNode t3 = new ValidBST.TreeNode(3, null, null);

		ValidBST.TreeNode t7 = new ValidBST.TreeNode(7, t3, t15);
		BSTIterator iterator = new BSTIterator(t7);

		// 返回 3
		System.out.println(iterator.next());
		// 返回 7
		System.out.println(iterator.next());
		// 返回 True
		System.out.println(iterator.hasNext());
		// 返回 9
		System.out.println(iterator.next());
		// 返回 True
		System.out.println(iterator.hasNext());
		// 返回 15
		System.out.println(iterator.next());
		// 返回 True
		System.out.println(iterator.hasNext());
		// 返回 20
		System.out.println(iterator.next());
		// 返回 False
		System.out.println(iterator.hasNext());
	}
}
