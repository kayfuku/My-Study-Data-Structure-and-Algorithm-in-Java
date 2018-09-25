// Copying arrays. (maybe By CS111A)

int[] score = {79, 83, 64, 93};
int[] newScore;

newScore = new int[score.length];

for(int i = 0; i < score.length; i++)
{
    newScore[i] = score[i];
}


// Copying arrays. (By Yuuki Hiroshi)

String[] str1 = {"a", "b", "c", "d"};
String[] str2 = new String[10];

// Copy the values of array 'str1' to the elements of array 'str2'.
// The second arg is the start position of copying from 'str1'. 
// The forth arg is the start position of copying to 'str2'.  
// The fifth arg is the numbers of elements to be copied. 
System.arraycopy(str1, 0, str2, 3, str1.length); 




