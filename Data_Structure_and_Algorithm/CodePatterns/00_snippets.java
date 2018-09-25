// Code patterns and snippets. 

// Return false if it is detected at most once. 
// Author : CtCI p.199 + kei
// Date   : January 26, 2018 
boolean foundDiff = false;
for (int i = 0; i < s1.length(); i++) {
    if (s1.charAt(i) != s2.charAt(i)) {
        if (foundDiff) {
            return false;
        }
        foundDiff = true;
    }
}
return true;


// Get out of the loop when either of two pointers reaches the end.
// Author : CtCI p.200 + kei
// Date   : January 26, 2018 
int p1 = 0;
int p2 = 0;
while (p1 < s1.length() && p2 < s2.length()) {
    // Do something. 
}































