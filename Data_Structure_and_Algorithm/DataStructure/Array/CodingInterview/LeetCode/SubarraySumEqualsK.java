// 
// Author: 
// Date  : June 26, 2019

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	// fields here. 
//	private int count;
	
	public SubarraySumEqualsK() {
		// Initialization here. 
//		this.count = 0;
	}
		
	
	// 1. Brute Force. 
	// Consider every possible subarrays from i to j. 
	// O(N^3) time, where N is the array length, because considering every possible 
	// subarray takes O(N^2) time, and for each of the subarray, calculating the sum 
	// takes O(N) time. 
	// O(1) space. 

	
	// 2. Cumulative Sum. (No need, move on to the Approach 3)
	// O(N^2) time. 
	// O(N) space. 
    public int subarraySum2(int[] nums, int k) {
    	int count = 0;
    	int[] cumuSum = new int[nums.length + 1];
    	cumuSum[0] = 0;
    	for (int i = 1; i <= nums.length; i++) {
    		cumuSum[i] = cumuSum[i - 1] + nums[i - 1];
		}
    	
    	for (int start = 0; start < cumuSum.length; start++) {
			for (int end = start + 1; end < cumuSum.length; end++) {
				if (cumuSum[end] - cumuSum[start] == k) {
					count++;
				}
			}
		}
    	
    	return count;
    }
    
    // 3. Cumulative Sum without cumulative sum array. 
    // O(N^2) time. 
    // O(1) space. 
    public int subarraySum3(int[] nums, int k) {
    	int count = 0;
    	for (int i = 0; i < nums.length; i++) {
    		int sum = 0;
    		for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k) {
					count++;
				}
			}
		}
    	
    	return count;
    }

    // 4. Cumulative Sum using HashMap. 
    // For every sum encountered, we determine the number of times the sum (sum - k) 
    // has occured already, since it will determine the number of times a subarray with sum k
    // has occured upto the current index.
    // O(N) time. 
    // O(N) space. 
    public int subarraySum4(int[] nums, int k) {
    	int count = 0, sum = 0;
    	// K: sum, V: occurrences of the sum
    	Map<Integer, Integer> map = new HashMap<>();
    	map.put(0, 1);
    	for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
    		if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
    		map.put(sum, map.getOrDefault(sum, 0) + 1);    		
		}
    	
    	return count;
    }

	
	// other classes here. 

    
    // For testing. 
	public static void main(String[] args) {
	    SubarraySumEqualsK solution = new SubarraySumEqualsK();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
	    
	    
	}

}















