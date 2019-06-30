// 
// Author: 
// Date  : June 1, 2019

package leetcode;

import java.util.LinkedList;
import java.util.Stack;


public class ValidateBinarySearchTree {
	// fields here. 
	//	private int count;

	public ValidateBinarySearchTree() {
		// Initialization here. 
		//		this.count = 0;
	}

	// other classes here. 

	// BST is a special binary tree that all the descendants to the left of a node are 
	// less than or equal to the node, and all the descendants to the right of the node are 
	// greater than or equal to the node. 

	// 1. Lower/Upper Approach (Recursive). 
	// O(N) time, since we visit each node exactly once.
	// O(N) space for tree structure. 
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
		// This does not work when node.val has Integer.MIN_VALUE or Integer.MAX_VALUE!
		//return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
		if (node == null) {
			// Return true. Think about just one node case. 
			// If the left and right child is null, then it should return true. 
			return true;
		}

		// Preorder/DFS traversal because I can check validity as soon as I get to the node. 
		// Check validity. 
		// null check lower, not node. Include equal. 
		// If lower(upper) is null, then any number is ok, including -2147483648(2147483647). 
		if (lower != null && node.val <= lower) {
			return false;
		}
		if (upper != null && node.val >= upper) {
			return false;
		}

		// Update upper by current node value when going down left subtree. 
		// Update lower by current node value when going down right subtree. 
		return isValidBST(node.left, lower, node.val) && 
				isValidBST(node.right, node.val, upper);
	}


	// 2. Lower/Upper Approach (Iterative). 
	// O(N) time, since we visit each node exactly once.
	// O(N) space for tree structure. 
	LinkedList<TreeNode> stackNodes = new LinkedList<>(); 
	LinkedList<Integer>	stackMin = new LinkedList<>(), stackMax = new LinkedList<>();

	private void update(TreeNode node, Integer lower, Integer upper) {
		stackNodes.push(node);
		stackMin.push(lower);
		stackMax.push(upper);    	
	}

	public boolean isValidBST2(TreeNode node) {    
		if (node == null) {
			return true;
		}

		Integer lower = null, upper = null;
		// NG!
		//Integer min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

		// Preorder/DFS traversal because I can check validity as soon as I get to the node. 
		// Push the state first. 
		update(node, lower, upper);
		while (!stackNodes.isEmpty()) {
			// Get the state. 
			node = stackNodes.poll();
			lower = stackMin.poll();
			upper = stackMax.poll();

			// Check validity. 
			// null check lower, not node. Include equal. 
			// If lower(upper) is null, then any number is ok, including -2147483648(2147483647). 
			if (lower != null && node.val <= lower) {
				return false;
			}
			if (upper != null && node.val >= upper) {
				return false;
			}

			if (node.right != null) {
				update(node.right, node.val, upper);
			}
			if (node.left != null) {
				update(node.left, lower, node.val);
			}

		}

		return true;
	}


	// 3. Inorder Approach (Iterative). 
	// O(N) time, since we visit each node exactly once.
	// O(N) space for tree structure. 
	public boolean isValidBST3(TreeNode node) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		Integer prev = null;

		// Inorder Traversal. 
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			node = stack.poll();
			// Check validity. 
			// If prev is null, any number is ok including -2147483648. 
			if (prev != null && node.val <= prev) {
				return false;
			}

			prev = node.val;
			node = node.right;
		}

		return true;
	}


	// Review
	// Recursive. Accepted. 
	public boolean isValidBSTRecurR(TreeNode node) {
		// corner, node: null, 1 node => ok. 

		// Pass in nulls in order to validate leftmost and rightmost node. 
		return isValidBSTRecurR(node, null, null);
	}
	private boolean isValidBSTRecurR(TreeNode node, Integer lower, Integer upper) {
		if (node == null) {
			return true;
		}

		// Check validity. 
		if (lower != null && node.val <= lower) {
			return false;
		} 
		if (upper != null && node.val >= upper) {
			return false;
		} 

		return isValidBSTRecurR(node.left, lower, node.val) &&
				isValidBSTRecurR(node.right, node.val, upper); 
	}


	// Iterative. Accepted. 
	Stack<TreeNode> stackNode = new Stack<>();
	Stack<Integer> stackLower = new Stack<>(), stackUpper = new Stack<>(); 
	private void pushState(TreeNode node, Integer lower, Integer upper) {
		stackNode.push(node);
		stackLower.push(lower);
		stackUpper.push(upper);
	}

	public boolean isValidBSTIterR(TreeNode root) {
		// corner.
		if (root == null) {
			return true;
		}

		pushState(root, null, null);
		while (!stackNode.isEmpty()) {
			TreeNode node = stackNode.pop();
			Integer lower = stackLower.pop();
			Integer upper = stackUpper.pop();
			
			// Check validity.  
			if (lower != null && node.val <= lower) {
				return false;
			}

			if (upper != null && node.val >= upper) {
				return false;
			}


			if (node.right != null) {
				pushState(node.right, node.val, upper);
			}

			if (node.left != null) {
				pushState(node.left, lower, node.val);
			}
		}

		return true;
	}





	// For testing. 
	public static void main(String[] args) {
		ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

		// Test arguments. 
		//	    int num = 24;
		//	    int target = 2;
		//	    solution.getInt(num, target);

		// Binary Search Tree
		//       6
		//     /   \
		//    3     12 
		//   / \   /  \
		//  1   4 9   14
		BinaryTree bst = new BinaryTree();
		TreeNode n1 = new TreeNode(6);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(12);
		TreeNode n6 = new TreeNode(9);
		TreeNode n7 = new TreeNode(14);

		bst.root = n1;
		n1.setLeft(n2);
		n1.setRight(n5);
		n2.setLeft(n3);
		n2.setRight(n4);
		n5.setLeft(n6);
		n5.setRight(n7);

		boolean ret = solution.isValidBST(bst.root);
		System.out.println(ret); // true

		// This is not a Binary Search Tree. 
		//       6
		//     /   \
		//    3     12 
		//   / \   /  \
		//  1   7 9   14
		BinaryTree notBst = new BinaryTree();
		notBst.root = n1;
		TreeNode n8 = new TreeNode(7);
		n1.setLeft(n2);
		n1.setRight(n5);
		n2.setLeft(n3);
		n2.setRight(n8);
		n5.setLeft(n6);
		n5.setRight(n7);

		ret = solution.isValidBST(notBst.root);
		System.out.println(ret); // false

	}

}















