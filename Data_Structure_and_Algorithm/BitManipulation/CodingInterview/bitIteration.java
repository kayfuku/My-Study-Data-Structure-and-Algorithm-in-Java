// Bit digit iterate pattern. 
// For the problem that it doesn't matter how significant the digit is. 
// It only matters which the value is 0 or 1.  
// Author: CtCI 5.3 p.279 + kei
// Data  : November 6, 2016

package whiteboard;


public class Lab_whiteboard {

    public static void main(String[] args) {

        
        
         // Test bitIterate()
        System.out.println(Integer.toBinaryString(4638201)); //10001101100010111111001
        bitIterate(4638201); // 10011111101000110110001000000000
 
        
        
        
        
        
        
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    
    
    // Bit digit iterate pattern. 
    // For the problem that it doesn't matter how significant the digit is. 
    // It only matters which the value is 0 or 1.  
    // Author: CtCI 5.3 p.279 + kei
    // Data  : November 6, 2016
    public static void bitIterate(int n) {
        for (int i = 0; i < Integer.BYTES * 8; i++) {
            // Do something. 
            System.out.print(n & 1);
            
            // Logical right shift. 
            n >>>= 1;           
        }
    }
    
    public static void bitIterate2(int n) {
        while (n != 0) {
            if ((n & 1) == 1) {
                // If the current bit is 1, do something. 
            } else {
                // If the current bit is 0, do something. 
            }
            
            n >>>= 1;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}

























