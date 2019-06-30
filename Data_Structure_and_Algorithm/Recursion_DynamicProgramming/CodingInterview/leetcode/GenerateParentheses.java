// 
// Author: 
// Date  : May 25, 2019

package leetcode;

import java.util.ArrayList;
import java.util.List;


public class GenerateParentheses {

	// Some fields here. 
	//	private int count;


	public GenerateParentheses() {
		// Initialization here. 
		//		count = 0;
	}


	// 1. Brute Force. 
	// O(2^n*n) time, O(2^n*n) space. 
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if (n < 1) {
			return result;
		}
		generateAll(new char[2 * n], 0, result);
		return result;
	}
	private void generateAll(char[] combinations, int pos, List<String> result) {
		// Base case. 
		if (pos == combinations.length) {
			if (isValid(combinations)) {
				result.add(new String(combinations));
			}
			return;
		}

		// Left subtree. 
		combinations[pos] = '(';
		generateAll(combinations, pos + 1, result);

		// Right subtree.
		combinations[pos] = ')';
		generateAll(combinations, pos + 1, result);
	}

	// O(n) time, O(n) space. 
	private boolean isValid(char[] combinations) {
		int balance = 0;
		for (char c : combinations) {
			if (c == '(') {
				balance++;
			} else {
				balance--;
				if (balance < 0) {
					return false;
				}
			}
		}

		return balance == 0;
	}


	// 2. Backtracking. 
	public List<String> generateParenthesis2(int n) {
		List<String> result = new ArrayList<>();
		if (n < 1) {
			return result;
		}
		backtrack("", 0, 0, result, n);
		return result;		
	}
	private void backtrack(String cur, int open, int close, List<String> result, int max) {
		if (cur.length() == max * 2) {
			result.add(cur);
			return;
		}

		// Left subtree. 
		if (open < max) {
			backtrack(cur + '(', open + 1, close, result, max);
		}

		// Right subtree. 
		if (close < open) {
			backtrack(cur + ')', open, close + 1, result, max);
		}
	}


	// Review 
	public List<String> generateParenthesisR(int n) {
		List<String> list = new ArrayList<>();

		// corner case. 
		if (n < 1) {
			return list;
		}

		generateParenthesisR(n, "", 0, 0, list);
		return list;
	}
	private void generateParenthesisR(int n, String parentheses, int open, int close, List<String> list) {
		// Base case. 
		if (parentheses.length() == n * 2) {
			list.add(parentheses);
			return;
		}

		if (open < n) {
			generateParenthesisR(n, parentheses + '(', open + 1, close, list);
		}
		if (open > close) {
			generateParenthesisR(n, parentheses + ')', open, close + 1, list);
		}
	}





	// For testing. 
	public static void main(String[] args) {
		GenerateParentheses solution = new GenerateParentheses();

		// Test arguments. 
		//	    int num = 24;
		//	    int target = 2;
		//	    solution.getInt(num, target);

		//	    List<String> list = solution.generateParenthesis(3);
		List<String> list = solution.generateParenthesis2(3);
		System.out.println(list.toString());
		list = solution.generateParenthesisR(3);
		System.out.println(list.toString());

	}

}















