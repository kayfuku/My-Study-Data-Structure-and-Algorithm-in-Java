// Every integer appears exactly twice in an array except for 
// one integer which appears only once. 
// Find the integer in the array. (Odd Man Out)
// Author: Google Handout Person B + kei
// Date  : February 5, 2017 

package whiteboard;



public class Lab_whiteboard {

    public static void main(String[] args) {

        
        
        int[] array = new int[]{ 3, 4, 3, 5, 4, 1, 1 };
        System.out.println(oddManOut(array)); // 5

        
        int[] array2 = new int[]{ 0, 1, 1 };
        System.out.println(oddManOut(array2)); // 0

        
        
        
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    

    // O(n) time, O(1) space. 
    // Author: Google Handout Person B + kei
    // Date  : February 5, 2017 
    public static int oddManOut(int[] array) {

        int val = 0;
        for (int i = 0; i < array.length; i++) {
            // XOR cancels out two identical numbers. 
            val ^= array[i];
        }

        return val;
    }






    
    
    
    
    
    
    
    
    
    
    
}

























