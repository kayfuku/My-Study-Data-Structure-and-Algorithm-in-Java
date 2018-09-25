// Codility, Lesson 5, Brackets.
// 100% (100 out of 100). (ref. stackoverflow)
// Author: Kei Fukutani
// Date  : November 8, 2015


// Brackets
// Determine whether a given string of parentheses is properly nested.
// Programming language:  
// A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

// S is empty;
// S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
// S has the form "VW" where V and W are properly nested strings.
// For example, the string "{[()()]}" is properly nested but "([)()]" is not.

// Write a function:

// class Solution { public int solution(String S); }

// that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

// For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

// Assume that:

// N is an integer within the range [0..200,000];
// string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
// Complexity:

// expected worst-case time complexity is O(N);
// expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
// Copyright 2009–2015 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.


package codility;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Brackets {

    public static final int BALANCED = 1;
    public static final int UNBALANCED = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String string = "{[()()]}";
        System.out.println(solution(string));

        // int[] array2 = { -1000, 1000 };
        // System.out.println(solution(array2));

    }

    public static int solution(String S) {
        // write your code in Java SE 8
        if (S.isEmpty()) {
            return BALANCED;
        }

        Deque<Character> stack = new LinkedList<Character>();
        NestedValidatorUtil util = new NestedValidatorUtil();

        for (Character c : S.toCharArray()) {
            if (stack.isEmpty()) {
                if (util.isOpener(c)) {
                    stack.push(c);
                } else {
                    return UNBALANCED;
                }
            } else {
                if (util.isOpener(c)) {
                    stack.push(c);
                } else if (util.getOpenerForGivenCloser(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return UNBALANCED;
                }
            }
        }

        return stack.isEmpty() ? BALANCED : UNBALANCED;

    } // end solution()

    public static class NestedValidatorUtil {
        private HashMap<Character, Character> hashMap = new HashMap<Character, Character>();

        public NestedValidatorUtil() {
            // TODO Auto-generated constructor stub
            hashMap.put(')', '(');
            hashMap.put(']', '[');
            hashMap.put('}', '{');
        }

        public boolean isOpener(Character c) {
            return hashMap.containsValue(c);
        }

        public Character getOpenerForGivenCloser(Character closer) {
            return hashMap.get(closer);
        }

    }

}
