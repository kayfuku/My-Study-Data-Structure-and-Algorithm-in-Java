// Search first occurrence of k using Binary Search. 
// Author: EPI 12.1 p.174 + kei
// Date  : December 27, 2016 

package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab_whiteboard {

    public static void main(String[] args) {

        Integer[] nums = new Integer[]{ -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 };
        ArrayList<Integer> alist = new ArrayList<>(Arrays.asList(nums));
        
        System.out.println(searchFirstOfK(alist, 108)); // 3
        System.out.println(searchFirstOfK(alist, 285)); // 6
        System.out.println(searchFirstOfK(alist, -13)); // -1
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    
    
    public static int searchFirstOfK(List<Integer> alist, int k) {
        int left = 0, right = alist.size() - 1, result = -1, mid;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (k == alist.get(mid)) {
                // We cannot return immediately here because 
                // there might be the duplicate values to the left of 'mid'.
                result = mid;
                // Nothing to the right of mid can be 
                // the first occurrence of k. 
                right = mid - 1;
            } else if (k < alist.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }           
        }
        
        return result;      
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

























