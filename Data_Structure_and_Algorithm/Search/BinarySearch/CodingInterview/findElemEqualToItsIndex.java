// Search the element that equals to its index in an sorted array. 
// Return any index that meets the requisite. 
// Author: EPI 12.2 p.176 + kei
// Date  : February 26, 2017 

package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Lab_whiteboard {

    public static void main(String[] args) {

        
        Integer[] array = new Integer[]{ -2, 0, 2, 3, 6, 7, 9 };
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        

        System.out.println(searchEntryEqualToItsIndex(list)); // 3 
        
        
        
        
        
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    
    
    // Search the element that equals to its index in an sorted array.
    // Return any index that meets the requisite. 
    // Author: EPI 12.2 p.176 + kei
    // Date  : February 26, 2017 
    public static int searchEntryEqualToItsIndex(List<Integer> array) {
        int left = 0, right = array.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Point! 
            int diff = array.get(mid) - mid;
            
            if (diff == 0) {
                return mid;
            } else if (diff > 0) {
                // Search left 
                right = mid - 1;                
            } else { // diff < 0
                // Search right 
                left = mid + 1;
            }           
        }
        
        return -1;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

























