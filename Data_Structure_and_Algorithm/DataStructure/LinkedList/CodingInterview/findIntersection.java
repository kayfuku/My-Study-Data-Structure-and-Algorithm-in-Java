// Find intersection.
// This can be used in Tree problems. 
// Much better solution is available. 
// Take a look at leetcode/IntersectionOfTwoLinkedLists.java
// Author: CtCI 2.7 p.222 + kei
// Date  : October 23, 2016

ListNode findIntersection(ListNode list1, ListNode list2) {
    if (list1 == null || list2 == null) {
        return null;
    }

    // Get tail and sizes.
    Result result1 = getTailAndSize(list1);
    Result result2 = getTailAndSize(list2);

    // If different tail nodes, there's no intersection.
    if (result1.tail != result2.tail) {
        return null;
    }

    // Preparation for collision detection.
    // Set pointers to the start of each linked list.
    ListNode shorter = result1.size > result2.size ? list2 : list1;
    ListNode longer = result1.size > result2.size ? list1 : list2;

    // Advance the pointer for the longer linked list 
    // by difference in lengths.
    longer = getKthNode(longer, Math.abs(result1.size - result2.size));

    // Move both pointers until you have a collision. 
    while (shorter != longer) {
        shorter = shorter.next;
        longer = longer.next;
    }

    // Return either one.
    return longer;
}


// To get two return values, create your own class for result. 
class Result {
    public ListNode tail;
    public int size;

    public Result(ListNode tail, int size) {
        this.tail = tail;
        this.size = size;
    }
}

// Get tail node and list size.
Result getTailAndSize(ListNode node) {
    if (node == null) {
        return null;
    }

    int size = 1;
    // If the node.next is not null, then there should be one more node. 
    while (node.next != null) {
        // So, increment the size. 
        size++;
        node = node.next;
    }

    // This can also be good for just getting the size, but 
    // 'node' does not refer to tail node after the loop. 
    // int size = 0;
    // while (node != null) {
    //     size++;
    //     node = node.next;
    // }

    return new Result(node, size);
}

// Get k-th node.
ListNode getKthNode(ListNode node, int k) {
    while (k > 0 && node != null) {
        node = node.next;
        k--;
    }
    return node;
}


































