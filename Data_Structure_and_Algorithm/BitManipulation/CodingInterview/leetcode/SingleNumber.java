// 
// Author: 
// Date  : June 11, 2019

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	// fields here. 
	//	private int count;

	public SingleNumber() {
		// Initialization here. 
		//		this.count = 0;
	}

	// other classes here. 


	// Bit manipulation. 
	// 1. If we take XOR of zero and some bit, it will return that bit. 
	//	    a ^ 0 = a
	// 2. If we take XOR of two same bits, it will return 0. 
	//	    a ^ a = 0
	// 3. Associative: a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
	// So we can XOR all bits together to find the unique number.
	// XOR cancels out duplicates. 
	// O(N) time, O(1) space. 
	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int n : nums) {
			ans ^= n;
		}

		return ans;
	}



	// Using Set. 
	// O(N) time, O(N) space. 
	public int singleNumber2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (Integer integer : nums) {
			if (set.contains(integer)) {
				set.remove(integer);
			} else {
				set.add(integer);
			}
		}

		return set.iterator().next();
	}


	// Review
	public int singleNumberR(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (!set.contains(num)) {
				set.add(num);
			} else {
				set.remove(num);
			}
		}

		return set.iterator().next();	
	}

	// Review
	public int singleNumberR2(int[] nums) {
		int ans = 0;
		for (int num : nums) {
			ans ^= num;	
		}	

		return ans;	
	}




	// For testing. 
	public static void main(String[] args) {
		SingleNumber solution = new SingleNumber();

		// Test arguments. 
		//	    int num = 24;
		//	    int target = 2;
		//	    solution.getInt(num, target);

		int[] nums = new int[]{ 15, 4, 12, 15, 5, 5, 4, 12, 0 };
		System.out.println(solution.singleNumber(nums)); // 0
		nums = new int[]{ 1, 3, 12, 15, 4, 5, 4, 0, 3, 15, 0, 1, 5 };
		System.out.println(solution.singleNumber(nums)); // 12


	}

}















