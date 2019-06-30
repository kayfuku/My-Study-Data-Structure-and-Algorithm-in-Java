// 
// Author: 
// Date  : 

package leetcode;

class SolutionOtherClasses {


	// For testing. 
	public static void main(String[] args) {

		// Linked List. 
		MyLinkedList list = new MyLinkedList();
		list.add(7);
		list.add(9);
		list.add(2);
		list.add(10);
		list.add(1);
		list.add(8);
		list.add(6);
		System.out.println(list.toString()); // [ 7 9 2 10 1 8 6 ]



		// Binary Tree
		//  1
		//   \
		//    2 
		//   /
		//  3
		BinaryTree binaryTree = new BinaryTree();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		binaryTree.root = n1;
		n1.right = n2;
		n2.left = n3;


		// Binary Search Tree
		//       6
		//     /   \
		//    3     12 
		//   / \   /  \
		//  1   4 9   14
		BinaryTree bst = new BinaryTree();
		TreeNode tn1 = new TreeNode(6);
		TreeNode tn2 = new TreeNode(3);
		TreeNode tn3 = new TreeNode(1);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn5 = new TreeNode(12);
		TreeNode tn6 = new TreeNode(9);
		TreeNode tn7 = new TreeNode(14);

		bst.root = tn1;
		tn1.setLeft(tn2);
		tn1.setRight(tn5);
		tn2.setLeft(tn3);
		tn2.setRight(tn4);
		tn5.setLeft(tn6);
		tn5.setRight(tn7);

	}


	// For test. 
	private static void preorder(TreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.val);
		preorder(node.left);
		preorder(node.right);
	}
	private static void inorder(TreeNode node) {
		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.val);
		inorder(node.right);
	}


}




class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }

	public void add(ListNode node) {
		this.next = node;
		
	}

	@Override
	public String toString() {
		return Integer.toString(this.val);
	}
}

class MyLinkedList {
	ListNode head;
	ListNode tail;

	public MyLinkedList() {

	}

	public void add(int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			this.tail.next = newNode;
			tail = newNode;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode node = head;
		sb.append("[ ");
		while (node != null) {
			sb.append(node.toString());
			sb.append(" ");
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}

}


class BinaryTree {

	TreeNode root;


}


class TreeNode implements Comparable<TreeNode> {
	int val;
	int count;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int data) {
		this.val = data;
		this.count = 1;
	}

	public void setLeft(TreeNode node) {
		left = node;
	}

	public void setRight(TreeNode node) {
		right = node;
	}

	@Override
	public int compareTo(TreeNode o) {
		if (this.val < o.val) {
			return -1;
		} else if (this.val == o.val) {
			return 0;
		} else {
			return 1;
		}
	}

	// Auto-generated.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val;
		return result;
	}

	// Auto-generated. 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (val != other.val)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}


}




//This is also in the javafx library. 
class Pair {
	private String string;
	private int integer;

	public Pair(String string, int integer) {
		this.string = string;
		this.integer = integer;
	}

	public String getKey() {
		return string;
	}
	public int getValue() {
		return integer;
	}

}




































