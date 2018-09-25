// Check if a string contains a substring.
// Author: Kei Fukutani
// Date  : March 5, 2016, September 7, 2018


String string = "ABCDE";
String subString = "CE";

// Return true if the string contains the substring.
System.out.println(string.contains(subString));


// Test string indexOf method. 
// String text = "dog1 do dog aaa.";
String text = "aaaaaa";
// String term = "aaaa";
String term = "aaaaaa";
String term = "do";
int count = 0;
// count = countPartial(text, term);
System.out.println(count);
String text5= text.substring(5);
System.out.println(text5);  // a
String text6 = text.substring(6);
System.out.println(text6.equals(""));  // true
String text7 = text.substring(7);
System.out.println(text7);  // Exception




private static int countPartial(String text, String term) {
    int count = 0;
    int index = 0;
    while (text.length() > 0) {
        index = text.indexOf(term);
        if (index == -1) {
            return count;
        } else {
            count++;
            text = text.substring(index + 1);
        }           
        System.out.println("count: " + count + " index: " + index);
    }
    return count;
}

























