/**
   The numberEqual method returns the number of times
   the target value occurs in the array of values.   
   @param value  A reference to the array.
   @param target  Value for which we are determining the 
				  number of occurrences. 
   @return The number of times the target value occurs 
		   in the array. 
*/

public static int numberEqual(int[] value, int target){ 
   	int count = 0;
 	
   	for (int i = 0; i < value.length; i++){
   		if (value[i] == target)
   			count++;
   	}
 	   		
   	return count;	
}  	