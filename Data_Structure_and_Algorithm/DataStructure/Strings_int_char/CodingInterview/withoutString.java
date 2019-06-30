// Remove 'term' string from 'base' string. 
// withoutString (CodingBat), Google Student
// Author: mirandaio + kei (All Correct)
// Date  : September 12, 2018

public class Lab01 {

    public static void main(String[] args) {
    
        char[] arr = {'a', 'b', '6', 'g'};
        
        System.out.println(new String(arr, 0, 0));  // (empty string)
        System.out.println(new String(arr, 0, 1));  // a
        System.out.println(new String(arr, 0, 4));  // ab6g
        System.out.println(new String(arr, 1, 2));  // b6
//      System.out.println(new String(arr, 2, 3));  // StringIndexOutOfBoundsException
//      System.out.println(new String(arr, 0, 5));  // StringIndexOutOfBoundsException
        

        String base = "Hello there";
        String term = "llo";
        System.out.println(withoutString(base, term));
        
    }


    public static String withoutString(String base, String term) {
        char[] arr = new char[base.length()];
        int count = 0;
        int i = 0;
        
        // I don't have to check all of the characters. 
        // Practice a lot to figure out the continuing condition quickly. 
        // index: 0 1 2 3 x (ex. len is 4, term len is 2) 
        //            |   |   
        //            i   i + term.length
        while (i <= base.length() - term.length()) {
            if (base.substring(i, i + term.length()).toLowerCase().equals(term.toLowerCase())) {
                i += term.length();
            } else {
                arr[count] = base.charAt(i);
                count++;
                i++;
            }
        }
                                                            
        while (i < base.length()) {
            arr[count] = base.charAt(i);
            count++;
            i++;
        }
                                                                              
        return new String(arr, 0, count);
    }





































}
























