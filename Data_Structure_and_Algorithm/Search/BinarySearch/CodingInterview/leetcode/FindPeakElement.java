// 
// Author: 
// Date  : June 12, 2019

package leetcode;

public class FindPeakElement {
	// fields here. 
//	private int count;
	
	public FindPeakElement() {
		// Initialization here. 
//		this.count = 0;
	}
	
	// other classes here. 
	
	// Binary Search. 
	// O(logN) time, O(1) space. 
	public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
//        int r = nums.length; // NG! index out of bound. 
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) { 
            	// Search left subarray. 
            	// Peak could be mid. We need to include mid. 
            	right = mid;
            } else {
            	// Search right subarray. 
            	left = mid + 1;
            }
        }
        // We need to verify how the mid moves in the cases where 
        // the target is the first, the last, the second, or the second to last element. 
        return left;
    }

    
    // For testing. 
	public static void main(String[] args) {
	    FindPeakElement solution = new FindPeakElement();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    int[] nums = new int[]{ 1, 2, 1, 3, 5, 6, 4 };
	    System.out.println(solution.findPeakElement(nums)); // 5
	    nums = new int[]{ 1, 2, 3, 4, 5, 6, 8 };
	    System.out.println(solution.findPeakElement(nums)); // 6
	    nums = new int[]{ 2 };
	    System.out.println(solution.findPeakElement(nums)); // 0

	    
	}

}















