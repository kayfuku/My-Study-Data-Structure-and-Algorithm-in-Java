// Sort numeric values in array. 
// (By Myself)


package com.google.challenges;

import java.util.Arrays;

public class Rabbit
{

    public static void main(String[] args)
    {

        int[] x = {2, 5, 7, 4, 4, 8, 3};
        
        // Sort the array. 
        Arrays.sort(x);
        
        for (int num : x)
        {
            System.out.println(num);                       
        }
        
        
        
        System.err.println("done.");  
        return;
    }

}
