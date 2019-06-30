// Create a minimal height Binary Search Tree from a sorted array.
// Author: CtCI 4.2 p.242 + kei.
// Date  : February 10, December 8, 2016

TreeNode createMinimalHeightBST(int[] array) {
    return createMinimalHeightBST(array, 0, array.length - 1);
}

TreeNode createMinimalHeightBST(int[] arr, int start, int end) {
    // Base case.
    // Like Binary Search. 
    if (end < start) {
        return null;
    }

    int mid = (start + end) / 2;

    // Create a root node. 
    TreeNode node = new TreeNode(arr[mid]);
    // Create the left subtree. 
    node.left = createMinimalHeightBST(arr, start, mid - 1);
    // Create the right subtree. 
    node.right = createMinimalHeightBST(arr, mid + 1, end);

    // Don't forget this!
    return node;
}




































