// Binary Search fundamentals. 
// Author: kei


// Return the index of the key if the key is present. 
// Otherwise, return (-(insertion point) - 1). 
// Note that this guarantees that the return value 
// will be >= 0 if and only if the key is found.

// O(log N), where N is length of the array. 
Arrays.binarySearch(array, 3);     

Collections.binarySearch(list, 3); 
Collections.binarySearch(list, 3, comparator); 


int[] nums = new int[]{ 2, 3, 5, 6, 8, 9 };
System.out.println(Arrays.binarySearch(nums, 6)); // 3
System.out.println(Arrays.binarySearch(nums, 4)); // -3
System.out.println(Arrays.binarySearch(nums, 17)); // -7


// Return true if the target is found in the list. 
public static boolean searchStudent(List<Student> students, Student target, 
                                    Comparator<Student> compGPA) {
    return Collections.binarySearch(students, target, compGPA) >= 0;
}






























