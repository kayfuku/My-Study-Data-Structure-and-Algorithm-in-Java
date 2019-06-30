// Get a random node from the tree. O(log N)
// If a node has an index, then I can get i-th node traversing the tree. 
// It takes O(N) time to traverse the tree, but it can be O(log N) time  
// if I know the size of the subtree because I don't have to traverse 
// the subtree in order to get the i-th node. 
// Author: CtCI 4.11 p.270~ + kei
// Date  : November 13, 2016

package whiteboard;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Lab_whiteboard {

    public static void main(String[] args) {
        
        // Build a binary search tree.
        //                   6
        //                  /  \
        //                 3    12
        //                / \   / \
        //               1   4 9  14
        Tree bst = new Tree();
        bst.insert(6);
        bst.insert(3);
        bst.insert(1);
        bst.insert(4);
        bst.insert(12);
        bst.insert(9);
        bst.insert(14);
        //bst.display(); // 1 3 4 6 9 12 14 
        System.out.println();
        
        // Test getRandomNode().
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int val = bst.getRandomNode().data();
            if (!map.containsKey(val)) {
                map.put(val, 1);
            } else {
                map.put(val, map.get(val) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // 1: 1358
        // 3: 1469
        // 4: 1453
        // 6: 1467
        // 9: 1428
        // 12: 1429
        // 14: 1396
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end of main().

}


class Tree {
    TreeNodeWithSize root = null;
    
    public Tree() {
    }
    
    public int size() {
        return root == null ? 0 : root.size();
    }
    
    public TreeNodeWithSize getRandomNode() {
        if (root == null) {
            return null;
        }
        
        // Get a random integer between 0 and size() - 1 inclusive. 
        Random random = new Random();
        int index = random.nextInt(size());
        
        return root.getIthNode(index);          
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new TreeNodeWithSize(val);
        } else {
            root.insert(val);
        }
    }
    
    
    // For debugging. 
    public void display() {
        display(root);
    }
    private void display(TreeNodeWithSize tNode) {
        if (tNode == null) {
            return;
        }
        
        display(tNode.left);
        System.out.println(tNode.data());
        display(tNode.right);
    }
    

    
}


// A tree node class with the size of its whole tree. 
class TreeNodeWithSize {
    private int data;
    // Note this is public. 
    public TreeNodeWithSize left, right;
    // The size of whole tree with this node as a root. 
    private int size = 0;
    
    public TreeNodeWithSize(int d) {
        data = d;
        size = 1;
    }
    
    public int size() {
        return size;
    }
    
    public int data() {
        return data;
    }
    
    // In BST, you can get a node O(log N) by the given index 
    // with which you label all the nodes in BST in in-order 
    // starting from 0 if the node has the size of its tree. 
    //                      3
    //                   /     \
    //                 1         1(5)
    //                / \       /   \
    //               0   0(2)  0(4)  0(6) 
    public TreeNodeWithSize getIthNode(int i) {
        // Check the left subtree size to skip those nodes. 
        int leftSize = (left == null ? 0 : left.size());
        
        if (i < leftSize) {
            return left.getIthNode(i);
        } else if (i == leftSize) {
            return this;
        } else {
            // Skipping over leftSize + 1 (this node) nodes, 
            // so subtract them. 
            return right.getIthNode(i - (leftSize + 1));
        }
    }
    
    // Note that the difference from BinarySearchTree2.insert().
    // I think this is better because inserting is related to the node. 
    // (insert method is in the node class.) 
    public void insert(int d) {
        if (d <= data) {
            if (left == null) {
                left = new TreeNodeWithSize(d);
            } else {
                left.insert(d);
            }
        } else {
            if (right == null) {
                right = new TreeNodeWithSize(d);
            } else {
                right.insert(d);
            }
        }
        // Every time insert method called, increment size regardless of
        // which subtree the new node goes to. 
        size++;
    }
    
    public TreeNodeWithSize find(int d) {
        if (d == data) {
            return this;
        } else if (d < data) {
            if (left == null) {
                // Base case.
                return null;
            } else {
                return left.find(d);
            }
        } else {
            if (right == null) {
                // Base case. 
                return null;
            } else {
                return right.find(d);
            }
        }           
    }

}















