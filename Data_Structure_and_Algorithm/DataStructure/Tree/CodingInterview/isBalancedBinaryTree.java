// Check if a binary tree is balanced.
// Author: CtCI 4.4 p.245 + kei.
// Date  : September 25, 2016

// Get the height at each node and
// If the subtree is not balanced, return Integer.MIN_VALUE 
// to break the recursion immediately.
public static int checkHeight(TreeNode node) {
    if (node == null) {
        // Reason why -1 is because the height becomes 0 
        // when one node added.
        return -1;
    }

    // Check if the left subtree is balanced.
    // If it is not balanced, we do not need to check 
    // the right subtree. 
    int leftHeight = checkHeight(node.left);
    if (leftHeight == Integer.MIN_VALUE) {
        // Left subtree is not balanced.
        // So no need to check right subtree.
        return Integer.MIN_VALUE;
    }

    // Check if the right subtree is balanced.
    int rightHeight = checkHeight(node.right);
    if (rightHeight == Integer.MIN_VALUE) {
        // Right subtree is not balanced.
        return Integer.MIN_VALUE;
    }

    // Check if this tree is balanced.
    if (Math.abs(leftHeight - rightHeight) > 1) {
        // Not balanced.
        return Integer.MIN_VALUE;
    } else {
        // Return the height of this tree.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

public static boolean isBalancedBinaryTree(TreeNode root) {
    if (checkHeight(root) == Integer.MIN_VALUE) {
        return false;
    } 
    
    return true;
}








// This code is not efficient. 
// Author: Cracking Coding Interview 6th 4.4 p.245 + kei.
// Date  : September 25, 2016 
boolean isBalancedBinaryTree(SimpleTreeNode tNode) {
    
    if (tNode == null) {
        return true;
    }
    
    if (isBalancedBinaryTree(tNode.left)
        && isBalancedBinaryTree(tNode.right)) {
        
        int leftHeight = getHeight(tNode.left);
        int rightHeight = getHeight(tNode.right);
        
        int diff = Math.abs(leftHeight - rightHeight);
        
        return diff <= 1;           
        
    } else {
        return false;
    }
    
}























