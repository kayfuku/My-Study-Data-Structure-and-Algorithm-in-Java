// int to char. char to int.
// Author: Cracking the Coding Interview
// Date  : January 31, 2016


// char to int.
// char turns into its corresponding int in ASCII code.
char c = 'c';
int n = c;
System.out.println(n); // 99

// int to char.
char c = 97;
System.out.println(c); // a

c = 'd' + 2;
System.out.println(c); // f

// int to char.
// integer turns into its corresponding char.
for (int i = 0; i < 256; i++) {
    c = (char) i;
    System.out.println("i: " + i + " " + c);
}



// i: 65 A
// ...
// i: 89 Y
// i: 90 Z
// i: 91 [
// i: 92 \
// i: 93 ]
// i: 94 ^
// i: 95 _
// i: 96 `
// i: 97 a
// i: 98 b
// i: 99 c
// i: 100 d
// i: 101 e
// ...


// Get int value from char number.
String s = "2430";
char c = s.charAt(0); // c: '2'
int integer = Character.getNumericValue(c); // integer: 2

// Another solution instead of getNumericValue(c).
int integer = c - '0';




// Character.getNumericValue()
// Author: kei
// Date  : September 16, 2018
char c = '2';
int n = Character.getNumericValue(c);
System.out.println(n);  // 2
c = 'a';
n = Character.getNumericValue(c);  // 10
System.out.println(n);
c = 'A';
n = Character.getNumericValue(c);
System.out.println(n);  // 10
























