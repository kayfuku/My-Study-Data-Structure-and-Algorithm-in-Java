// Get the height of a binary tree. 
// O(N) time.
// Author: Cracking Coding Interview p.216 + kei
// Date  : February 8, 2016

public static int getHeight(TreeNode root) {
    // Base case.
    if (root == null) {
        return -1;
    }

    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}


// Get the height of binary tree. 
// Post-order because it needs the info of both left and right child.
// Author: CtCI 6th p.244 + kei
// Date  : September 24, October 31, 2016
public static int getHeight(SimpleTreeNode tNode) {
    
    if (tNode == null) {
        // Why -1?
        // Think about when the tree has just one node. 
        // Its height should be 0, so return value 
        // should be 0. Be careful about the definition of height. 
        return -1;
    }
    
    int leftHeight = getHeight(tNode.left);
    int rightHeight = getHeight(tNode.right);
    
    int height = Math.max(leftHeight, rightHeight) + 1; 
    
    return height;
}



























