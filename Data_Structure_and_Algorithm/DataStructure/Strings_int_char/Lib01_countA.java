/***************************************************************
* Returns the number of 'A' in the String.
*/

public int countA (String str)
{
   int count = 0;
   for (int index = 0; index < str.length(); index++)
      if (str.charAt(index) == 'A')
         count++;
   return count;
}





