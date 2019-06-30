// 
// Author: 
// Date  : June 3, June 12 2019

package leetcode;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.RootPaneContainer;

public class BinaryTreeLevelOrderTraversal {
	// fields here. 
//	private int count;
	
	public BinaryTreeLevelOrderTraversal() {
		// Initialization here. 
//		this.count = 0;
	}
	
	// other classes here. 
	
	// 1. Level order traversal (BFS, Iterative). 
	// O(N) time, O(N) space. 
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (root == null) {
			return result;
		}
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	
    	while (!queue.isEmpty()) {
    		// For each level. 
    		List<Integer> valsL = new ArrayList<>();
			int size = queue.size();
			// Prepare for the next level. 
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				// Do something here. 
				valsL.add(node.val);
				
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			
    		result.add(valsL);
		}
    	
    	return result;
    }
    
    // 2. Level order traversal (DFS, Recursive).
    // O(N) time, O(logN) (balanced) or O(N) (not balanced) space. 
    public List<List<Integer>> levelOrderDfs(TreeNode root) {
    	List<List<Integer>> ret = new ArrayList<>();
    	if (root == null) {
			return ret;
		}
    	levelOrderDfsHelper(root, 0, ret);
    	return ret;
    }
	private void levelOrderDfsHelper(TreeNode node, int level, List<List<Integer>> ret) {
		if (node == null) {
			return;
		}
		if (ret.size() <= level) {
			ret.add(new ArrayList<Integer>());
		}
		ret.get(level).add(node.val);
		
		levelOrderDfsHelper(node.left, level + 1, ret);
		levelOrderDfsHelper(node.right, level + 1, ret);
	}

	// Level order traversal. Accepted. 
	// O(N) time, O(N) space. 
    public List<List<Integer>> levelOrder2(TreeNode node) {
    	List<List<Integer>> ans = new LinkedList<List<Integer>>();
    	
		if (node == null) {
			return ans;
		}
		
    	LinkedList<TreeNode> nodesAtLevel = new LinkedList<>();
    	nodesAtLevel.add(node);
		
		while (!nodesAtLevel.isEmpty()) {
			LinkedList<TreeNode> parents = nodesAtLevel;
			
			nodesAtLevel = new LinkedList<>();
			List<Integer> valsAtLevel = new ArrayList<>();
			for (TreeNode parent : parents) {	
				valsAtLevel.add(parent.val);
				
				if (parent.left != null) {
					nodesAtLevel.add(parent.left);
				}
				if (parent.right != null) {
					nodesAtLevel.add(parent.right);
				}				
			}	
			
			ans.add(valsAtLevel);
		}    	
    	
    	return ans;
    }

    
    // For testing. 
	public static void main(String[] args) {
	    BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
	    
	    
	}

}















