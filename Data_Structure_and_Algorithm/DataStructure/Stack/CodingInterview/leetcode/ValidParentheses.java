// 
// Author: 
// Date  : May 25, 2019

package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class ValidParentheses {

	// Some fields here. 
	private Map<Character, Character> map;


	public ValidParentheses() {
		// Initialization here. 
		map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

	}

	// O(n) time, O(n) space. 
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		LinkedList<Character> stack = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				stack.push(c);
			} else {
				char topElement = (stack.isEmpty()) ? '#' : stack.pop();
				if (map.get(c) != topElement) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}


	// Review.
	public boolean isValidR(String s) {
		// corner
		if (s == null || s.length() == 0) {
			return true;
		}
		if (s.length() == 1) {
			return false;
		}

		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.offerFirst(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char open = map.get(c);
				char top = stack.pollFirst();	
				if (open != top) {
					return false;
				}
			}
		}    

		return stack.isEmpty();
	}






	// For testing. 
	public static void main(String[] args) {
		ValidParentheses solution = new ValidParentheses();

		// Test arguments. 
		//	    int num = 24;
		//	    int target = 2;
		//	    solution.getInt(num, target);

		String parentheses = "({}[()])";
		System.out.println(solution.isValid(parentheses));
		parentheses = "{}[()])";
		System.out.println(solution.isValid(parentheses));



	}

}


















