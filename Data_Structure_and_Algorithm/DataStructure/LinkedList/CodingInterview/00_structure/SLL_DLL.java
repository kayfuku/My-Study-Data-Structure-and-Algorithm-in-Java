// Singly and Doubly Linked List.
// Author: kei

package whiteboard;


public class SLL_DLL {

	public static void main(String[] args) {
		
		// Test SLL.
		// Create singly linked list.
//		SLLNode<Integer> singlyLL = new SLLNode<Integer>(2);
		
//		// Test insertTail().
//		singlyLL.insertTail(1);
//		singlyLL.insertTail(3);
//		singlyLL.insertTail(2);
//		singlyLL.insertTail(4);
//		//singlyLL.displayList(); // 2 1 3 2 4
		
		// Test insertTail2().
		SLLNode<Integer> singlyLL = null;
		singlyLL = insertTail2(singlyLL, 2);
		singlyLL = insertTail2(singlyLL, 1);
		singlyLL = insertTail2(singlyLL, 3);
		singlyLL = insertTail2(singlyLL, 2);
		singlyLL = insertTail2(singlyLL, 4);
		//singlyLL.displayList(); // 2 1 3 2 4
		
		// Test insertHead().
		singlyLL = singlyLL.insertHead(0);
		singlyLL = singlyLL.insertHead(5);
		singlyLL = singlyLL.insertHead(7);
		//singlyLL.displayList(); // 7 5 0 2 1 3 2 4
		// In the case that the list has only one node.
		SLLNode<Integer> singlyLL2 = new SLLNode<Integer>(2);
		singlyLL2 = singlyLL2.insertHead(5);
		//singlyLL2.displayList(); // 5 2

		// Test deleteNode().
		// Delete middle node.
		singlyLL = singlyLL.deleteNode(5);
		//singlyLL.displayList(); // 7 0 2 1 3 2 4
		// Delete tail node.
		singlyLL = singlyLL.deleteNode(4);
		//singlyLL.displayList(); // 7 0 2 1 3 2
		// Delete head node.
		singlyLL = singlyLL.deleteNode(7);
		//singlyLL.displayList(); // 0 2 1 3 2 
		// Delete the node of the list that has just one node.
		SLLNode<Integer> singlyLL3 = new SLLNode<Integer>(1);
		//singlyLL3.displayList(); // 1
		singlyLL3 = singlyLL3.deleteNode(1);
		//System.out.println(singlyLL3); // null
		// Delete node not existing.
		singlyLL = singlyLL.deleteNode(9);
		//singlyLL.displayList(); // 0 2 1 3 2
		
		// Test reverseAndClone().
		SLLNode<Integer> list = reverseAndClone(singlyLL);
		//list.displayList(); // 2 3 1 2 0
		// one node.
		SLLNode<Integer> singlyLL4 = new SLLNode<Integer>(1);
		//singlyLL4.displayList(); // 1
		
		// Test isEqualList().
		SLLNode<Integer> listReverse = reverseAndClone(list);
		//listReverse.displayList(); // 0 2 1 3 2 
		//System.out.println(isEqualList(singlyLL, listReverse)); // true
		
		// Test findMiddleNode(). 
		System.out.println("Test findMiddleNode().");
		SLLNode<Integer> singlyLL5 = new SLLNode<Integer>(1);
		singlyLL5.insertTail(2);
		singlyLL5.insertTail(3);
		singlyLL5.insertTail(4);
		singlyLL5.insertTail(5);
		singlyLL5.displayList(); // 1 2 3 4 5 
		//System.out.println(findMiddleNode(singlyLL5)); // 4
		singlyLL5.deleteNode(5);
		singlyLL5.displayList(); // 1 2 3 4 
		System.out.println(findMiddleNode(singlyLL5)); // 3

		// Test getSizeOfList().
		//singlyLL.displayList(); // 0 2 1 3 2 
		//System.out.println(getSizeOfList(singlyLL)); // 5

		// Test getKthNode().
		System.out.println("Test getKthNode().");
		singlyLL.displayList(); // 0 2 1 3 2 
		SLLNode<Integer> n = getKthNode(singlyLL, 4);
		System.out.println(n.data); // 2
		// Because in Java, it's always 'Pass by value'.
		//System.out.println(singlyLL.data); // 0
		
		// Test getKthNode2().
		System.out.println("Test getKthNode2().");
		singlyLL.displayList(); // 0 2 1 3 2 
		SLLNode<Integer> n2 = getKthNode2(singlyLL, 4);
		System.out.println(n2.data); // 3
		
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
		list2.add(1);
		list2.add(3);
		list2.add(4);
		list2.add(0);
		SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();
		list3.add(8);
		list3.add(6);
		list3.add(5);
		list3.add(1);
		
		// Test SinglyLinkedList.toString().
		System.out.println(list2.toString()); // [ 0 4 3 1 ]
		System.out.println(list3.toString()); // [ 1 5 6 8 ]
		// Test SinglyLinkedList.isSorted().
		System.out.println(list2.isSorted()); // false
		System.out.println(list3.isSorted()); // true

		// Test SinglyLinkedList.reverse(). 
		list2.reverse();
		System.out.println(list2.toString()); // [ 1 3 4 0 ]
		list3.reverse();
		System.out.println(list3.toString()); // [ 8 6 5 1 ]

		
		// Test search().
		singlyLL5.displayList(); // [ 1 2 3 4 ]
		SLLNode<Integer> node = singlyLL5.search(singlyLL5, 4);
		System.out.println(node.data); // 4
		
		// Test search2().
		singlyLL5.displayList(); // [ 1 2 3 4 ]
//		SLLNode<Integer> node2 = singlyLL5.search2(singlyLL5, 5);
//		System.out.println(node2.data); // RuntimeException, Not found. 
		
		// Test search2().
		singlyLL5.displayList(); // [ 1 2 3 4 ]
		SLLNode<Integer> node3 = singlyLL5.deleteNode2(4);
		node3.displayList(); // [ 1 2 3 ]

		
		
	}
	
