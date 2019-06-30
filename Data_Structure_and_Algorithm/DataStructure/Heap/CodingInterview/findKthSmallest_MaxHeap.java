// Find k-th smallest element in an array. O(n log k)
// This code is good to know the usage of heap. 
// Note that you can actually get k-th smallest using partitioning, 
// which takes O(n) time. (findKthSmallest_partition.java)
// Author: Coursera "Mastering Software Engineer Interview" + kei
// https://www.coursera.org/learn/cs-tech-interview/lecture/Qu7hy/case-study-going-deeper
// Date  : October 24, 2016

public int kthSmallestViaHeap(int[] arr, int k) {
    if (k <= 0 || k > arr.length) {
        throw new IllegalArgumentException();
    }
    // 1. Create a max heap whose size is k.
    PriorityQueue<Integer> smallestK = 
            new PriorityQueue<Integer>(k, Collections.reverseOrder());
    // 2. Fill the heap.  
    for (int i = 0; i < Math.min(arr.length, k); i++) {
        smallestK.add(arr[i]);
    }
    // 3. Traverse the array and just keep k smallest elements in the heap.
    // Use for-loop because you don't need to flush out the elements in the heap. 
    for (int i = k; i < arr.length; i++) {
        if (arr[i] < smallestK.peek()) {
            smallestK.poll();  // O(log k)
            smallestK.add(arr[i]);  // O(log k)
        }
    }

    return smallestK.peek();
}






























