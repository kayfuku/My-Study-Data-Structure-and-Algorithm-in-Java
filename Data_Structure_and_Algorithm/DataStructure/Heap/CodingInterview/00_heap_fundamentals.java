//
// Author: kei
// Date  : June 28, 2019

package whiteboard;

import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;


public class ForCopy {


    public static void main(String[] args) {
        ForCopy solution = new ForCopy();

        // Your code here.

        int[] nums1 = new int[]{ 5, 1, 2, 7, 6, 3, 4 };

        // Min-Heap. 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums1) {
            boolean b = minHeap.offer(num);
            System.out.println(b);
        }
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // 1 2 3 4 5 6 7 
        }
        System.out.println();

        // Min-Heap. 
        PriorityQueue<Integer> minHeap2 = new PriorityQueue<>(Comparator.naturalOrder());
        for (int num : nums1) {
            boolean b = minHeap2.offer(num);
            System.out.println(b);
        }
        while (!minHeap2.isEmpty()) {
            System.out.println(minHeap2.poll()); // 1 2 3 4 5 6 7 
        }
        System.out.println();

        // Max-Heap.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums1) {
            boolean b = maxHeap.offer(num);
            System.out.println(b);
        }
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll()); // 7 6 5 4 3 2 1 
        }
        System.out.println();


        // Heap with Custom Comparator.
        int[] nums2 = new int[]{ 1, 1, 2, 2, 2, 3, 4 };

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Priority Queue gets Comparator written in lambda expression. 
        // n1 comes first if map.get(n1) - map.get(n2) < 0, which builds 
        // Min-Heap, where the top element is the smallest in the heap. 
        
        //        PriorityQueue<Integer> minHeap3 = 
        //                new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        // The statement above is equal to this. 
        PriorityQueue<Integer> minHeap3 = 
                new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer n1, Integer n2) {
                        return map.get(n1) - map.get(n2);
                    }
                });

        for (Integer num : map.keySet()) {
            boolean b = minHeap3.offer(num);
            System.out.println(b);
        }

        System.out.println(minHeap3.poll()); // 3
        System.out.println(minHeap3.poll()); // 4
        System.out.println(minHeap3.poll()); // 1
        System.out.println(minHeap3.poll()); // 2






        System.out.println();
        System.out.println("done.");
    }




}
























