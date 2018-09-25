/**
   The getAverage method returns the average
   of the values stored in an array.
   @param value A reference to the array.
   @return The average of the values in the array.    
*/

public static float getAverage(int[] value){ 
  	int sum = 0;	// The sum of the values stored in the array.
  	float average;	// the average of the value stored in the array.
	
	// Calculate the sum. 
  	for (int i = 0; i < value.length; i++)
  		sum += value[i];
  		
  	// Calculate and return the average.
  	if (value.length == 0)
  		average = 0.0f;
  	else
  		average = (float)sum / value.length;
  		
  	return average;	
}