// 
// Author: 
// Date  : June 18, 2019

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
	// fields here. 
//	private int count;
	
	public LinkedListCycleII() {
		// Initialization here. 
//		this.count = 0;
	}
		
	// 1. HashSet. 
	// O(N) time, O(N) space. 
    public ListNode detectCycle(ListNode head) {
    	Set<ListNode> set = new HashSet<>();
    	ListNode cur = head;
    	
    	while (cur != null) {
			if (set.contains(cur)) {
				return cur;
			}
			
    		set.add(cur);
    		cur = cur.next;
		}
    	
    	return null;
    }
    
    // 2. Two Pointers. 
    // Provide the X is the length from head to the start point of circle, and 
    // Y is the length of the circle. We know slow moves t, while fast moves 2t. 
    // They meet at K where is the length from the start point of the circle.
    // Then we have :
    // 
    // t = X + nY + K
    // 2t = X + mY + K
    //
    // X = (Y - K) + (m - 2n - 1)Y
    // which means by finishing the rest length of the circle and 
    // some number of circle lengths, the traveled distance is equal to X.
    
    // Then we get, t = (n - m)Y
    // The time complexity depends on the circle length. The circle length is at most N, where N is the 
    // total number of nodes, which means O(N) time complexity.  
    // O(1) space. 
    public ListNode detectCycle2(ListNode head) {
    	if (head == null || head.next == null) {
    		// No circle. 
			return null;
		}
    	
    	ListNode slow = head, fast = head;
    	while (fast.next != null && fast.next.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    		if (slow == fast) {
				while (head != fast) {
					fast = fast.next;
					head = head.next;
				}
    			return head;
			}	
		}
    	
    	return null;
    }

    	
    	
    
    
	
	
	// other classes here. 

    
    // For testing. 
	public static void main(String[] args) {
	    LinkedListCycleII solution = new LinkedListCycleII();
	    
	    // Test arguments. 
//	    int num = 24;
//	    int target = 2;
//	    solution.getInt(num, target);
	    
	    
	    
	}

}















