// 
// Author: 
// Date  : June 24, 2019

package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
	// fields here. 
//	private int count;
	
	public IntersectionOfTwoArrays() {
		// Initialization here. 
//		this.count = 0;
	}
		
	// 1. Two Sets. 
	// O(N + M) time, where N is nums1 length and M is nums2 length. 
	// O(N + M) space, because in the worst case, all elements in the arrays are different. 
    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> set1 = new HashSet<>();
    	for (Integer n : nums1) {
			set1.add(n);
		}
    	Set<Integer> set2 = new HashSet<>();
    	for (Integer m : nums2) {
			set2.add(m);
		}
    	
    	if (set1.size() < set2.size()) {
			return setIntersection(set1, set2);
		} else {
			return setIntersection(set2, set1);
		}
    }
    private int[] setIntersection(Set<Integer> set1, Set<Integer> set2) {
    	int[] output = new int[set1.size()];
    	int i = 0;
    	for (Integer n : set1) {
			if (set2.contains(n)) {
				output[i] = n;
				i++;
			}
		}
    	
		return Arrays.copyOf(output, i);
	}
    
    // 2. Built-in Set Intersection. retainAll()
    // 
    public int[] intersection2(int[] nums1, int[] nums2) {
    	Set<Integer> set1 = new HashSet<>();
    	for (Integer n : nums1) {
			set1.add(n);
		}
    	Set<Integer> set2 = new HashSet<>();
    	for (Integer m : nums2) {
			set2.add(m);
		}
    	
    	set1.retainAll(set2);
    	
    	int[] output = new int[set1.size()];
    	int i = 0;
    	for (Integer n : set1) {
			if (set2.contains(n)) {
				output[i] = n;
				i++;
			}
		}
    	
    	return output;
    }

	
	
	// other classes here. 

    
    

	// For testing. 
	public static void main(String[] args) {
	    IntersectionOfTwoArrays solution = new IntersectionOfTwoArrays();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
	    
	    
	}

}















