// Compress String. Easier to read than before. 
// Author: CtCI 1.6 p.202 + kei.
// Date  : January 26, 2018
// ex.  "aabcccccaaa" >> "a2b1c5a3"
static String compressString(String str) {
    // Check if the compressed String finalLength is greater than original.
    int finalLength = countCompressedSize(str);
    if (finalLength >= str.length()) {
        return str;
    }

    // Compress using StringBuffer because it's in loop.
    // Better to set initial capacity of StringBuilder because otherwise 
    // the capacity could be double what we ultimately need. 
    StringBuffer compressed = new StringBuffer(finalLength);
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
        countConsecutive++;
        
        // If next char is different than current, append this char to result.
        // Or, if i + 1 reaches the end. 
        if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1))  {
            // Character changed. 
            compressed.append(str.charAt(i));
            compressed.append(countConsecutive);
            // Initialize the counter.
            countConsecutive = 0;
        }        
    }
    return compressed.toString();
}

static int countCompressedSize(String str) {
    int compressedLength = 0;
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
        countConsecutive++;
        
        // If next char is different than current or i + 1 reaches the end, 
        // increase the length.
        if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1))  {
            // Character changed. 
            compressedLength += 1 + String.valueOf(countConsecutive).length();
            // Initialize the counter.
            countConsecutive = 0;
        }        
    }
    return compressedLength;
}




// Harder to read. 
// Compress String.
// Author: Cracking the Coding Interview p.176 + kei.
// Date  : January 31, 2016
// ex.  "aabcccccaaa" >> "a2b1c5a3"
String compressString(String str) {

    // Check if the compressed String size is greater than original.
    int size = countCompressedSize(str);
    if (size >= str.length()) {
        return str;
    }

    // Compress using StringBuffer because it's in loop.
    StringBuffer strCompressed = new StringBuffer(size);
    char last = str.charAt(0);
    int count = 1;
    // i starts with 1 because you wanna compare with the last one.
    for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i) == last) {
            // Character repeated.
            count++;
        } else {
            // Character changed. 
            strCompressed.append(last);
            strCompressed.append(count);
            last = str.charAt(i);
            // Initialize the counter.
            count = 1;
        }        
    }
    strCompressed.append(last);
    strCompressed.append(count);

    return strCompressed.toString();
}

int countCompressedSize(String str) {
    char last = str.charAt(0);
    int size = 0;
    int count = 1;
    for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i) == last) {
            count++;
        } else {
            last = str.charAt(i);
            // Convert int to String and then 
            // get the num of digits as a String.
            size += 1 + String.valueOf(count).length();
            // Initialize the counter.
            count = 1;
        }        
    }

    size += 1 + String.valueOf(count).length();

    return size;
}





















