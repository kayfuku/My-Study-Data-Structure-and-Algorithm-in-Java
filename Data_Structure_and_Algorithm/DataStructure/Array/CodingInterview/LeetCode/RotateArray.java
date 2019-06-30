// 
// Author: 
// Date  : June 13, 2019

package leetcode;

import java.util.Arrays;

public class RotateArray {
	// fields here. 
//	private int count;
	
	public RotateArray() {
		// Initialization here. 
//		this.count = 0;
	}
		
	// 1. Using Extra Array. 
	// O(N) time, O(N) space. 
    public void rotate(int[] nums, int k) {
    	int[] rotated = new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
			rotated[(i + k) % nums.length] = nums[i];    		
		}
    	
    	for (int i = 0; i < rotated.length; i++) {
			nums[i] = rotated[i];
		}
    }
    
    
    /**
     * 2. Using Reverse. 
     * O(N) time, O(1) space. 
     * n elements are reversed twice.
     */
    public void rotate2(int[] nums, int k) {
    	k %= nums.length;
    	reverse(nums, 0, nums.length - 1);
    	reverse(nums, 0, k - 1);
    	reverse(nums, k, nums.length - 1);   	
    }

    private void reverse(int[] nums, int left, int right) {
    	while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
    		right--;
		}
	}
    
    // too complicated. 
//    /**
//     * 2. In-place replacement. 
//     * O(N) time, O(1) space.  
//     */
//    public void rotate2(int[] nums, int k) {
//    	
//    	int cur = 0, next = 0;
//    	int temp1 = 0, temp2 = nums[cur];
//    	for (int i = 0; i < nums.length; i++) {
//    		next = (cur + k) % nums.length;
//    		// temp1 gets replacing elem. 
//    		temp1 = temp2;
//			// Place the replacing elem in the correct position. 
//    		temp2 = nums[next];
//    		nums[next] = temp1;
//    		cur = next;
//		}
//    	
//    }

	
	// other classes here. 

    
    

	// For testing. 
	public static void main(String[] args) {
	    RotateArray solution = new RotateArray();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
//	    int[] nums = new int[]{ 1, 2, 3, 4, 5 };
//	    solution.rotate2(nums, 3);
//	    System.out.println(Arrays.toString(nums));
	    int[] nums = new int[]{ 1, 2, 3, 4, 5, 6 };
	    solution.rotate2(nums, 2);
	    System.out.println(Arrays.toString(nums));

	}

}















