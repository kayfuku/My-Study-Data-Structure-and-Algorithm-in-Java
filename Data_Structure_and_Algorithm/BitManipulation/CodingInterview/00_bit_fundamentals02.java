// Fundamentals about how bit works. 
// Author: kei

package whiteboard;

public class ForCopy {

    public static void main(String[] args) {

        // Test modulo2ToPowerOf()
        modulo2ToPowerOf(34);
        // x % 2: 0
        // x % 4: 2
        // x % 8: 2
        // x % 32: 2

        // -1 is all ones. 
        System.out.println(Integer.toBinaryString(-1)); 
        // 11111111111111111111111111111111 (32 ones.)
        
        // Set the right-most bit 1 to 0. 
        int x = Integer.parseInt("10011010", 2);
        int y = x & (x - 1);
        System.out.println(Integer.toBinaryString(y)); // 10011000 
        
        // Test checkExactlyOneBitSet().
        int a = Integer.parseInt("00011000", 2);
        System.out.println(checkExactlyOneBitSet(a)); // false
        int b = Integer.parseInt("00000010", 2);
        System.out.println(checkExactlyOneBitSet(b)); // true 
        
        
        
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end of main().
    
    // Modulo of power of 2. 
    // Author: the internet + kei
    // Data  : November 4, 2016
    public static void modulo2ToPowerOf(int x) {
        System.out.println("x % 2: " + (x & 1));
        System.out.println("x % 4: " + (x & 3));
        System.out.println("x % 8: " + (x & 7));
        System.out.println("x % 32: " + (x & 0x1F));

    }

    // This is like idiom to check if it has exactly one 1 in the bit sequence.
    // ex. 00001000 --> true    01001000 --> false
    //  -  00000001          -  00000001
    //     00000111             01000111
    //  &  00001000          &  01001000
    //     00000000             01000000
    // The bits to the right of right-most 1 including the right-most 1 bit
    // toggle 1 to 0, or 0 to 1 without changing bits on the left hand side of the bit.
    private static boolean checkExactlyOneBitSet(int bitVector) {       
        return (bitVector & (bitVector - 1)) == 0;
    }

    





















    
    
    
    
    
}

























