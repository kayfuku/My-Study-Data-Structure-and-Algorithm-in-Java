// collapseDuplicates (Google Student, CodingBat)  
// Fix this duplicate collapsing code: 
// public String collapseDuplicates(String a) { 
//   int i = 0; String result = "";
//   while (i < a.length()) { 
//     char ch = a.charAt(i);
//     result += ch;
//     while (a.charAt(i+1) == ch) {
//       i++; 
//     } 
//     i++;
//   } 
//   return result; 
// }
// collapseDuplicates("a") → "a"
// collapseDuplicates("aa") → "a"
// collapseDuplicates("abc") → "abc"
// collapseDuplicates("abca") → "abca"

// Author: kei (All Correct)
// Date  : December 31, 2018

public String collapseDuplicates(String a) {
  if (a.length() == 0 || a.length() == 1 || a == null) {
    return a;
  }
  
  StringBuilder sb = new StringBuilder();
  sb.append(a.charAt(0));
  int i = 1;
  while (i < a.length()) {
    char ch = a.charAt(i);
    if (a.charAt(i) != a.charAt(i - 1)) {
      sb.append(ch);
    }
    
    i++;
  } 
  
  return sb.toString();
}






























