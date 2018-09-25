// Check if a tree is Binary Search Tree.

package whiteboard;

public class Lab_whiteboard {

    public static void main(String[] args) {

        
        SimpleBinarySearchTree2 bst = new SimpleBinarySearchTree2();

        // Push data into BST.
        SimpleTreeNode bstNode = buildBinarySearchTree(bst);

        System.out.println(isBinarySearchTree(bstNode)); // true
        System.out.println(isBinarySearchTree2(bstNode)); // true
        System.out.println(isBinarySearchTree3(bstNode)); // true
        
        
        
        // Not BST. 
        //     6
        //    / \
        //   8   9
        SimpleTreeNode treeNode = new SimpleTreeNode(6);
        treeNode.left = new SimpleTreeNode(8);
        treeNode.right = new SimpleTreeNode(9);
        
        System.out.println(isBinarySearchTree(treeNode)); // false
        System.out.println(isBinarySearchTree2(treeNode)); // false
        System.out.println(isBinarySearchTree3(treeNode)); // true  (Bad!) 
        
        
        
        
        
        
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

    

    // This is the best. 
    // Check if a tree is Binary Search Tree.
    // Min/Max version. 
    // Author: EPI 15.1 p.236 + kei
    // Date  : January 29, 2017 
    public static boolean isBinarySearchTree(SimpleTreeNode node) {
        return isBinarySearchTree(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBinarySearchTree(SimpleTreeNode node, int min, int max) {
        // Base Case.
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data > max) {
            return false;
        }

        // This is simpler. 
        return isBinarySearchTree(node.left, min, node.data) 
            && isBinarySearchTree(node.right, node.data, max);
    }


    // Check if a tree is Binary Search Tree.
    // Min/Max version. 
    // Author: Cracking Coding Interview p.222 + kei.
    // Date  : February 11, 2016
    public static boolean isBinarySearchTree2(SimpleTreeNode node) {
        return isBinarySearchTree2(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBinarySearchTree2(SimpleTreeNode node, int min, int max) {
        // Base Case.
        if (node == null) {
            return true;
        }

        // Check if the current node is less than all of the nodes that
        // are on the right side, and
        // check if the current node is greater than all of the nodes that 
        // are on the left side. 
        // If the definition of BST is left < mid < right, then 
        // "node.data >= max" is needed instead of "node.data > max".
        if (node.data <= min || node.data > max) {
            return false;
        }

        // Check the left and right subtrees. 
        if (!isBinarySearchTree2(node.left, min, node.data) || 
            !isBinarySearchTree2(node.right, node.data, max)) {
            return false;
        }

        // All good.
        return true;
    }




    // This code doesn't work when the tree is a very small tree. 
    // Check if a tree is Binary Search Tree.
    // Min/Max version. 
    // Author: Google Handout Person B + kei
    // Date  : February 5, 2017 
    public static boolean isBinarySearchTree3(SimpleTreeNode root) {
        return isBinarySearchTree3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBinarySearchTree3(SimpleTreeNode curr, int min, int max) {
        if (curr.left != null) {
            if (curr.left.data < min || !isBinarySearchTree3(curr.left, min, curr.data)) {
                return false;
            }
        }
        if (curr.right != null) {
            if (curr.right.data > max || !isBinarySearchTree3(curr.right, curr.data, max)) {
                return false;
            }
        }
        return true;
    }








    
    
    
    
    
    
    
    
    
    
    
}

























