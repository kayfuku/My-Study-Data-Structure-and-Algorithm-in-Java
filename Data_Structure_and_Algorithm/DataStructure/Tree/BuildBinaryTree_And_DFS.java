// Depth-First Search (DFS) in Binary Tree.
// Iterative version using a stack.
// (Google Code Challenge)
// Author: Kei Fukutani
// Date  : February 6, 2016



package com.google.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GridRooms
{
    private static int food;
    private static List<Integer> foodLefts = new ArrayList<Integer>();


    public static void main(String[] args)
    {

        food = 12;
        int[][] rooms = { {0, 2, 5}, {1, 1, 3}, {2, 1, 1} };

        int minFoodLeft = answer(food, rooms);
        System.out.println();
        System.out.println("minFoodLeft: " + minFoodLeft);

    } // end of main()

    public static int answer(int food, int[][] grid)
    {

        // Your code goes here.

        // Build Binary Tree from the 2d array.
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        binaryTree = buildTree(grid, 0, 0);
        

        int result = displayPath(binaryTree);

        // System.out.println(food);
        return result;

    } // end of answer(...)
    
    public static int displayPath(BinaryTree<Integer> binaryTree)
    {
        // DFS (Depth-First Search)
        Deque<BinaryTree<Integer>> stack = new LinkedList<BinaryTree<Integer>>();
        stack.push(binaryTree);
        
        Deque<Integer> foodLeftStack = new LinkedList<Integer>();
        foodLeftStack.push(food - binaryTree.getRootItem());
        
        // For path test.
        List<Integer> path = new LinkedList<Integer>();      
        
        
        while (!stack.isEmpty())
        {
            BinaryTree<Integer> tree = stack.pop();
            //System.out.print(tree.getRootItem() + " ");
            
            int foodLeft = foodLeftStack.pop();
          
            // For path test.
            path.add(tree.getRootItem());    
            
            if (tree.root.rightChild != null) // have a right child.
            {
                stack.push(tree.getRightSubtree());
                foodLeftStack.push(foodLeft - tree.getRightSubtree().getRootItem());
            }
            if (tree.root.leftChild != null) // have a left child.
            {
                stack.push(tree.getLeftSubtree());
                foodLeftStack.push(foodLeft - tree.getLeftSubtree().getRootItem());
            }
            
            if (tree.root.rightChild == null && 
                tree.root.leftChild == null) // have no child.
            {
                
                //System.out.println(foodLeft);
                foodLefts.add(foodLeft);
                
                // For path test.
                System.out.println();
                for (int n = 0; n < path.size(); n++)
                {
                    if (path.get(n) != null)
                    {
                        System.out.print(path.get(n)  + " ");
                    }
                }
                path.clear();
                
                
            } // end of if (...)         
        } // end of while (!stack.isEmpty())
        
        // Get as little as possible.
        Collections.sort(foodLefts);
        int length = foodLefts.size();    
        int result = -1;
        for (int i = 0; i < length; i++)
        {
            if (foodLefts.get(i) >= 0)
            {
                //System.out.println(foodLefts.get(i));
                result = foodLefts.get(i);
                break;
            }               
        }

        return result;
    } // end of displayPath()

    public static BinaryTree<Integer> buildTree(int[][] grid, int row, int column)
    {
        int dim = grid.length;
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(grid[row][column]);

        if (row == dim - 1 && column == dim - 1)
        {

            return binaryTree;
        }
        else if (row == dim - 1)
        {
            // Add right subtree.
            BinaryTree<Integer> treeR = buildTree(grid, row, column + 1); // A
            binaryTree.attachRightSubtree(treeR);

            return binaryTree;
        }
        else if (column == dim - 1)
        {
            // Add left subtree.
            BinaryTree<Integer> treeL = buildTree(grid, row + 1, column); // B
            binaryTree.attachLeftSubtree(treeL);

            return binaryTree;
        }
        else
        {
            // Add right subtree.
            BinaryTree<Integer> treeR = buildTree(grid, row, column + 1); // C
            binaryTree.attachRightSubtree(treeR);

            // Add left subtree.
            BinaryTree<Integer> treeL = buildTree(grid, row + 1, column); // D
            binaryTree.attachLeftSubtree(treeL);

            return binaryTree;
        }
    } // end of buildTree(...)

    

}

