// Find list node collision.
// Author: CtCI 6th p.222 + kei
// Date  : October 23, 2016


while (node1 != node2) {
    node1 = node1.next;
    node2 = node2.next;
}

// Return either one.
return node1;

// or you can use hash table
// to detect the same node. 



