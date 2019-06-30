// Find a value in a rotated sorted array.
// Author: CtCI 10.3 p.399 + kei.
// Date  : February 13, 2016, January 6, 2019

package whiteboard;

public class Lab_whiteboard {

    public static void main(String[] args) {

        int[] arr1 = new int[]{ 3, 4, 5, 0, 1, 2 };
        int[] arr2 = new int[]{ 3, 4, 5, 0, 1, 1, 2 };
        int[] arr3 = new int[]{ 0, 1, 7 };

        System.out.println(binarySearchInRotatedSortedArray(arr1, 0, arr1.length - 1, 2)); // 5
        System.out.println(binarySearchInRotatedSortedArray(arr2, 0, arr2.length - 1, 2)); // 6
        System.out.println(binarySearchInRotatedSortedArray(arr3, 0, arr3.length - 1, 0)); // 0
        System.out.println(binarySearchInRotatedSortedArray(arr1, 0, arr1.length - 1, 8)); // -1



        System.out.println();
        System.out.println("done.");
    } // end main().

    public static int binarySearchInRotatedSortedArray(
            int[] array, int left, int right, int x) {
        if (right < left) {
            return -1;
        }

        // Binary Search preparation.
        int mid = (left + right) / 2;

        // Found x.
        if (array[mid] == x) {
            return mid;
        }

        // Binary Search.
        // Search range varies depending on the value of 
        // left-most, mid, and right-most in the array.
        if (array[left] < array[mid]) { 
            // The left half is in increasing order.
            if (x >= array[left] && x <= array[mid]) {
                // Search the left half.
                return binarySearchInRotatedSortedArray(array, left, mid - 1, x);
            } else {
                // Search the right half.
                return binarySearchInRotatedSortedArray(array, mid + 1, right, x);
            }        
        } else if (array[left] > array[mid]) { 
            // The right half is in increasing order.
            if (x >= array[mid] && x <= array[right]) {
                // Search the right half.
                return binarySearchInRotatedSortedArray(array, mid + 1, right, x);
            } else {
                // Search the left half.
                return binarySearchInRotatedSortedArray(array, left, mid - 1, x);
            }        
        } else if (array[left] == array[mid]) {
            if (array[mid] != array[right]) {
                // Search the right half.
                return binarySearchInRotatedSortedArray(array, mid + 1, right, x);
            } else {
                // array[left] == array[mid] == array[right]
                // Both halves need to be searched.
                // Search the left half.
                int result = binarySearchInRotatedSortedArray(array, left, mid - 1, x);
                if (result == -1) {
                    // Search the right half.
                    return binarySearchInRotatedSortedArray(array, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        } // end else if (array[left] == array[mid]) {

        // Not found.
        return -1;
    }










}











