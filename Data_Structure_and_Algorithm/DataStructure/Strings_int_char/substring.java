

// indexOf method. 
// Author: kei
// Date  : September 10, 2018

String base = "aaba";
// String term = "b";
// System.out.println(base.indexOf(term));  // 2
String term = "";
System.out.println(base.indexOf(term));  // 0



// substring method. 
// Author: kei
// Date  : September 7, 2018

String text = "abcdef";
String sub;
// substring last element. 
sub = text.substring(5);
System.out.println(sub);  // f
// This does not throw an exception, but returns an empty string. 
sub = text.substring(6);
System.out.println(sub.equals(""));  // true
// This causes an exception. 
sub = text.substring(7);
System.out.println(sub);  // StringIndedOutOfBoundsException
// start and end.
sub = text.substring(0, 0);
System.out.println(sub.equals(""));  // true
sub = text.substring(0, 1);
System.out.println(sub);  // a
sub = text.substring(-1, 0);
System.out.println(sub.equals(""));  // StringIndedOutOfBoundsException
sub = text.substring(0, text.length());
System.out.println(sub);  // abcdef
sub = text.substring(0, text.length() + 1);
System.out.println(sub);  // StringIndedOutOfBoundsException



// Check if a string contains a substring.
// Author: kei
// Date  : March 5, 2016

String string = "ABCDE";
String subString = "CE";

// Return true if the string contains the substring.
System.out.println(string.contains(subString));  // false























