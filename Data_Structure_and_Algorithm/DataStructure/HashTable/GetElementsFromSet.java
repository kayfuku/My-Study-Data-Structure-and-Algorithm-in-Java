// Get elements from a set.
// Codility, OddOccurrencesInArray.
// 100% (100 out of 100).
// Author: Kei Fukutani
// Date  : February 22, 2016

package codility;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array1 = { 9, 3, 9, 3, 9, 7, 9 };		
		System.out.println(solution(array1));
		
		
	}

	public static int solution(int[] A) {
		// write your code in Java SE 8
		Set<Integer> set = new HashSet<>();
		
		for (int integer : A) {
			if (set.contains(integer)) {
				set.remove(integer);
			} else {
				set.add(integer);
			}
		}
		
		// Get some elements from the set.
		Object[] integers = set.toArray();
		
		return (int) integers[0];
	} // end solution()

	
	
	
	
	
	
	
	

}
