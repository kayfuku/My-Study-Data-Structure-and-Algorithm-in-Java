   /**
      The isValid method determines whether num is valid and 
      displays an appropriate message.
      @param num The number input by user.
   */

   public static void isValid(int num)
   {
      int[] validNum = { 5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 
	    		 8080152, 4562555, 5552012, 5050552, 7825877, 1250255, 
	    		 1005231, 6545231, 3852085, 7576651, 7881200, 4581002 };
      int results;

      // Search the array for num.
      results = sequentialSearch(validNum, num);

      // Determine whether num is valid and
      // display an appropriate message.
      if (results == -1)
      {
         System.out.println(num + " is not a valid " +
         		"charge account number.");
      }
      else
      {
         System.out.println(num + " is a valid " +
         		"charge account number.");
      }
   }
	   
   /**
      The sequentialSearch method searches an array for
      a value.
      @param array The array to search.
      @param value The value to search for.
      @return The subscript of the value if found in the
             array, otherwise -1.
   */

   public static int sequentialSearch(int[] array, int value)
   {
      int index;        // Loop control variable
      int element;      // Element the value is found at
      boolean found;    // Flag indicating search results

      // Element 0 is the starting point of the search.
      index = 0;

      // Store the default values element and found.
      element = -1;
      found = false;

      // Search the array.
      while (!found && index < array.length)
      {
         if (array[index] == value)
         {
            found = true;
            element = index;
         }
         index++;
      }

      return element;
   }

