// 2D array fundamentals. 
// Author: kei
// Date  : May 29, 2019

package pack01;

import java.util.Arrays;



public class Lab01 {

    public static void main(String[] args) {
    
        
        int[][] nums = new int[][]{ { 2, 3 }, 
                                    { 1, 4 } };
        System.out.println(Arrays.toString(nums[0])); // [2, 3]
        System.out.println(Arrays.toString(nums[1])); // [1, 4]
        
        int[][] zeros = new int[0][0];
        int[][] zeros2 = new int[][]{};
        int[][] zeros3 = new int[0][];
//        System.out.println(Arrays.toString(zeros[0])); // ArrayIndexOutOfBoundsException
        System.out.println(Arrays.toString(zeros)); // []
        System.out.println(Arrays.toString(zeros2)); // []
        System.out.println(Arrays.toString(zeros3)); // []
        System.out.println(zeros == null); // false

        

    }


























}
























