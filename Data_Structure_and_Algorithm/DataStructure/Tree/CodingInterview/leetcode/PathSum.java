// 
// Author: 
// Date  : June 24, 2019

package leetcode;

public class PathSum {
	// fields here. 
//	private int count;
	
	public PathSum() {
		// Initialization here. 
//		this.count = 0;
	}
		
	// 1. Recursive. 
	// O(N) time, O(logN) space for balanced, O(N) space for not balanced. 
    public boolean hasPathSum(TreeNode node, int sum) {
    	if (node == null) {
			return false;
		}
    	if (node.left == null && node.right == null) {
			return node.val == sum;
		}
    	
    	boolean hasPathSumL = hasPathSum(node.left, sum - node.val);
    	boolean hasPathSumR = hasPathSum(node.right, sum - node.val);
    	
    	return hasPathSumL || hasPathSumR;
    }
	
	
	// other classes here. 

    
    // For testing. 
	public static void main(String[] args) {
	    PathSum solution = new PathSum();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
	    
	    
	}

}















