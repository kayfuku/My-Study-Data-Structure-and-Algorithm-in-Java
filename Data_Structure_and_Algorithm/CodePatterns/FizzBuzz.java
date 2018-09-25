// Print "Fizz" if n is multiplys of 3.
// Print "Buzz" if n is multiplys of 5.
// Print "FizzBuzz" if n is multiplys of 3 and 5.
// Author: kei
// Date  : October 11, 2016

package pack01;


public class Lab01 {

    public static void main(String[] args) {        
        
        
        String[] strs = new String[100];
        for (int i = 1; i < strs.length; i++) {
            strs[i] = String.valueOf(i);
            //strs[i] = i + "";
        }
        
        makeFizzBuzz(strs);
        
        for (int i = 1; i < strs.length; i++) {
            System.out.println(i + " " + strs[i]);
        }

        
        // for (int i = 1; i < 100; i++) {
        //     System.out.print(i + " ");

        //     if (i % 3 == 0) {
        //         System.out.print("Fizz");
        //     }
        //     if (i % 5 == 0) {
        //         System.out.print("Buzz");
        //     }
            
        //     System.out.println();           
        // }
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end of main().
    
    
    public static void makeFizzBuzz(String[] strs) {
        
        int num;
        for (int i = 1; i < strs.length; i++) {
            num = Integer.parseInt(strs[i]); 
            
            if (num % 3 == 0 && num % 5 == 0) {
                strs[i] = "FizzBuzz";
            } else if (num % 3 == 0) {
                strs[i] = "Fizz";
            } else if (num % 5 == 0) {
                strs[i] = "Buzz";
            }
            
        }
        
    }
    
    
    
    
}
























