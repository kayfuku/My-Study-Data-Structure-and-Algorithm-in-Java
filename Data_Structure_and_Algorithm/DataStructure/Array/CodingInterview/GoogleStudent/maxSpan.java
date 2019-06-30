// maxSpan. (Google Student, CodingBat, Array-3)
// Consider the leftmost and righmost appearances of some value 
// in an array. We'll say that the "span" is the number of elements 
// between the two inclusive. A single value has a span of 1. 
// Returns the largest span found in the given array. 
// (Efficiency is not a priority.)
// ex. 
// maxSpan([1, 2, 1, 1, 3]) → 4
// maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
// maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
// 
// Author: kei (All Correct)
// Date  : September 9, 2018 

int maxSpan(int[] nums) {
    if (nums.length == 0 || nums.length == 1) {
        return nums.length;
    }
    HashMap<Integer, Integer> numToFirstIndex = new HashMap<>();
    int maxSpan = 0;
    int span, n;
    for (int i = 0; i < nums.length; i++) {
        n = nums[i];
        if (!numToFirstIndex.containsKey(n)) {
            numToFirstIndex.put(n, i);
            span = 1;
        } else {
            span = i - numToFirstIndex.get(n) + 1;
        }
        if (span > maxSpan) {
            maxSpan = span;
        }
    }

    return maxSpan;
}

































