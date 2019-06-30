// 
// Author: 
// Date  : June 11, 2019

package leetcode;

public class FindMinimumInRotatedSortedArray {
	// fields here. 
//	private int count;
	
	public FindMinimumInRotatedSortedArray() {
		// Initialization here. 
//		this.count = 0;
	}
	
	// other classes here. 
	
	// Binary Search. 
	// O(logN) time, O(1) space. 
    public int findMin(int[] nums) {
    	// corner
    	if (nums.length == 1) {
			return nums[0];
		}
    	
    	// Not rotated. 
    	if (nums[0] < nums[nums.length - 1]) {
			return nums[0];
		}
    	
    	// Binary Search. 
    	int left = 0;
    	int right = nums.length - 1;
//    	int right = nums.length;
    	while (left <= right) {
//        while (left < right) {
    		int mid = left + (right - left) / 2;
    		
    		if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
    		// mid - 1 could be array index out of bound when the target is the second to leftmost element. 
    		// However, in this problem, the code above returns when mid is equal to 0. 
    		// We can also use right = mid; version.  
    		if (nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}
    		
    		if (nums[mid] > nums[0]) {
    			// The min is in the right sub-array. 
				left = mid + 1;
			} else {
				// The min is in the left sub-array. 
				right = mid - 1;
//				right = mid;
			}
		}
    	
    	return -1;
    }

    
    // For testing. 
	public static void main(String[] args) {
	    FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
	    int[] nums = new int[]{ 3, 4, 5, 1, 2 };
	    System.out.println(solution.findMin(nums)); // 1
	    nums = new int[]{ 4, 5, 6, 7, 0, 1, 2 };
	    System.out.println(solution.findMin(nums)); // 0
	    nums = new int[]{ 7, 1, 2, 4, 5, 6 };
	    System.out.println(solution.findMin(nums)); // 1
	    nums = new int[]{ 1, 2, 4, 5, 6 };
	    System.out.println(solution.findMin(nums)); // 1
	    nums = new int[]{ 7 };
	    System.out.println(solution.findMin(nums)); // 7

	    
	    
	    
	    
	}

}















