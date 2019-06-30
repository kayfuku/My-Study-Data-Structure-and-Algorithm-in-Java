// 
// Author: 
// Date  : June 19, 2019

package leetcode;

public class ReverseLinkedList {
	// fields here. 
	//	private int count;

	public ReverseLinkedList() {
		// Initialization here. 
		//		this.count = 0;
	}

	// 1. Iterative. 
	// O(N) time, O(1) space. 
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		//ListNode nextTemp = cur.next; // NG! 
		
		while (cur != null) {
			// Save the pointer before cutting cur.next. 
			ListNode nextTemp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nextTemp;
			//nextTemp = cur.next; // NG!
		}
		
		return prev;
	}

	// 2. Recursive. 
	// O(N) time, O(N) space. 
	public ListNode reverseList2(ListNode node) {
		if (node == null || node.next == null) {
			return node;
			//return null; // NG!
		}
		
		// Post-order traversal because we cannot cut the link 
		// before going further on the list. 
		ListNode lastNode = reverseList2(node.next);
		node.next.next = node;
		node.next = null;

		// Return the node returned from the base case. 
		// And the node has not been processed in the post-order traversal, 
		// which means, return the node from the base case up until the 
		// top of the recursion stack. 
		return lastNode;
	}




	// other classes here. 


	// For testing. 
	public static void main(String[] args) {
		ReverseLinkedList solution = new ReverseLinkedList();

		// Test arguments. 
		//	    int num = 24;
		//	    int target = 2;
		//	    solution.getInt(num, target);
		
		MyLinkedList list = new MyLinkedList();
	    list.add(1);
	    list.add(2);
	    list.add(3);
	    System.out.println(list.toString()); // [ 1 2 3 ]
	    ListNode node = solution.reverseList2(list.head);
	    System.out.println(node); // 3

	}

}















