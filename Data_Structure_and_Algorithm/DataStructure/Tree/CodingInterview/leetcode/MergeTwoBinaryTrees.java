// 
// Author: 
// Date  : June 21, 2019

package leetcode;

import java.util.Stack;

public class MergeTwoBinaryTrees {
	// fields here. 
	//	private int count;

	public MergeTwoBinaryTrees() {
		// Initialization here. 
		//		this.count = 0;
	}

	// 1. Recursive. (Faster than approach 2 and 3)
	// O(m) time, where m is the number of overlapping nodes. 
	// O(logm) space for balanced, O(m) space for not balanced. 
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}

		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left); 
		t1.right = mergeTrees(t1.right, t2.right);

		return t1;
	}

	// 2. Iterative. Accepted. (Faster than approach 3)
	// O(m) time, where m is the number of overlapping nodes. 
	// O(logm) space for balanced, O(m) space for not balanced. 
	// Author: kei
	// Date  : June 21, 2019
	public TreeNode mergeTreesKei(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		
		Stack<TreeNode[]> stack = new Stack<>();
		stack.push(new TreeNode[]{ t1, t2 });

		while (!stack.isEmpty()) {
			TreeNode[] t = stack.pop();

			t[0].val += t[1].val;

			//		t1.left		t2.left
			//	1.	v			v		push t1 & t2
			//	2.	null		v		add t2 to t1 
			//	3.	v			null	do nothing because we use t1 as output.	
			//  4.	null		null	do nothing because we use t1 as output.
			if (t[0].left != null && t[1].left != null) {
				// Case 1. Keep going DFS. 
				stack.push(new TreeNode[]{ t[0].left, t[1].left });
			} else if (t[0].left == null && t[1].left != null) {	
				// Case 2. 
				t[0].left = t[1].left;
			} 
			// Case 3 or 4. 

			// For right child, do the same as left.  
			if (t[0].right != null && t[1].right != null) {
				// Case 1. Keep going DFS. 
				stack.push(new TreeNode[]{ t[0].right, t[1].right });
			} else if (t[0].right == null && t[1].right != null) {	
				// Case 2. 
				t[0].right = t[1].right;
			} 
			// Case 3 or 4. 
		}

		return t1;
	}

	// 3. Iterative. 
	// O(m) time, where m is the number of overlapping nodes. 
	// O(logm) space for balanced, O(m) space for not balanced. 
	// Author: @vinod23
	// Date  : June 21, 2019
	public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
		if (t1 == null)
			return t2;
		Stack < TreeNode[] > stack = new Stack < > ();
		stack.push(new TreeNode[] {t1, t2});
		while (!stack.isEmpty()) {
			TreeNode[] t = stack.pop();
			// This and the following is not really clear for me. 
			if (t[0] == null || t[1] == null) {
				continue;
			}
			t[0].val += t[1].val;
			if (t[0].left == null) {
				t[0].left = t[1].left;
			} else {
				stack.push(new TreeNode[] {t[0].left, t[1].left});
			}
			if (t[0].right == null) {
				t[0].right = t[1].right;
			} else {
				stack.push(new TreeNode[] {t[0].right, t[1].right});
			}
		}
		return t1;
	}


	// other classes here. 


	// For testing. 
	public static void main(String[] args) {
		MergeTwoBinaryTrees solution = new MergeTwoBinaryTrees();

		// Test arguments. 
		//	    int num = 24;
		//	    int target = 2;
		//	    solution.getInt(num, target);



	}

}















