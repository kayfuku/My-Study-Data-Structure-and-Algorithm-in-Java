// 
// Author: 
// Date  : June 19, 2019

package leetcode;


public class RemoveDuplicatesfromSortedListII {
	// fields here. 
	//	private int count;

	public RemoveDuplicatesfromSortedListII() {
		// Initialization here. 
		//		this.count = 0;
	}

	// Accepted. 
	// O(N) time, O(1) space. 
	// Author: kei
	// Date  : June 19, 2019
	public ListNode deleteDuplicatesKei(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy, q = head.next;
		while (q != null) {
			if (q.val == p.next.val) {
				// Find the different value node. 
				// Be careful about null pointer exception. 
				while (q != null && q.val == p.next.val) {
					q = q.next;
				}
				// Remove all of the duplicate nodes. 
				p.next = q;
				// NG!
				// p = q;
				if (q != null) {
					q = q.next;
				}
			} else {
				p = p.next;
				q = q.next;
			}    		
		}

		return dummy.next;
	}


	// Accepted
	// Author: jinwu
	public ListNode deleteDuplicates(ListNode head) {
		//use two pointers, slow - track the node before the dup nodes, 
		// fast - to find the last node of dups.
		ListNode dummy = new ListNode(0), fast = head, slow = dummy;
		slow.next = fast;
		while(fast != null) {
			while (fast.next != null && fast.val == fast.next.val) {
				fast = fast.next;    //while loop to find the last node of the dups.
			}
			if (slow.next != fast) { //duplicates detected.
				slow.next = fast.next; //remove the dups.
				fast = slow.next;     //reposition the fast pointer.
			} else { //no dup, move down both pointer.
				slow = slow.next;
				fast = fast.next;
			}

		}
		return dummy.next;
	} 
	


// other classes here. 


// For testing. 
public static void main(String[] args) {
	RemoveDuplicatesfromSortedListII solution = new RemoveDuplicatesfromSortedListII();

	// Test arguments. 
	//	    int num = 24;
	//	    int target = 2;
	//	    solution.getInt(num, target);

	// Linked List. 
	MyLinkedList list = new MyLinkedList();
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(3);
	list.add(4);
	list.add(4);
	list.add(5);
	System.out.println(list.toString()); // [ 1 2 3 3 4 4 5 ]

	ListNode node = solution.deleteDuplicatesKei(list.head); 
	while (node != null) {
		System.out.print(node.val);
		node = node.next;
	}
	// 125


}

}















