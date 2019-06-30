// canBalance (Google Student, CodingBat, Array-3) 
// Given a non-empty array, return true if there is a place 
// to split the array so that the sum of the numbers on one side 
// is equal to the sum of the numbers on the other side.
// ex. 
// canBalance([1, 1, 1, 2, 1]) → true
// canBalance([2, 1, 1, 2, 1]) → false
// canBalance([10, 10]) → true
//
// Author: kei (All Correct)
// Date  : September 19, 2018


public boolean canBalance(int[] nums) {
  if (nums.length == 1) {
    return false;
  }
  
  int sum = 0;
  HashSet<Integer> set = new HashSet<>();
  // O(n)
  for (int n : nums) {
    sum += n;
    // Point! 
    set.add(sum);
  }
  
  // Don't forget this. 
  if (sum % 2 == 1) {
    return false;
  }

  return set.contains(sum / 2);
}






















