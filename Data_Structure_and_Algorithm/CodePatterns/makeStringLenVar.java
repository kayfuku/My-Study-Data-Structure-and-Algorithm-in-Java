// Make a string that has 'var' kinds of characters 
// and the length of 'len'.
// Author: kei
// Date  : February 12, 2017

package whiteboard;


public class Lab_whiteboard {

    public static void main(String[] args) {

        
        
        
        System.out.println(makeString(50, 26));
        // abcdefghijklmnopqrstuvwxyzaaaaaaaaaaaaaaaaaaaaaaaa 
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().

    
    // Make a string that has 'var' kinds of characters 
    // and the length of 'len'.
    // Author: kei
    // Date  : February 12, 2017
    public static String makeString(int len, int var) {
        if (len < var) {
            throw new RuntimeException("len < var");
        }
        
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < var; i++) {
            sb.append((char) ('a' + i));
        }
        for (int j = var; j < len; j++) {
            sb.append('a');
        }
        
        
        return sb.toString();
    }

    
    
    
    
    
    
}

























