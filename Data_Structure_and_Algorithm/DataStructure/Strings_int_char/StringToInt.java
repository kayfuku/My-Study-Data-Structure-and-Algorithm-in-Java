// How to convert between String and int. 
// (By website)

int i = 2;
String s;

// *** int to String. ***
String s = String.valueOf(i);
// or
String s = Integer.toString(i);
// or
String s = i + "";

// ex. 
String s;
int n = 12;
s = Integer.toString(n);
System.out.println(s); // 12
System.out.println(s instanceof String); // true

// *** String to int. ***
int i = Integer.parseInt(s);

// Num of digits in String num.
int num = 23;
int size = String.valueOf(num).length(); // size: 2