// **************** class TreeIterator *************************
// For binary tree traversals in preorder, inorder, or postorder.
class TreeIterator<T> implements Iterator<T>
{
    private BinaryTreeBasis<T> binTree;
    private TreeNode<T> currentNode;
    private LinkedList<TreeNode<T>> queue; // from JCF

    public TreeIterator(BinaryTreeBasis<T> bTree)
    {
        binTree = bTree;
        currentNode = null;
        // empty queue indicates no traversal type currently
        // selected or end of current traversal has been reached
        queue = new LinkedList<TreeNode<T>>();
    } // end constructor

    @Override
    public boolean hasNext()
    {
        return !queue.isEmpty();
    } // end hasNext

    @Override
    public T next() throws java.util.NoSuchElementException
    {
        currentNode = queue.remove();
        return currentNode.item;
    } // end next

    @Override
    public void remove() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException();
    } // end remove

    public void setPreorder()
    {
        queue.clear();
        preorder(binTree.root);
    } // setPreOrder

    public void setInorder()
    {
        queue.clear();
        inorder(binTree.root);
    } // end setInorder

    public void setPostorder()
    {
        queue.clear();
        postorder(binTree.root);
    } // end setPostorder

    private void preorder(TreeNode<T> treeNode)
    {
        if (treeNode != null)
        {
            queue.add(treeNode);
            preorder(treeNode.leftChild);
            preorder(treeNode.rightChild);
        } // end if
    } // end preorder

    private void inorder(TreeNode<T> treeNode)
    {
        if (treeNode != null)
        {
            inorder(treeNode.leftChild);
            queue.add(treeNode);
            inorder(treeNode.rightChild);
        } // end if
    } // end inorder

    private void postorder(TreeNode<T> treeNode)
    {
        if (treeNode != null)
        {
            postorder(treeNode.leftChild);
            postorder(treeNode.rightChild);
            queue.add(treeNode);
        } // end if
    } // end postorder
} // end TreeIterator

// **************** class BinaryTree ***************************
// Reference-Based ADT Binary Tree. This is not necessary for Lab5.
class BinaryTree<T> extends BinaryTreeBasis<T>
{

    public BinaryTree()
    {
    } // end default constructor

    public BinaryTree(T rootItem)
    {
        super(rootItem);
    } // end constructor

