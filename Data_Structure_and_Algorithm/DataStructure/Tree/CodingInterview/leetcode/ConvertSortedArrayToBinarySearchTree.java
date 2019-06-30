// 
// Author: 
// Date  : June 21, 2019

package leetcode;

public class ConvertSortedArrayToBinarySearchTree {
	// fields here. 
	//	private int count;

	public ConvertSortedArrayToBinarySearchTree() {
		// Initialization here. 
		//		this.count = 0;
	}

	// 1. Recursive. Accepted. 
	// O(N) time, O(N) space. 
	// Author: kei
	// Date  : June 21, 2019
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}
	private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		
		root.left = sortedArrayToBST(nums, left, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, right);

		return root;
	}


	// other classes here. 


	// For testing. 
	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree solution = new ConvertSortedArrayToBinarySearchTree();

		// Test arguments. 
		//	    int num = 24;
		//	    int target = 2;
		//	    solution.getInt(num, target);



	}

}















