// 
// Author: 
// Date  : June 20, 2019

package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
	// fields here. 
	//	private int count;

	public MinimumDepthOfBinaryTree() {
		// Initialization here. 
		//		this.count = 0;
	}

	// 1. Recursive. 
	// O(N) time, we visit every node once. 
	// O(logN) space if it's balanced, O(N) if it's not balanced, because of the recursion stack. 
	public int minDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftDepth = minDepth(node.left);
		int rightDepth = minDepth(node.right);

		// If node only has one child, then the depth is 2, not 1. 
		// So we cannot just take minimum between left and right. 
		// 		left	 right			depth
		// 		null, 0	 not null		right + 1
		// 		not null null, 0		left + 1
		//		null, 0	 null, 0		1
		// 
		if (node.left == null || node.right == null) {
			return leftDepth + rightDepth + 1;
		}		
		int minDep = Math.min(leftDepth, rightDepth) + 1;

		return minDep;
	}

	// 2. BFS (Level-order). 
	// Find the closest leaf node. 
	// O(N) time, where N is the total num of nodes, we visit every node once. 
	// O(N) space, because of the size of the queue. 
	public int minDepthBfs(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		// option 2. If the leftmost node has no child, then we can 
		// return faster. 
//		int depth = 1; 
		int depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			// For each level. 
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				
				// option 2. 
				// If the node has no child node, then the depth is 
				// the minimum depth. 
//				if (node.left == null && node.right == null) {
//					return depth;
//				}

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}				
			}

			depth++;
		}

		return depth;
	}



	// other classes here. 


	// For testing. 
	public static void main(String[] args) {
		MinimumDepthOfBinaryTree solution = new MinimumDepthOfBinaryTree();

		// Test arguments. 
		//	    int num = 24;
		//	    int target = 2;
		//	    solution.getInt(num, target);

		// Binary Tree
		//  1
		//   \
		//    2 
		//   /
		//  3
		BinaryTree binaryTree = new BinaryTree();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		binaryTree.root = n1;
		n1.right = n2;
		n2.left = n3;
		System.out.println(solution.minDepthBfs(binaryTree.root)); // 3

		// Binary Tree
		//    4		
		//   / \
		// null null
		BinaryTree binaryTree2 = new BinaryTree();
		TreeNode n4 = new TreeNode(4);
		binaryTree2.root = n4;
		System.out.println(solution.minDepthBfs(binaryTree2.root)); // 1


	}

}















