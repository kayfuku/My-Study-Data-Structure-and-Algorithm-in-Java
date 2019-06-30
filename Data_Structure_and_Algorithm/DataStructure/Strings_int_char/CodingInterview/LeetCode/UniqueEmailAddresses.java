// 
// Author: 
// Date  : June 26, 2019

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
	// fields here. 
//	private int count;
	
	public UniqueEmailAddresses() {
		// Initialization here. 
//		this.count = 0;
	}
		
	// O(C) time, O(C) space, where C is the total number of 
	// characters in all the emails. 
    public int numUniqueEmails(String[] emails) {
    	Set<String> set = new HashSet<>();
    	for (String email : emails) {
			int i = email.indexOf("@");
			String local = email.substring(0, i);
			String rest = email.substring(i);
			if (local.contains("+")) {
				local = local.substring(0, local.indexOf("+"));
			}
			local = local.replaceAll("\\.", "");
//			local.replaceAll("\\.", ""); // NG!
    		set.add(local + rest);
		}
    	
    	return set.size();
    }
	
	
	// other classes here. 

    
    // For testing. 
	public static void main(String[] args) {
	    UniqueEmailAddresses solution = new UniqueEmailAddresses();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
	    
	    
	}

}















