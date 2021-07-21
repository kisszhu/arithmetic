package com.zhl.leetcode.tree.BST;

/**
 * @ClassName DeleteBST
 * @Description TODO
 * @Author yuguang
 * @Date 2021/7/20 10:48 下午
 * @Version 1.0
 **/
public class DeleteBST {
	public ValidBST.TreeNode deleteNode(ValidBST.TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else {
			if (root.left == null && root.right == null) {
				// 当前节点的左右节点都为空
				root = null;
			} else if (root.right == null) {
				root = root.left;
			} else if (root.left == null) {
				root = root.right;
			} else {
				ValidBST.TreeNode cur = root.right;
				while (cur.left != null) {
					cur = cur.left;
				}
				root.val = cur.val;
				root.right = deleteNode(root.right, root.val);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		ValidBST.TreeNode t9 = new ValidBST.TreeNode(9, null, null);
		ValidBST.TreeNode t20 = new ValidBST.TreeNode(20, null, null);
		ValidBST.TreeNode t15 = new ValidBST.TreeNode(15, t9, t20);


		ValidBST.TreeNode t3 = new ValidBST.TreeNode(3, null, null);

		ValidBST.TreeNode t7 = new ValidBST.TreeNode(7, t3, t15);

		DeleteBST bst = new DeleteBST();
		System.out.println(bst.deleteNode(t7, 15));
	}
}
