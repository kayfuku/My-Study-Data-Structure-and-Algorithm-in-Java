// Remove dups in a sorted array in place and return the new length. 
// Author: LeetCode + kei
// Date  : February 12, 2017

package whiteboard;


public class Lab_whiteboard {

    public static void main(String[] args) {
        
        
        
        
        

        int[] nums = new int[] { 1, 1, 2, 2, 4, 5, 5, 5, 5 };
        System.out.println(removeDuplicates(nums)); // 4

        
        
        
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().

    
    
    // Remove dups in a sorted array in place and return the new length. 
    // Author: LeetCode + kei
    // Date  : February 12, 2017
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[p] = nums[i];
                p++;
            }
        }

        return p;
    }

//  public static int removeDuplicates2(int[] nums) {
//
//      int count = 0;
//      for (int i = 1; i < nums.length; i++) {
//          if (nums[i] == nums[i - 1]) {
//              count++;
//          }
//      }
//
//      return nums.length - count;
//  }
//
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
















