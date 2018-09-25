// Count the occurance of switching through the array, 
// keeping track of max. 
// Author: a topcoder + kei
// Date : December 14, 2016

package topcoder;

public class AlternatingString {

	// main method should be eliminated before submitting.
	// This is just for testing of your choice other than built-in test.
	public static void main(String[] args) {
		String s = "1010101";
		System.out.println(maxLength(s)); // 7 

	}

	// Author: a topcoder + kei
	// Date : December 14, 2016
	public static int maxLength(String s) {
		int max = 1, curr = 1;

		for (int i = 1; i < s.length(); i++) {

			if (s.charAt(i) != s.charAt(i - 1)) {
				curr++;
			} else {
				curr = 1;
			}

			max = Math.max(max, curr);
		}

		return max;
	}

	// Author: kei
	// Date : December 14, 2016
	public static int maxLength_kei(String s) {
		// No need!
		if (s.length() == 1) {
			return 1;
		}

		int max = 1;
		int len = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				len++;
			} else {
				// Get max each loop!
				max = Math.max(max, len);
				len = 1;
			}
		}
		max = Math.max(max, len);

		return max;
	}

}
