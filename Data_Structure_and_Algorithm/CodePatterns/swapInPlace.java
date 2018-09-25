// Swap in place.
// Author: CtCI 16.1 p.462 + kei
// Date  : February 19, 2017

package whiteboard;


public class Lab_whiteboard {

    public static void main(String[] args) {

        
        int a = 3, b = 5;
        swapInPlace_Bit(a, b);
        
        
        
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().

    // Swap in place.
    // Author: CtCI 16.1 p.462 + kei
    // Date  : February 19, 2017
    public static void swapInPlace(int a, int b) {
        System.out.println("a: " + a + ", " + "b: " + b);
        
        a = a - b;
        b = a + b;
        a = b - a;
        
        System.out.println("a: " + a + ", " + "b: " + b);   
    }
    
    // Swap in place.
    // Author: CtCI 16.1 p.462 + kei
    // Date  : February 19, 2017
    public static void swapInPlace_Bit(int a, int b) {
        System.out.println("a: " + a + ", " + "b: " + b);

        // Extract the difference. 'a' gets the difference info. 
        a = a ^ b;
        // Toggle the different bits. 'b' gets the original 'a'.
        b = b ^ a;
        // Toggle the different bits. 'a' gets the original 'b'.
        a = b ^ a;
        
        
        System.out.println("a: " + a + ", " + "b: " + b);
    }

    
    
    

}





















