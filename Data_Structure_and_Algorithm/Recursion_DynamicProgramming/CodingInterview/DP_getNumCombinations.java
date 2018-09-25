// Get number of combinations. 
// ex. (1 2 3 4 6 7), sum: 10  --> 5 
//     (1 2 7), (3 7), (1 3 6), (4 6), (1 2 3 4)
// Author: kei
// Date  : December 28, 2016 

package whiteboard;

import java.util.HashMap;


public class Lab_whiteboard {

    public static void main(String[] args) {

        
        int[] nums = new int[]{ 1, 1, 2, 3, 4, 6, 8 };
        int sum = 10;
        int res = getNumCombinations(nums, sum);
        System.out.println(res); // 8
        
        int[] nums2 = new int[]{ 1, 2, 1, 3, 1};
        int sum2 = 3;
        int res2 = getNumCombinations(nums2, sum2);
        System.out.println(res2); // 5

        int[] nums3 = new int[]{ 1, 2, 3, 4, 6, 7 };
        int sum3 = 10;
        int res3 = getNumCombination(nums3, sum3);
        System.out.println(res3); // 5

        
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    
    
    // Get number of combinations. 
    // Author: kei
    // Date  : December 28, 2016 
    public static int getNumCombinations(int[] nums, int sum) {
        HashMap<Integer, HashMap<Integer, Integer>> memo = new HashMap<>();
        return getNumCombinations(nums, sum, 0, memo);       
    }
    public static int getNumCombinations(int[] nums, int sum, int index, 
                                         HashMap<Integer, HashMap<Integer, Integer>> memo) {
        // Base case.
        if (sum == 0) {
            return 1;
        }
        if (index >= nums.length || sum < 0) {
            return 0;
        }
        
        // Recall from memo.
        if (memo.containsKey(sum) && memo.get(sum).containsKey(index)) {
            return memo.get(sum).get(index);
        }
        
        // Recursion. 
        int count = getNumCombination(nums, sum, index + 1, memo)
                    + getNumCombination(nums, sum - nums[index], index + 1, memo);
        
        // Insert into memo.
        HashMap<Integer, Integer> indexToCount = new HashMap<>();
        indexToCount.put(index, count);
        memo.put(sum, indexToCount);
        
        return count;       
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}

























