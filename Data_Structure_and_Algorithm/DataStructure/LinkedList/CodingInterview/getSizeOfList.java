// Get the size of the list.
// Author: CtCI 2.6 p.220 + kei
// Date  : October 19, 2016
public static int getSizeOfList(SLLNode<Integer> node) {
    // Start from 0.
    int size = 0; 
    while (node != null) {
        size++;
        node = node.next;
    }
    return size;        
}


// Get the size of the list. The pointer refers to the last node 
// after the loop, which is useful to return the node. 
// Author: CtCI 2.7 p.223 + kei
// Date  : December 23, 2018
public static Node getSizeOfList2(SLLNode<Integer> node) {
    if (node == null) {
        return null;
    }

    // Start from 1. 
    int size = 1;
    // If the node.next is not null, then there should be one more node. 
    while (node.next != null) {
        // So, increment the size. 
        size++;
        node = node.next;
    }

    return node;
}
































