// 
// Author: 
// Date  : June 12, 2019

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeIterator {
	// fields here. 
//	private int count;
	
	public BinarySearchTreeIterator() {
		// Initialization here. 
//		this.count = 0;
	}
	
	
	// 1. Flattening the BST. 
	// next(): O(1) time, hasNext(): O(1) time
	// O(N) space. 
	class BSTIterator {
		
		List<Integer> inorderNodes;
		int index;

	    public BSTIterator(TreeNode root) {
	    	inorderNodes = new ArrayList<>();
	    	index = -1;
	    	
	    	createInorderArray(root);
	    }
	    
	    private void createInorderArray(TreeNode node) {
	    	if (node == null) {
				return;
			}
	    	
	    	createInorderArray(node.left);
	    	inorderNodes.add(node.val);
	    	createInorderArray(node.right);
		}

		/** @return the next smallest number */
	    public int next() {
	    	index++;
	    	return inorderNodes.get(index);
	    }
	    
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	    	return index + 1 < inorderNodes.size();
	    }
	}

	
	/**
	 * 2. Controlled Recursion. 
	 * next(): Amortized O(1) time, hasNext(): O(1) time. 
	 * 
	 * https://leetcode.com/problems/binary-search-tree-iterator/solution/
	 * 
	 * next() involves two major operations. One is where we pop an element from the stack which 
	 * becomes the next smallest element to return. This is a O(1) operation. However, 
	 * we then make a call to our helper function addLeftmostNodes which iterates over a bunch of nodes. 
	 * This is clearly a linear time operation i.e. O(N) in the worst case. This is true. 
     * However, the important thing to note here is that we only make such a call for nodes which 
     * have a right child. Otherwise, we simply return. Also, even if we end up calling the helper function, 
     * it won't always process N nodes. They will be much lesser. Only if we have a skewed tree 
     * would there be N nodes for the root. But that is the only node for which we would call the helper function.
     * Thus, the amortized (average) time complexity for this function would still be O(1). 
     * 
     * O(h) space, where h is the height of the tree, which is also the size of the stack we use. 
	 */
	class BSTIterator2 {
		
		LinkedList<TreeNode> stack;

	    public BSTIterator2(TreeNode root) {
	    	stack = new LinkedList<>();
	    	
	    	addLeftmostNodes(root);	        
	    }
	    
        // For a given node, add all the elements in the leftmost branch of the tree. 
	    private void addLeftmostNodes(TreeNode node) {
	    	while (node != null) {
				stack.push(node);
				node = node.left;
	    	}
		}

		/** @return the next smallest number */
	    public int next() {
	        TreeNode node = stack.poll();
	    	
	        if (node.right != null) {
				addLeftmostNodes(node.right);
			}
	    	
	    	return node.val;
	    }
	    
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	    	return stack.size() > 0;
	    }
	}
	
	
	/**
	 * Your BSTIterator object will be instantiated and called as such:
	 * BSTIterator obj = new BSTIterator(root);
	 * int param_1 = obj.next();
	 * boolean param_2 = obj.hasNext();
	 */

    
    // For testing. 
	public static void main(String[] args) {
	    BinarySearchTreeIterator solution = new BinarySearchTreeIterator();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
	    
	    
	}

}















