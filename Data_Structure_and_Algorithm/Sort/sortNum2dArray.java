// Sort elements of an 2D array by using the first element of each. 
// (By stackOverFlow)


package com.google.challenges;

import java.util.Arrays;

public class Rabbit
{

    public static void main(String[] args)
    {

        int[][] intervals = {{10, 14}, {4, 18}, {19, 20}, {19, 20}, {13, 20}};
        // int[][] intervals = {{10, 14}, {4, 18}, {19, 22}, {19, 20}, {13,20}};
        // int[][] intervals = {{1, 3}, {3, 6}};

        // Sort.
        Arrays.sort(intervals, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        
        System.err.println("done.");  
        return;
    }

}
