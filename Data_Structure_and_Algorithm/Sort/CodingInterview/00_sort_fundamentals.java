//
// Author: kei
// Date  : June 13, 2019

package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ForCopy {

    public static void main(String[] args) {
        ForCopy solution = new ForCopy();

        int[] numsInts = new int[]{ 4, 3, 1, 2, 0, 6, 5 };
        Integer[] numsIntegers = new Integer[]{ 4, 3, 1, 2, 0, 6, 5 };
        String[] strs = new String[]{ "a", "b", "aa", "A", "B", "1", "2", "0" };
        List<Integer> numsList = new ArrayList<>(Arrays.asList(numsIntegers));


        // Basics. 
        // Author: EPI p.216 + internet + kei.
        // Date  : November 1, 2016

        // Sort in ascending order. 
        System.out.println("Sort in ascending order.");

        // Sort int[] in ascending order. 
        // O(N log N) time, O(N) (O(N/2)) space for randomly ordered inputs. 
        // O(N) time, O(1) space for nearly sorted inputs. 
        System.out.println("Sort int[].");
        Arrays.sort(numsInts);  
        System.out.println(Arrays.toString(numsInts)); // [0, 1, 2, 3, 4, 5, 6] 

        // Sort Strings[] in ascending/lexicographical order. 
        System.out.println("Sort Strings[].");
        Arrays.sort(strs);  
        System.out.println(Arrays.toString(strs)); // [0, 1, 2, A, B, a, aa, b] 

        // Sort ArrayList in ascending order. 
        System.out.println("Sort ArrayList.");
        System.out.println(numsList.toString()); // [4, 3, 1, 2, 0, 6, 5]
        Collections.sort(numsList);
        System.out.println(numsList.toString()); // [0, 1, 2, 3, 4, 5, 6]
        numsList.sort(Comparator.naturalOrder());
        System.out.println(numsList.toString()); // [0, 1, 2, 3, 4, 5, 6]
        System.out.println();

        
//        Arrays.sort(numsInts, (x, y) -> Integer.compare(y, x));   




        // Sort in descending order. 
        System.out.println("Sort in descending order.");

        // Sort Integer[] in descending order. 
        // Integer[] is ok, but int[] is not ok. 
        System.out.println("Sort Integer[].");
        Arrays.sort(numsIntegers, Comparator.reverseOrder()); 
        System.out.println(Arrays.toString(numsIntegers)); // [6, 5, 4, 3, 2, 1, 0]

        // Sort Strings[] in descending order. 
        System.out.println("Sort Strings[].");
        Arrays.sort(strs, Comparator.reverseOrder());  
        System.out.println(Arrays.toString(strs)); // [b, aa, a, B, A, 2, 1, 0]

        // Sorting primitive type int in descending order is a little hassle. 
        // Convert ints to Integers first. 
        //      Arrays.sort(numsInts, Comparator.reverseOrder()); // Compiler error. 
        System.out.println("Sort int[].");
        Integer[] numsIntsReverse = new Integer[numsInts.length];
        for (int i = 0; i < numsIntsReverse.length; i++) {
            numsIntsReverse[i] = numsInts[i];
        }
        Arrays.sort(numsIntsReverse, Comparator.reverseOrder()); 
        System.out.println(Arrays.toString(numsIntsReverse)); // [6, 5, 4, 3, 2, 1, 0]

        // Sort ArrayList in descending order. 
        System.out.println("Sort ArrayList.");
        System.out.println(numsList.toString()); // [0, 1, 2, 3, 4, 5, 6]
        Collections.sort(numsList, Collections.reverseOrder());
        System.out.println(numsList.toString()); // [6, 5, 4, 3, 2, 1, 0]
        numsList.sort(Comparator.reverseOrder());
        System.out.println(numsList.toString()); // [6, 5, 4, 3, 2, 1, 0]
        System.out.println();



        // Custom Sorting. 

        // Sort objects in an array using Comparator. 
        // Author: PIE p.76 + kei.
        // Date  : November 1, 2016
        System.out.println("Custom Sorting");
        Node[] nodesArray = new Node[10];
        Random rand = new Random();
        for (int i = 0; i < nodesArray.length; i++) {
            int val = rand.nextInt(10);
            Node node = solution.new Node(val);
            nodesArray[i] = node;
        }
        System.out.println(Arrays.toString(nodesArray)); // [6, 8, 9, 0, 2, 0, 9, 1, 5, 5]

        // Sort in ascending order. 
        Arrays.sort(nodesArray, new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                int n1 = node1.val, n2 = node2.val;
                return Integer.compare(n1, n2);
            }
        });
        System.out.println(Arrays.toString(nodesArray)); // [0, 0, 1, 2, 5, 5, 6, 8, 9, 9]

        // Sort in descending order. 
        Arrays.sort(nodesArray, new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                int n1 = node1.val, n2 = node2.val;
                // Reverse the order. 
                return Integer.compare(n2, n1);
            }
        });
        System.out.println(Arrays.toString(nodesArray)); // [9, 9, 8, 6, 5, 5, 2, 1, 0, 0]
        System.out.println();


        // Sort Strings using custom Comparator. 
        System.out.println("Sort Strings using custom Comparator.");

        strs = new String[]{ "3", "1", "2" };
        Arrays.sort(strs, solution.new StringComparator());
        System.out.println(Arrays.toString(strs)); // [1, 2, 3] 
        
        strs = new String[]{ "3", "1", "2" };
        Arrays.sort(strs, solution.new StringComparatorReverse());
        System.out.println(Arrays.toString(strs)); // [3, 2, 1] 

        strs = new String[]{ "3", "30", "34", "5", "9" };
        Arrays.sort(strs, solution.new StringComparator());
        System.out.println(Arrays.toString(strs)); // [3, 30, 34, 5, 9] 
        Arrays.sort(strs, solution.new StringComparatorReverse());
        System.out.println(Arrays.toString(strs)); // [9, 5, 34, 30, 3] 
        Arrays.sort(strs, solution.new LargeNumberComparator());
        System.out.println(Arrays.toString(strs)); // [9, 5, 34, 3, 30]  








        System.out.println();
        System.out.println("done.");
    }

    class Node {
        int val;

        public Node(int v) {
            this.val = v;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }


    // Author: LeetCode + kei. https://leetcode.com/problems/largest-number/solution/
    // Date  : June 13, 2019
    private class LargeNumberComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String numStr1 = o1 + o2; // 330
            String numStr2 = o2 + o1; // 303
            // Reverse order because I want larger one come first. 
            // Arrange o1 and o2 such that o1 comes first if numStr1 is larger than numStr2. 
            return numStr2.compareTo(numStr1);
        }
    }

    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            // Natural order.
            // Arrange o1 and o2 such that o1 comes first if o1 is smaller than o2. 
            return o1.compareTo(o2);
        }
    }

    private class StringComparatorReverse implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            // Reverse order.
            // Arrange o1 and o2 such that o1 comes first if o1 is larger than o2. 
            return o2.compareTo(o1);
        }
    }


    // Author: EPI p.216 + kei.
    // Date  : November 16, 2016
    public static class Student implements Comparable<Student> {
        public String name;
        public double gpa;

        Student(String name, double gradePointAverage) {
            this.name = name;
            this.gpa = gradePointAverage;
        }

        @Override
        public int compareTo(Student that) {
            return name.compareTo(that.name);
        }
    }

    public static void sortByName(List<Student> students) {
        Collections.sort(students);
    }

    public static void sortByGPA(List<Student> students) {
        Collections.sort(students, Collections.reverseOrder(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return Double.compare(a.gpa, b.gpa);

            }
        }));
    }


    // How to break ties. 
    // For sorting by descending GPA with ties broken on name. 
    // Author: EPI p.173 + kei 
    // Date  : December 27, 2016 
    public static final Comparator<Student> compGPA = new Comparator<Student>() {
        @Override
        public int compare(Student a, Student b) {
            if (a.gpa != b.gpa) {
                return Double.compare(a.gpa, b.gpa);
            }
            // 'a.gpa' equals to 'b.gpa'.
            return a.name.compareTo(b.name);
        }
    };
























}
