	// You can also pass in the head of list. 
	// Author: kei
	// October 30, 2016
	public static SLLNode<Integer> insertTail2(SLLNode<Integer> head, Integer data) {
		SLLNode<Integer> newNode = new SLLNode<Integer>(data);
		SLLNode<Integer> node = head;
		
		// There is no node. 
		if (node == null) {
			return newNode;
		}
		
		// Get to tail node.
		while (node.next != null) {
			node = node.next;
		}
		
		// Insert at tail.
		node.next = newNode;	
		
		return head;
	}
	
	// Reverse and clone the list.
	// Author: CtCI 6th p.217 + kei
	// Date  : October 19, 2016
	public static SLLNode<Integer> reverseAndClone(SLLNode<Integer> node) {
		SLLNode<Integer> head = null;
		
		while (node != null) {
			SLLNode<Integer> newNode = new SLLNode<Integer>(node.data);
			// Add-to-head pattern. 
			newNode.next = head;
			head = newNode;
			node = node.next;
		}
		
		return head;
	}
	
	// Check if two list match.
	// Author: CtCI 6th p.217 + kei
	// Date  : October 19, 2016
	public static boolean isEqualList(SLLNode<Integer> node1, 
			                          SLLNode<Integer> node2) {
		while (node1 != null && node2 != null) {
			if (node1.data != node2.data) {
				return false;
			}
			node1 = node1.next;
			node2 = node2.next;
		}

		// Note that not just return true here!
		return node1 == null && node2 == null;
	}
	
	// Find middle node/the beginning node of the second half 
	// when you don't know the size of the list. (Runner technique)
	// Author: CtCI 6th p.218 + kei
	// Date  : October 19, 2016
	public static int findMiddleNode(SLLNode<Integer> head) {
		SLLNode<Integer> fast = head;
		SLLNode<Integer> slow = head;
				
		// 'fast' is moving at 2x speed.
		while (fast != null && fast.next != null) {
			// Do something here.
			
			slow = slow.next;
			fast = fast.next.next;			
		}
		
		// 'head' list has odd number of elements, so skip the 
		// middle element.
		if (fast != null) {
			slow = slow.next;
		}
		
		// At this point, 'slow' indicates the beginning node 
		// of the second half of the list.
		return slow.data;
	}
	
