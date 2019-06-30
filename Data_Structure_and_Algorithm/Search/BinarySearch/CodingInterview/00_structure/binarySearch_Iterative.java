// Binary Search. (array needs to be sorted in advance.)
// Iterative version. More efficient than recursive version. 
// Average Case : O(log N)

package whiteboard;

import java.util.Arrays;

public class ForCopy {

    public static void main(String[] args) {
        
        int[] array = new int[]{12, 70, 812, 45, -1, 39, 1, 0, 5};  
        Arrays.sort(array);
        System.out.println(Arrays.toString(array)); // [-1, 0, 1, 5, 12, 39, 45, 70, 812]
        System.out.println();
        System.out.println("right = mid - 1; version");
        System.out.println(binarySearchIter(array, 45)); // 6
        System.out.println(binarySearchIter(array, -1)); // 0
        System.out.println(binarySearchIter(array, 812)); // 8        
        System.out.println(binarySearchIter(array, 0)); // 1       
        System.out.println(binarySearchIter(array, 99)); // left: 8, -1
        System.out.println(binarySearchIter(array, 2)); // left: 3, -1
        System.out.println(binarySearchIter(array, -50)); // left: 0, -1
        System.out.println(binarySearchIter(array, 910)); // left: 9, -1
        System.out.println();
        System.out.println("right = mid; version");
        System.out.println(binarySearchIterKei(array, 45)); // 6
        System.out.println(binarySearchIterKei(array, -1)); // 0
        System.out.println(binarySearchIterKei(array, 812)); // 8
        System.out.println(binarySearchIterKei(array, 0)); // 1
        System.out.println(binarySearchIterKei(array, 99)); // left: 8, -1
        System.out.println(binarySearchIterKei(array, 2)); // left: 3, -1
        System.out.println(binarySearchIterKei(array, -50)); // left: 0, -1
        System.out.println(binarySearchIterKei(array, 910)); // left: 9, -1

        
        
        System.out.println();
        System.out.println("done.");
    }
    
    
    // right = mid; version. 
    // right = arr.length; while (left < right), right = mid; version. 
    // When x is not found, left ends up in the index at which the target would be, 
    // including index: arr.length. 
    // Note that the following combination of condition causes infinite loop 
    // when x is not in the array. 
    // right = arr.length - 1; while (left <= right), right = mid; 
    // Also, left = mid; causes infinite loop when x is not in the array. 
    // Author: kei.
    // Date  : June 12, 2019
    public static int binarySearchIterKei(int[] arr, int x) {
        int left = 0;
//        int right = arr.length - 1; // NG!
        int right = arr.length;
        int mid;

//        while (left <= right) { // NG!
        while (left < right) {
            // This could be 'left + (right - left) / 2;', which can 
            // prevent from integer overflow, but this is more readable. 
            mid = (left + right) / 2;

            if (x == arr[mid]) {
                return mid;
            }
            
            if (x < arr[mid]) {
                // Instead of right = mid - 1.
                right = mid;
            } else {
                left = mid + 1;
//                left = mid;
            }
        }

        // Not found. 
        System.out.printf("left: %d\n", left);
        return -1;
    }


    // right = mid - 1; version. 
    // right = arr.length - 1; while (left <= right), 
    // When x is not found, left ends up in the index at which the target would be. 
    // Also, left = mid causes infinite loop when x is the last element or not in the array. 
    // Author: PIE p.113 + kei.
    // Date  : June 12, 2019
    public static int binarySearchIter(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
//        int right = arr.length; // NG!
        int mid;

        while (left <= right) {
//        while (left < right) { // NG!
            // This could be 'left + (right - left) / 2;', which can 
            // prevent from integer overflow, but this is more readable. 
            mid = (left + right) / 2;

            if (x == arr[mid]) {
                return mid;
            } 
            
            if (x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
//                left = mid;
            }
        }

        // Not found. 
        System.out.printf("left: %d\n", left);
        return -1;
    }


    // Author: CtCI p.149  + kei.
    // Date  : February 11, 2016
    int binarySearchIterative(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] < x) {
                // Search the right side.
                left = mid + 1;
            } else if (array[mid] > x) {
                // Search the left side. 
                right = mid - 1;
            } else {
                // Found x. 
                return mid;
            }
        }

        // Not found.
        return -1;
    }




    

}

















