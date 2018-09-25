// (By CS111C textbook)

import java.util.Scanner;


public class BinarySearchDemo {
	
	public static void main(String[] args) {
		
		String[] strings = {"a", "b", "c", "d", 
				            "e", "f", "g", "h",
				            "i", "j", "k", "l",
				            "m", "n", "o", "p"};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("What string do you want to search for?(a to p): ");
		String value = sc.nextLine();
		
		for (int i = 0; i < strings.length; i++) {
			System.out.println(i + ": " + strings[i]);
		}
		
		System.out.println();
		System.out.println("search string: " + value);
		System.out.println();

		int returnIndex = binarySearch(strings, 0, strings.length - 1, value);
		System.out.println("return index: " + returnIndex);
	}
	
	public static int binarySearch(String[] anArray, int first, int last, String value) {
        //Searches the array items anArray[first] through
        //anArray[last] for value by using a binary search.
        //Precondition: 0 <= first, last <= SIZE-1, where
        //SIZE is the maximum size of the array, and
        //anArray[first] <= anArray[first+1] <= ... <=
        //anArray[last].
        //Postcondition: If value is in the array, the method
        //returns the index of the array item that equals value;
        //otherwise the method returns -1.
        int index;
        if (first > last) {
            index = -1;      // value not in original array
        } else {
            // Invariant: If value is in anArray,
            //            anArray[first] <= value <= anArray[last]
            int mid = (first + last) / 2;
            if (value.equals(anArray[mid])) {
                index = mid;  // value found at anArray[mid]
            } else if (value.compareTo(anArray[mid]) < 0) {
            // point X
                index = binarySearch(anArray, first, mid - 1, value);
            } else {
            // point Y
                index = binarySearch(anArray, mid + 1, last, value);
            } // end if
        } // end if

        return index;
    } // end binarySearch
}