	// Get the size of the list.
	// Author: CtCI 6th p.220 + kei
	// Date  : October 19, 2016
	public static int getSizeOfList(SLLNode<Integer> node) {
		if (node == null) {
			return -1;
		}
		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}
		return size;		
	}
	
	// Get the k-th node starting with 0. 
	// Author: CtCI 6th p.222 + kei
	// Date  : October 23, 2016
	public static SLLNode<Integer> getKthNode(SLLNode<Integer> node, int k) {
		if (node == null || k < 0) {
			return null;
		}
		
		// You can use formal argument because in Java it's always 'pass by value'.
	    while (k > 0 && node != null) {
	        node = node.next;
	        k--;
	    }
	    // Note that if k > len - 1, then return null.
	    return node;
	}
	
	// Get the k-th node starting with 1. 
	// Author: kei
	// Date  : December 22, 2018
	public static SLLNode<Integer> getKthNode2(SLLNode<Integer> node, int k) {
		if (node == null || k <= 0) {
			return null;
		}

		// The pointer must move k - 1 times to the next node, not null end. 
		// So, node == null means k is bigger than the length of the list. 
		while (k - 1 > 0 && node != null) {
			node = node.next;
			k--;
		}
		return node;
	}
	
	
	

}

// Simple list node. 
// Author: kei
// Date  : November 29, 2016
class SimpleListNode {
	int data;
	SimpleListNode next;
	
	public SimpleListNode() {
	}
	
	public SimpleListNode(int data) {
		this.data = data;
	}
	
	public SimpleListNode(int data, SimpleListNode node) {
		this.data = data;
		this.next = node;
	}

}


// Singly Linked List. 
// Author: アルゴリズムを学ぼう p.53 + kei.
// Date  : September 19, 2016
class SinglyLinkedList<T> {
	SLLNode<T> head;
	
	public SinglyLinkedList() {
		head = null;
	}
	
	// Add at head. O(1)
	// Author: kei
	// Date  : November 29, 2016
	public void add(T data) {
		SLLNode<T> newNode = new SLLNode<T>(data);
		if (head == null) {
			head = newNode;
		} else {			
			// There exists one or more node. 
			// Insert at head. 
			newNode.next = head;
			head = newNode;
		}
	}
	
	
	// Check if the list is sorted in ascending order. 
	// Author: CS111C Lab3 + kei
	// Date  : November 29, 2016
	public boolean isSorted() {
		if (head == null || head.next == null) {
			return true;
		} else {
			SLLNode<T> prev = head;
			SLLNode<T> curr = head.next;
			
            // Check if the list is sorted in ascending order.
            // This time, descending order means not sorted.
			while (curr != null) {
				if ((Integer) prev.data > (Integer) curr.data) {
					return false;
				}
				prev = prev.next;
				curr = curr.next;				
			}

			return true;						
		}
	}
	
	// Reverse the list. O(N) space. 
	// Author: CS111C Lab3 + kei
	// Date  : November 29, 2016
	public void reverse() {
		SLLNode<T> node = head;
		SLLNode<T> newHead = null;
		
		while (node != null) {
			SLLNode<T> newNode = new SLLNode<T>(node.data);
			newNode.next = newHead;
			newHead = newNode;
			node = node.next;			
		}
		
		head = newHead;				
	}

	
	
	
	
	
	
	
	
	// Display the whole list. 
	// Author: kei
	// Date  : November 29, 2016
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SLLNode<T> node = head;
		sb.append("[ ");
		while (node != null) {
			sb.append(node.data);
			sb.append(" ");
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}
}

// Node to be used in Singly Linked List.
// Author: kei
// Date  : October 19, 2016
class SLLNode<T> {
	T data;
	SLLNode<T> next;
	
	public SLLNode() {
	}
	
	public SLLNode(T data) {
		this.data = data;
	}
	
	public SLLNode(T data, SLLNode<T> node) {
		this.data = data;
		this.next = node;
	}
	
	// Insert at head. O(1)
	// 'this' is an object that has this method. 
	// Author: kei
	// Date  : October 19, 2016
	public SLLNode<T> insertHead(T data) {
		SLLNode<T> newNode = new SLLNode<T>(data);
		SLLNode<T> node = this;

		// Insert at head.
		newNode.next = node;
		return newNode;
	}
	
	// Insert at tail. O(N)
	// Author: kei + CtCI 6th p.92
	// Date  : October 19, 2016
	public void insertTail(T data) {
		SLLNode<T> newNode = new SLLNode<T>(data);
		SLLNode<T> node = this;
		
		// Get to tail node.
		while (node.next != null) {
			node = node.next;
		}
		
		// Insert at tail.
		node.next = newNode;		
	}

