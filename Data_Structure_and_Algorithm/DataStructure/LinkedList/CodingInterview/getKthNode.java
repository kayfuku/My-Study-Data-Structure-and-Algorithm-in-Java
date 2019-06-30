// Get the k-th node starting with 0. 
// ex. k=3
// 1 - 2 - 3 - 4   
//             |
//             p
// Author: CtCI 2.7 p.222 + kei
// Date  : October 23, 2016
public static SLLNode<Integer> getKthNode(SLLNode<Integer> node, int k) {
    // You can use formal argument because in Java it's always 'pass by value'.
    while (k > 0 && node != null) {
        node = node.next;
        k--;
    }
    // Note that if k > len - 1, then return null.
    return node;
}


// Get the k-th node starting with 1. 
// ex. k=3
// 1 - 2 - 3 - 4   
//         |
//         p
// Author: kei
// Date  : December 22, 2018
public static SLLNode<Integer> getKthNode2(SLLNode<Integer> node, int k) {
    if (node == null || k <= 0) {
        return null;
    }

    // The pointer must move k - 1 times to the next node, not null end. 
    // So, node == null means k is bigger than the length of the list. 
    while (k - 1 > 0 && node != null) {
        node = node.next;
        k--;
    }
    return node;
}













































