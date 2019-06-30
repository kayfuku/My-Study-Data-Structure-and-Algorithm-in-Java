// sumNumbers (Google Student, CodingBat, String-3)
// prev  |  next  |  chance
// Given a string, return the sum of the numbers appearing in the 
// string, ignoring all other characters. A number is a series of 1 or 
// more digit chars in a row. 
// (Note: Character.isDigit(char) tests if a char is one of the chars 
//  '0', '1', .. '9'. Integer.parseInt(string) converts a string to an 
// int.)
// ex. 
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
    int start = 0;
    int end = 0;
    for (int i = 0; i < str.length(); i++) {
        if (Character.isDigit(str.charAt(i)) && !digit) {
            // char to digit. 
            digit = true;
            start = i;
        } else if (!Character.isDigit(str.charAt(i)) && digit) {
            // digit to char. 
            digit = false;
            end = i;
            sum += Integer.parseInt(str.substring(start, end));
        }
    }

    // Add the number of the remaining digits. 
    if (digit) {
        sum += Integer.parseInt(str.substring(start));
    }

    return sum;
}