	// Delete node.
	// Author: kei + CtCI 6th p.93
	// Date  : October 19, 2016
	public SLLNode<T> deleteNode(T data) {
		SLLNode<T> node = this;
		
		// Delete head node.
		// Regardless of whether the list has just one node or more.
		if (node.data == data) {
			return node.next;
		}
		
		// Delete middle or tail node.
		// Get to the prev to the target.
		// You need prev node to delete node.
		while (node.next != null) {
			if (node.next.data == data) {
				node.next = node.next.next;
				return this;
			}	
			node = node.next;
		}
		
		// Not found.
		return this;
	}
	
	// Delete node. Easier to understand for me! 
	// Author: kei
	// Date  : December 22, 2018
	public SLLNode<T> deleteNode2(T data) {
		SLLNode<T> node = this;
		SLLNode<T> prev = null;
		
		// Delete head node.
		// Regardless of whether the list has just one node or more.
		if (node.data == data) {
			return node.next;
		}
		
		prev = node;
		node = node.next;

		// Delete middle or tail node.
		// Get to the prev to the target.
		// You need prev node to delete node.
		while (node != null) {
			if (node.data == data) {
				prev.next = node.next;
				return this;
			}	
			prev = node;
			node = node.next;
		}

		// Not found.
		return this;
	}
	
	// Display every element of the list. 
	// Author: kei
	// Date  : October 19, 2016
	public void displayList() {
		SLLNode<T> node = this;
		System.out.print("[ ");
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println("]");
	}
	
	// Search key in SLL.
	// Author: kei + EPI p.101
	// Date  : October 19, 2016
	public SLLNode<T> search(SLLNode<T> node, T key) {
		
		while (node != null && node.data != key) {
			node = node.next;
		}
		
//		return node;	
		
		// PIE p.36 + kei
		// October 30, 2016
		if (node == null) {
			throw new RuntimeException("Not found.");
		} else {
			return node;
		}
	}
	
	// Search key in SLL. Easier to understand for me! 
	// Author: kei
	// Date  : December 22, 2018
	public SLLNode<T> search2(SLLNode<T> node, T key) {

		// Check until the last node. 
		while (node != null) {
			if (node.data == key) {
				return node;
			}
			node = node.next;
		}
		
		throw new RuntimeException("Not found.");
	}
	
	// Insert a new node after a specified node.
	// Author: kei + EPI p.101
	// Date  : October 19, 2016
	public void insertAfter(SLLNode<T> node, SLLNode<T> newNode) {
		newNode.next = node.next;
		node.next = newNode;	
	}

	
	
}

// Doubly Linked List.
// Author: アルゴリズムを学ぼう p.53 + kei.
// Date  : September 19, December 23, 2016
class DoublyLinkedList<T> {
	DLLNode<T> head;
	DLLNode<T> tail;
	
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}
	
	// Add at head. O(1)
	// Author: kei
	// Date  : December 23, 2016
	public void addAtHead(T data) {
		DLLNode<T> newNode = new DLLNode<T>(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			// There exists one or more node. 
			newNode.next = head;
			head = newNode;
		}
	}
	
	// Pending...
	// Add at specific place. 
	// Author: kei
	// Date  : December 23, 2016
//	public void addAt(T data, int index) {		
//		if (index == 0) {
//			addAtHead(data);
//		}
//		
//		DLLNode<T> newNode = new DLLNode<T>(data);
//		DLLNode<T> node = head;
//		if (node == null) {
//			throw new IllegalArgumentException("Invalid index");
//		}
//
//		int i = 0;
//		// Move 'node' to refer to node after insertion point. 
//		while (node.next != null && index != i) {
//			node = node.next;
//			i++;
//		}
//		
//		
//		
//		
//		// Add at specific place.
//		node.prev.next = newNode;
//		newNode.next = node;
//		newNode.prev = node.prev;
//		node.prev = newNode;
//		
//		
//		
//	}

	
	// Display the whole list. 
	// Author: kei
	// Date  : December 23, 2016
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DLLNode<T> node = head;
		sb.append("[ ");
		while (node != null) {
			sb.append(node.data);
			sb.append(" ");
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}


	
	
}

//Doubly Linked List.
//Author: アルゴリズムを学ぼう p.53 + kei.
//Date  : September 19, December 23, 2016
class DLLNode<T> {
	T data;
	DLLNode<T> prev;
	DLLNode<T> next;
	
	public DLLNode() {
	}
	
	public DLLNode(T data) {
		this.data = data;
	}
	
	public DLLNode(T data, DLLNode<T> node) {
		this.data = data;
		this.next = node;
	}

}






























