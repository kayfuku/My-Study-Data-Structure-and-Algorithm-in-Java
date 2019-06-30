// 
// Author: 
// Date  : June 22, 2019

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	// fields here. 
//	private int count;
	
	public ConstructBinaryTreeFromPreorderAndInorderTraversal() {
		// Initialization here. 
//		this.count = 0;
	}
		
	// Pre-order always starts from root, but for in-order, every node could be a root node. 
	// If I find which is the root in in-order, then I get to know every node to the left of 
	// the root is in the left subtree because that is the property of in-order. 
	// Author: yavinci
    // Data  : June 22, 2019
	// O(N) time, where N is the total number of nodes. 
	// O(logN) space for balanced, O(N) space for not balanced. 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	// To find a root in in-order. 
    	Map<Integer, Integer> inMap = new HashMap<>();
    	
    	for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
    	
    	TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    	return root;
    }
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, 
    		                   int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
    	// Note that we have to keep going when preStart == preEnd (just one elem). 
    	if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
    	
    	// Find a root in preorder.
    	TreeNode root = new TreeNode(preorder[preStart]);
    	// Find a root in inorder. 
    	int inRoot = inMap.get(root.val);
    	// Find left-subtree and right-subtree in inorder. 
    	int numsLeft = inRoot - inStart;
    	
    	// Build left subtree. 
    	root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
    	// Build right subtree. 
    	root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
    	
		return root;
	}
	
	// other classes here. 

    
    

	// For testing. 
	public static void main(String[] args) {
	    ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
	    
	    
	}

}















