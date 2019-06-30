// withoutString (Google Student, CodingBat, String-3)
// Remove 'remove' string from 'base' string. 
// Given two strings, base and remove, return a version of the 
// base string where all instances of the remove string have been 
// removed (not case sensitive). You may assume that the remove string 
// is length 1 or more. Remove only non-overlapping instances, 
// so with "xxx" removing "xx" leaves "x".
// ex. 
// withoutString("Hello there", "llo") → "He there"
// withoutString("Hello there", "e") → "Hllo thr"
// withoutString("Hello there", "x") → "Hello there"
// 
// Author: mirandaio + kei (All Correct)
// Date  : September 12, 2018

public class Lab01 {

    public static void main(String[] args) {
    
        char[] arr = {'a', 'b', '6', 'g'};
        
        // new String(charArray, firstIndex, length)
        System.out.println(new String(arr, 0, 0));  // (empty string)
        System.out.println(new String(arr, 0, 1));  // a
        System.out.println(new String(arr, 0, 4));  // ab6g
        System.out.println(new String(arr, 1, 2));  // b6
//      System.out.println(new String(arr, 2, 3));  // StringIndexOutOfBoundsException
//      System.out.println(new String(arr, 0, 5));  // StringIndexOutOfBoundsException
         

        String base = "Hello there";
        String term = "llo";
        System.out.println(withoutString(base, term));  // He there

    }


    public static String withoutString(String base, String remove) {
        // Create a new char array to be returned. 
        char[] arr = new char[base.length()];
        int count = 0;
        int i = 0;
        
        // while-loop, not for-loop because you need the index i 
        // in multiple loops. 
        // Be careful about how to move forward the index i in both 
        // branches. 
        while(i + remove.length() <= base.length() ) {
            if(base.substring(i, i + remove.length()).toLowerCase().equals(remove.toLowerCase())) {
                i += remove.length();
            } else {
                arr[count] = base.charAt(i);
                count++;
                i++;
            }
        }
                              
        // Copy the remaining characters.                           
        while(i < base.length()) {
            arr[count] = base.charAt(i);
            count++;
            i++;
        }
                                                                              
        return new String(arr, 0, count);
    }












}
























