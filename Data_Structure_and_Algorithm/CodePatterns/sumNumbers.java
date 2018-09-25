// Google Student, CodingBat, String-3 > sumNumbers 
// prev  |  next  |  chance
// Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
// sumNumbers("abc123xyz") → 123
// sumNumbers("aa11b33") → 44
// sumNumbers("7 11") → 18
// Author: kei (All Correct)
// Date  : September 16, 2018


public int sumNumbers(String str) {
    if (str.length() == 0 || str == null) {
        return 0;
    }

    int sum = 0;
    boolean digit = false;
    int begin = 0;
    int end = 0;
    for (int i = 0; i < str.length(); i++) {
        if (Character.isDigit(str.charAt(i)) && !digit) {
            digit = true;
            begin = i;
        } else if (!Character.isDigit(str.charAt(i)) && digit) {
            digit = false;
            end = i;
            sum += Integer.parseInt(str.substring(begin, end));
        }
    }

    if (digit) {
        sum += Integer.parseInt(str.substring(begin, str.length()));
    }


    return sum;
}































