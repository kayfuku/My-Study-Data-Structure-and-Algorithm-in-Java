// Codility, CyclicRotation.
// 100% (100 out of 100).
// Author: Kei Fukutani
// Date  : February 22, 2016

// 1. CyclicRotation
// Rotate an array to the right by a given number of steps.
// Task description
// A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is also moved to the first place.

// For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate array A K times; that is, each element of A will be shifted to the right by K indexes.

// Write a function:

// class Solution { public int[] solution(int[] A, int K); }

// that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.

// For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].

// Assume that:

// N and K are integers within the range [0..100];
// each element of array A is an integer within the range [−1,000..1,000].
// In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

// Copyright 2009–2016 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.

package codility;

public class CyclicRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array1 = { 3, 8, 9, 7, 6 };	
		
		int[] ans = solution(array1, 3); 
		for (int a : ans) {
			System.out.print(a);
		}
		
	
	}

	/**
	* Rotate elements K times in the A array.
	* @param A: {3,8,9,7,6} 
	* @param K: 3 
	* @return {9,7,6,3,8}
	*/
	public static int[] solution(int[] A, int K) {
		// write your code in Java SE 8
		if (A.length == 0 || K == 0) {
			return A;
		}
		
		int len = A.length;
		int[] ans = new int[len];
		
		for (int i = 0; i < len; i++) {
			ans[(i + K) % len] = A[i];		
		}
		
		return ans;
	} // end solution()

	
	
	
	
	
	
	
	

}
