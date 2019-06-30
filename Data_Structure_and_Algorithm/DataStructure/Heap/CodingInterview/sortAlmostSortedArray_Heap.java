// Sort an almost sorted array. 
// Each number is within k positions including its correctly sorted position. 
// Author: EPI 11.3 p.164 + kei
// Date  : November 28, 2016

package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;


public class Lab_whiteboard {

    public static void main(String[] args) {

        Integer[] nums = new Integer[]{ 3, -1, 2, 6, 4, 5, 8, 10, 7, 9 };
        List<Integer> list = new ArrayList<>(Arrays.asList(nums));
        ArrayList<Integer> sortedList = sortAlmostSortedArray(list, 3);   
        System.out.println(sortedList.toString()); // [-1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    
    
    // O(n log k) time.
    // O(k) space. 
    public static ArrayList<Integer> sortAlmostSortedArray(List<Integer> list, int k) {
        if (k > list.size()) {
            throw new IllegalArgumentException();
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Fill the heap. 
        Iterator<Integer> iter = list.iterator();
        for (int i = 0; i < k; i++) {
            minHeap.add(iter.next());
        }

        // Use while-loop because you need to flush out the elements in the heap. 
        Integer n;
        while ((n = minHeap.poll()) != null) {
            result.add(n);
            if (iter.hasNext()) {
                minHeap.add(iter.next());
            }           
        }
        
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

























