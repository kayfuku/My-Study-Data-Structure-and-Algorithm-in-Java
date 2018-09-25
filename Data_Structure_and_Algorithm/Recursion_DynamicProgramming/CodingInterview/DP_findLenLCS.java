// Find the length of Longest Common Subsequence(LCS) of 
// two strings. 
// Author: Aizu Book p.256 + kei
// Date  : February 9, 2017

package whiteboard;



public class Lab_whiteboard {

    public static void main(String[] args) {

        String str1 = "abcbdab";
        String str2 = "bdcaba";
        System.out.println(findLenLCS(str1, str2)); // 4
        // LCS: bcba
        
        str1 = "abc";
        str2 = "abc";
        System.out.println(findLenLCS(str1, str2)); // 3
        // LCS: abc

        str1 = "abc";
        str2 = "bc";
        System.out.println(findLenLCS(str1, str2)); // 2
        // LCS: bc

        str1 = "axxbcxxx";
        str2 = "yyaybyyc";
        System.out.println(findLenLCS(str1, str2)); // 3
        // LCS: abc

        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    
    
    // Find the length of Longest Common Subsequence(LCS) of 
    // two strings. 
    // Author: Aizu Book p.256 + kei
    // Date  : February 9, 2017
    public static int findLenLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        str1 = " " + str1;
        str2 = " " + str2;
        int[][] c = new int[m + 1][n + 1];
        int lenLCS = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
                lenLCS = Math.max(lenLCS, c[i][j]);         
            }
        }
        
        return lenLCS;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}

























