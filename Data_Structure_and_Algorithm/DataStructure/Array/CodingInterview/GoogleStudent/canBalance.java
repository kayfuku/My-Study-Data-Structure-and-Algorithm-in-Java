// Google Student, CodingBat, Array-3 > canBalance
// Author: kei (All Correct)
// Date  : September 19, 2018
public boolean canBalance(int[] nums) {
  if (nums.length == 1) {
    return false;
  }
  
  int sum = 0;
  HashSet<Integer> set = new HashSet<>();
  for (int n : nums) {
    sum += n;
    set.add(sum);
  }
  
  // Don't forget this. 
  if (sum % 2 == 1) {
    return false;
  }
  return set.contains(sum / 2);
  
}






















