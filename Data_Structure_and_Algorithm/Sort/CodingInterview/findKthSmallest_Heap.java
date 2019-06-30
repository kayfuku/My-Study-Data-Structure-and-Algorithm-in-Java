// Find k-th smallest element in an array. O(n log k)
// Author: Coursera "Mastering Software Engineer Interview" + kei
// https://www.coursera.org/learn/cs-tech-interview/lecture/Qu7hy/case-study-going-deeper
// Date  : October 24, 2016

public int kthSmallestViaHeap(int[] arr, int k) {
    if (k <= 0 || k > arr.length) {
        throw new IllegalArgumentException();
    }
    // Create a max heap whose size is k.
    PriorityQueue<Integer> maxHeap = 
            new PriorityQueue<Integer>(k, Collections.reverseOrder());

    // Fill the heap by adding array elements. 
    for (int i = 0; i < Math.min(arr.length, k); i++) {
        maxHeap.add(arr[i]);
    }
    // Traverse the array and just keep k smallest elements in the heap.
    for (int i = k; i < arr.length; i++) {
        if (arr[i] < maxHeap.peek()) {
            // If the element is smaller than the max, 
            // remove the max and add the element to the heap. 
            maxHeap.poll();
            maxHeap.add(arr[i]);
        }
    }

    // After the traversal, the max is k-th smallest element in the array. 
    return maxHeap.peek();
}






























