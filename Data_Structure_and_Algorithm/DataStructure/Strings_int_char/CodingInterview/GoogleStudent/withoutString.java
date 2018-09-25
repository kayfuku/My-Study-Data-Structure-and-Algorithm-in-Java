// Google Student, CodingBat
// Remove 'remove' string from 'base' string. 
// withoutString (CodingBat) All Correct, Google Student
// Author: mirandaio + kei 
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



    public static String withoutString(String base, String remove) {
        char[] arr = new char[base.length()];
        int count = 0;
        int i = 0;
        
            
        while(i <= base.length() - remove.length()) {
            if(base.substring(i, i + remove.length()).toLowerCase().equals(remove.toLowerCase())) {
                i += remove.length();
            } else {
                arr[count] = base.charAt(i);
                count++;
                i++;
            }
        }
                                                            
        while(i < base.length()) {
            arr[count] = base.charAt(i);
            count++;
            i++;
        }
                                                                              
        return new String(arr, 0, count);
    }





































}
























