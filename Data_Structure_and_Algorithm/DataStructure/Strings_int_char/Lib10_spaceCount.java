/**
   spaceCount returns the number of spaces in its
   argument. 
   ・空白のみでもカウントする。
   @param str The string for which we are counting
   the number of spaces. 
   @return The number of spaces in str.
*/

public static int spaceCount(String str)
{
   int spaces = 0;	// counter for number of spaces in str.
   
   // 文字列を１文字ずつ参照する。
   for (int i = 0; i < str.length(); i++)
   {
      if (str.charAt(i) == ' ')
         spaces++;
   }

   return spaces;
}
