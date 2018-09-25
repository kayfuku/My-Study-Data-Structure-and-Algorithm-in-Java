// Find a min value in a rotated sorted array. (EPI version)
// Author: EPI 12.3 p.177 + kei.
// Date  : February 26, 2017

package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Lab_whiteboard {

    public static void main(String[] args) {

        
        Integer[] ints = new Integer[]{ 3, 4, 5, 0, 1 };
        List<Integer> list = new ArrayList<>(Arrays.asList(ints));
        System.out.println(binarySearchInRotatedSortedArray(list)); // 3 

        
        ints = new Integer[]{ 1, 0, 1, 1, 1, 1, 1, 1 };
        list = new ArrayList<>(Arrays.asList(ints));
        System.out.println(binarySearchInRotatedSortedArray(list)); // 1 
        
        
        
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    
    
    // Find a value in a rotated sorted array. (EPI version)
    // Author: EPI 12.3 p.177 + kei.
    // Date  : February 26, 2017
    public static int binarySearchInRotatedSortedArray(List<Integer> list) {
        return binarySearchInRotatedSortedArray(list, 0, list.size() - 1);      
    }
    private static int binarySearchInRotatedSortedArray(
            List<Integer> list, int left, int right) {
        if (left == right) { // right = mid pattern. 
            return left;
        }
        
        int mid = left + (right - left) / 2;
        
        // Problem like this, rotated sorted array, it is better to compare
        // mid with right, instead of mid with left. 
        if (list.get(mid) > list.get(right)) {
            // Search right.
            return binarySearchInRotatedSortedArray(list, mid + 1, right);
        } else if (list.get(mid) < list.get(right)) {
            // Search left. 
            return binarySearchInRotatedSortedArray(list, left, mid); // right = mid pattern
        } else { // list.get(mid) == list.get(right)
            // We do not know on which side the target is. 
            int leftResult = binarySearchInRotatedSortedArray(list, left, mid);
            int rightResult = binarySearchInRotatedSortedArray(list, mid + 1, right);
            return list.get(rightResult) < list.get(leftResult) ? rightResult : leftResult;
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}

























