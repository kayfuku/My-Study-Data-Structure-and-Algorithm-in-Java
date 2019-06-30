// 
// Author: 
// Date  : June 20, 2019

package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {
	// fields here. 
//	private int count;
	
	public MaximumDepthOfBinaryTree() {
		// Initialization here. 
//		this.count = 0;
	}
		
	// 1. Recursive (DFS). 
	// O(N) time, we visit every node once. 
	// O(logN) space if it's balanced, O(N) if it's not balanced, because of the recursion stack. 
    public int maxDepth(TreeNode node) {
    	if (node == null) {
			return 0;
		}
    	
    	int leftDepth = maxDepth(node.left);
    	int rightDepth = maxDepth(node.right);
    	int maxDep = Math.max(leftDepth, rightDepth) + 1;
    	
    	return maxDep;
    }
    
    // 2. Iterative (DFS). 
	// O(N) time, where N is the total num of nodes, we visit every node once. 
	// O(N) space, because of the size of the stack. 
    public int maxDepthIterDfs(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	
    	Stack<TreeNode> stackNode = new Stack<>();
    	Stack<Integer> stackDep = new Stack<>();
    	
    	stackNode.push(root);
    	stackDep.push(1);
    	
    	int maxDep = 0;
    	while (!stackNode.isEmpty()) {
			TreeNode node = stackNode.pop();
			int curDep = stackDep.pop();
			
			maxDep = Math.max(maxDep, curDep);
			
			if (node.right != null) {
				stackNode.push(node.right);
				stackDep.push(curDep + 1);
			}
			if (node.left != null) {
				stackNode.push(node.left);
				stackDep.push(curDep + 1);
			}
		}
    	
    	return maxDep;
    }
    
    // 3. Iterative (BFS). Level-order. 
	// O(N) time, where N is the total num of nodes, we visit every node once. 
	// O(N) space, because of the size of the queue. 
    public int maxDepthIterBfs(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	
    	int depth = 0;
    	while (!queue.isEmpty()) {
    		
    		int levelSize = queue.size();
    		for (int i = 0; i < levelSize; i++) {
    			TreeNode node = queue.poll();
        		
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
	    MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
	    
	    
	}

}















