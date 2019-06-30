// Create a linked list at each level of a Binary Search Tree
// using DFS recursive version.
// Author: CtCI 4.3 p.243 + kei.
// Date  : February 10, Decmber 8, 2016


// Pass in 'lists' to the recursive method to get result. 
ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
    createLevelLinkedList(root, lists, 0);

    return lists;
}

// The whole idea is DFS, pre-order traversal in a binary tree.
void createLevelLinkedList(
    TreeNode node, ArrayList<LinkedList<TreeNode>> lists, int level) {

    // Base case.
    if (node == null) {
        return;
    }

    // Prepare a linked list at each level.
    LinkedList<TreeNode> listEachLevel = null;
    // Point!
    if (lists.size() == level) {
        // This is the first time we have visited level 'level'.
        listEachLevel = new LinkedList<TreeNode>();
        lists.add(listEachLevel);        
    } else {
        // Get the list. 
        listEachLevel = lists.get(level);
    }

    // Add the node.
    listEachLevel.add(node);

    // Part of DFS pre-order traversal in a binary tree.
    createLevelLinkedList(node.left, lists, level + 1);
    createLevelLinkedList(node.right, lists, level + 1);
}




























