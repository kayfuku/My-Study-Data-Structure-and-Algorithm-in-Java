// 
// Author: 
// Date  : June 13, 2019

package leetcode;

public class NumberOf1Bits {
	// fields here. 
//	private int count;
	
	public NumberOf1Bits() {
		// Initialization here. 
//		this.count = 0;
	}
		
	
	// 
	/**
	 * Bit manipulation. 
	 * The run time depends on the number of 1-bits in n. In the worst case, 
	 * all bits in n are 1-bits. In case of a 32-bit integer, the run time is O(1).
	 * O(1) space. 
	 */
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {    	
    	int count = 0;
    	while (n != 0) {
			n = n & (n - 1);
    		count++;
		}
    	
    	return count;
    }
	
	
	// other classes here. 

    
    // For testing. 
	public static void main(String[] args) {
	    NumberOf1Bits solution = new NumberOf1Bits();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
	    
	    
	}

}















