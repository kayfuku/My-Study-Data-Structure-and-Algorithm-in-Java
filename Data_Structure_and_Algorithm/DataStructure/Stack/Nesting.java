// Codility, Lesson 5, Nesting.
// 100% (100 out of 100). (By myself)
// Author: Kei Fukutani
// Date  : November 7, 2015


// 1. Nesting
// Determine whether given string of parentheses is properly nested.
// Task description
// A string S consisting of N characters is called properly nested if:

// S is empty;
// S has the form "(U)" where U is a properly nested string;
// S has the form "VW" where V and W are properly nested strings.
// For example, string "(()(())())" is properly nested but string "())" isn't.

// Write a function:

// class Solution { public int solution(String S); }

// that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

// For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

// Assume that:

// N is an integer within the range [0..1,000,000];
// string S consists only of the characters "(" and/or ")".
// Complexity:

// expected worst-case time complexity is O(N);
// expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
// Copyright 2009–2015 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.


package codility;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Nesting {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String string = "(()))(";
        System.out.println(solution(string));

        // int[] array2 = { -1000, 1000 };
        // System.out.println(solution(array2));

    }

    public static int solution(String S) {
        // write your code in Java SE 8

        Deque<String> stack = new LinkedList<>();

        try {
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '(') {
                    stack.push("(");
                } else {
                    stack.pop();
                }
            }

        } catch (NoSuchElementException e) {
            // Too many ")" corresponding to "(".
            return 0;
        }

        if (stack.isEmpty()) {
            // The number of "(" matches that of ")".
            return 1;
        } else {
            // Too many "(" corresponding to ")".
            return 0;
        }

    } // end solution()

}
