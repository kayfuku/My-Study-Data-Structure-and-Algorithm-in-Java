/**
   spaceCount returns the number of spaces in its
   argument. 
   �E�󔒂݂̂ł��J�E���g����B
   @param str The string for which we are counting
   the number of spaces. 
   @return The number of spaces in str.
*/

public static int spaceCount(String str)
{
   int spaces = 0;	// counter for number of spaces in str.
   
   // ��������P�������Q�Ƃ���B
   for (int i = 0; i < str.length(); i++)
   {
      if (str.charAt(i) == ' ')
         spaces++;
   }

   return spaces;
}
