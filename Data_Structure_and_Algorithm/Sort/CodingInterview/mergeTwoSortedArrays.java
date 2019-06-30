// Merge two sorted arrays. 
// Author: CtCI 10.1 p.396 + kei
// Date  : December 8, 2016

package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Lab_whiteboard {

    public static void main(String[] args) {

        int[] sortedArray1 = new int[]{ 2, 4, 5, 8, 10, 0, 0, 0 };
        int[] sortedArray2 = new int[]{ 3, 6, 7 };
        int[] sortedArray3 = new int[]{ 0, 1, 7 };
        
        mergeTwoSortedArrays(sortedArray1, sortedArray2, 5, sortedArray2.length);
        System.out.println(Arrays.toString(sortedArray1)); // [2, 3, 4, 5, 6, 7, 8, 10]
        mergeTwoSortedArrays(sortedArray1, sortedArray3, 5, sortedArray3.length);
        System.out.println(Arrays.toString(sortedArray1)); // [0, 1, 2, 3, 4, 5, 6, 7]
        
        System.out.println();
        System.out.println("done.");
    } // end main().
    
    public static void mergeTwoSortedArrays(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastA + lastB - 1;
        
        // If b finishes first, then it's done. 
        // If a finishes first, then we need to continue copying b to a. 
        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                // a <= b or a finished. 
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
        
        
    }
    
    
    
    

    
    

    

}











