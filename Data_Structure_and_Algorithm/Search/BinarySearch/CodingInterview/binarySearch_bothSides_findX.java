// Binary Search variant. 
// Find i such that arr[i] = i.
// The sorted array does not contain duplicate element. 
// Author: CtCI 8.3 p.346 + kei.
// Date  : December 30, 2018
int binarySearch_magic(int[] arr) {
    return binarySearch_magic(arr, 0, arr.length - 1);
}
int binarySearch_magic(int[] arr, int left, int right) {
  if (left > right) {
    return -1;
  }

  int mid = (left + right) / 2;
  if (arr[mid] == mid) {
    return mid;
  } else if (arr[mid] > mid) {
    return binarySearch_magic(arr, left, mid - 1);
  } else {
    return binarySearch_magic(arr, mid + 1, right);
  }
}


// The sorted array may contain duplicate elements. 
// Find i such that arr[i] = i.
// Search both the left and right side. Return the first index found. 
// If there are two indices, one is on the left, the other is on the right, 
// then return the left one. 
// Author: CtCI 8.3 p.347 + kei.
// Date  : October 6, 2016
int binarySearch_bothSides_findX(int[] arr) {
    return binarySearch_bothSides_findX(arr, 0, arr.length - 1);
}

int binarySearch_bothSides_findX(int[] arr, int left, int right) {
    // Base case. 
    if (right < left) {
        // Not found. 
        return -1;
    }
    int midIndex = (left + right) / 2;
    if (arr[midIndex] == midIndex) {
        return midIndex;
    }

    // First, search the left side. 
    // Math.min(...) is used for narrowing the search scope. 
    int returnIndexL = binarySearch_bothSides_findX(
                           arr, left, Math.min(midIndex - 1, arr[midIndex]));
    if (returnIndexL >= 0) {
        // Found.
        return returnIndexL;
    }

    // Not found in the left side. 
    // Then, search the right side. 
    // Math.max(...) is used for narrowing the search scope. 
    int returnIndexR = binarySearch_bothSides_findX(
                           arr, Math.max(midIndex + 1, arr[midIndex]), right);
    return returnIndexR;

}

