    public BinaryTree(T rootItem, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
    {
        root = new TreeNode<T>(rootItem, null, null);
        attachLeftSubtree(leftTree);
        attachRightSubtree(rightTree);
    } // end constructor

    @Override
    public void setRootItem(T newItem)
    {
        if (root != null)
        {
            root.item = newItem;
        }
        else
        {
            root = new TreeNode<T>(newItem, null, null);
        } // end if
    } // end setRootItem

    public void attachLeft(T newItem) throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException:  Empty tree");
        }
        else if (root.leftChild == null)
        {
            // assertion: nonempty tree; no left child
            root.leftChild = new TreeNode<T>(newItem, null, null);
        } // end if
    } // end attachLeft

    public void attachRight(T newItem) throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException:  Empty tree");
        }
        else if (root.rightChild == null)
        {
            // assertion: nonempty tree; no right child
            root.rightChild = new TreeNode<T>(newItem, null, null);
        } // end if
    } // end attachRight

    public void attachLeftSubtree(BinaryTree<T> leftTree) throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException:  Empty tree");
        }
        else if (root.leftChild != null)
        {
            // a left subtree already exists; it should have been
            // deleted first
            throw new TreeException("TreeException: "
                    + "Cannot overwrite left subtree");
        }
        else
        {
            // assertion: nonempty tree; no left child
            root.leftChild = leftTree.root;
            // don't want to leave multiple entry points into
            // our tree
            leftTree.makeEmpty();
        } // end if
    } // end attachLeftSubtree

    public void attachRightSubtree(BinaryTree<T> rightTree) throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException:  Empty tree");
        }
        else if (root.rightChild != null)
        {
            // a right subtree already exists; it should have been
            // deleted first
            throw new TreeException("TreeException: "
                    + "Cannot overwrite right subtree");
        }
        else
        {
            // assertion: nonempty tree; no right child
            root.rightChild = rightTree.root;
            // don't want to leave multiple entry points into
            // our tree
            rightTree.makeEmpty();
        } // end if
    } // end attachRightSubtree

    protected BinaryTree(TreeNode<T> rootNode)
    {
        root = rootNode;
    } // end protected constructor

    public BinaryTree<T> detachLeftSubtree() throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException:  Empty tree");
        }
        else
        {
            // create a new binary tree that has root's left
            // node as its root
            BinaryTree<T> leftTree;
            leftTree = new BinaryTree<T>(root.leftChild);
            root.leftChild = null;
            return leftTree;
        } // end if
    } // end detachLeftSubtree

    public BinaryTree<T> detachRightSubtree() throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException:  Empty tree");
        }
        else
        {
            BinaryTree<T> rightTree;
            rightTree = new BinaryTree<T>(root.rightChild);
            root.rightChild = null;
            return rightTree;
        } // end if
    } // end detachRightSubtree

    public BinaryTree<T> getLeftSubtree() throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException:  Empty tree");
        }
        else
        {
            // Create a new binary tree that has root's left
            // node as its root.
            BinaryTree<T> leftTree;
            leftTree = new BinaryTree<T>(root.leftChild);

            return leftTree;
        }
    } // end of getLeftSubtree()

    public BinaryTree<T> getRightSubtree() throws TreeException
    {
        if (isEmpty())
        {
            throw new TreeException("TreeException:  Empty tree");
        }
        else
        {
            // Create a new binary tree that has root's right
            // node as its root.
            BinaryTree<T> rightTree;
            rightTree = new BinaryTree<T>(root.rightChild);

            return rightTree;
        }
    } // end of getRightSubtree()
} // end BinaryTree

// **************** class BinaryTreeBasis **********************
// A basic binary tree class for Reference-Based ADT Binary Tree.
abstract class BinaryTreeBasis<T>
{
    protected TreeNode<T> root;

    public BinaryTreeBasis()
    {
        root = null;
    } // end default constructor

    public BinaryTreeBasis(T rootItem)
    {
        root = new TreeNode<T>(rootItem, null, null);
    } // end constructor

    public boolean isEmpty()
    {
        // Returns true if the tree is empty, else returns false.
        return root == null;
    } // end isEmpty

    public void makeEmpty()
    {
        // Removes all nodes from the tree.
        root = null;
    } // end makeEmpty

    public T getRootItem() throws TreeException
    {
        // Returns the item in the tree's root.
        if (root == null)
        {
            throw new TreeException("TreeException: Empty tree");
        }
        else
        {
            return root.item;
        } // end if
    } // end getRootItem

    public abstract void setRootItem(T newItem);
    // Throws UnsupportedOperationException if operation
    // is not supported.

} // end BinaryTreeBasis

// **************** class TreeNode *****************************
// A node in a tree structure.
class TreeNode<T>
{
    T item;
    TreeNode<T> leftChild;
    TreeNode<T> rightChild;

    public TreeNode(T newItem)
    {
        // Initializes tree node with item and no children.
        item = newItem;
        leftChild = null;
        rightChild = null;
    } // end constructor

    public TreeNode(T newItem, TreeNode<T> left, TreeNode<T> right)
    {
        // Initializes tree node with item and
        // the left and right children references.
        item = newItem;
        leftChild = left;
        rightChild = right;
    } // end constructor
} // end TreeNode

// **************** class TreeException ************************
// This exception is thrown when tree is empty.
class TreeException extends RuntimeException
{
    public TreeException(String s)
    {
        super(s);
    } // end constructor
} // end TreeException

