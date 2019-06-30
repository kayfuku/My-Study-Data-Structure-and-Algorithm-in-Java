// Given an integer array and target integer, 
// find two integers that the sum of them is the target. 
// Author: Ryu Morihiro (A world class engineer book author) + kei
// Date  : February 5, 2017 

package whiteboard;

import java.util.HashSet;


public class Lab_whiteboard {

    public static void main(String[] args) {

        int[] array = new int[]{ 2, 5, 3, 6, -3, 0, 1 };
        int target = 5;
        System.out.println(findSumElements(array, target)); // 3
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    
    
    // O(N) time, O(N) space. 
    public static int findSumElements(int[] array, int target) {
        HashSet<Integer> visited = new HashSet<>();
        
        for (int e : array) {
            if (visited.contains(target - e)) {
                return e;
            } else {
                visited.add(e);
            }           
        }
        
        throw new RuntimeException();
    }
    
    
    
    
    
    
    
    
    
    
    
    
}

























