// Binary Search.
// Iterative version. O(log N)
// Author: アルゴリズムを学ぼう p.31  + kei.
// Date  : September 27, 2016


// Pre: array is sorted.
boolean contains_BinarySearch(int[] array, int x) {
    if (array.length == 0) {
        return false;
    }

    // right is index one after the tail index.
    int left = 0, right = array.length;
    // If left is next to right, then loop breaks.
    // In other words, the array size is 1, then loop breaks.
    while (left + 1 < right) {
        // mid = (left + right) / 2 might cause int overflow.
        int mid = left + (right - left) / 2;

        if (x < array[mid]) {
            right = mid;
        } else {
            left = mid;
        }
    }

    return x == array[left];
}


















