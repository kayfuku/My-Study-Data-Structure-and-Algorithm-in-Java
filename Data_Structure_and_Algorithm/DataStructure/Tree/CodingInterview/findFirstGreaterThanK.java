// Find the first key greater than a given value in a BST. 
// Essentially, it is the same problem as finding key in BST. 
// Author: EPI 15.2 p.238 + kei 
// Date  : January 29, 2017 

package whiteboard;


public class Lab_whiteboard {

    public static void main(String[] args) {

        SimpleBinarySearchTree2 bst = new SimpleBinarySearchTree2();

        // Push data into BST.
        SimpleTreeNode bstNode = buildBinarySearchTree(bst);
        
        int k = 5;
        Integer ans = findFirstGreaterThanK(bstNode, k);
        System.out.println(ans); // 6 
        
        k = 7;
        ans = findFirstGreaterThanK(bstNode, k);
        System.out.println(ans); // 9

        k = 3;
        ans = findFirstGreaterThanK(bstNode, k);
        System.out.println(ans); // 4
        
        k = 0;
        ans = findFirstGreaterThanK(bstNode, k);
        System.out.println(ans); // 1 

        k = 14;
        ans = findFirstGreaterThanK(bstNode, k);
        System.out.println(ans); // null 

        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    
    
    // Build Binary Search Tree.
    //
    //                   6
    //                  /  \
    //                 3    12
    //                / \   / \
    //               1   4 9  14
    // Author: kei
    // Date  : September 24, 2016
    public static SimpleTreeNode buildBinarySearchTree(
            SimpleBinarySearchTree2 bst) {
        SimpleTreeNode tNode = null;

        tNode = bst.insert(tNode, 6);
        tNode = bst.insert(tNode, 3);
        tNode = bst.insert(tNode, 12);
        tNode = bst.insert(tNode, 1);
        tNode = bst.insert(tNode, 9);
        tNode = bst.insert(tNode, 4);
        tNode = bst.insert(tNode, 14);
        //tNode = bst.insert(tNode, 25);
        //tNode = bst.insert(tNode, 39); // With all above, not balanced.
        
        return tNode;
    }

    
    // Find the first key greater than a given value in a BST. 
    // Essentially, it is the same problem as finding key in BST. 
    // Author: EPI 15.2 p.238 + kei 
    // Date  : January 29, 2017 
    public static Integer findFirstGreaterThanK(SimpleTreeNode node, int k) {
        
        SimpleTreeNode n = node;
        Integer firstSoFar = null;
        
        while (n != null) {
            if (n.data <= k) {
                // Root and all keys in left subtree are not a candidate. 
                n = n.right;
            } else {
                // node.data > k 
                
                // Hold the candidate. 
                firstSoFar = n.data;
                
                n = n.left;
            }       
        }
        
        return firstSoFar;      
    }
    
}

























