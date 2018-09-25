/*
  Finding the maximum value in an array.
*/

public static int getHighest(int[] value){
    int highestSoFar = value[0];

    for (int i = 1; i < value.length; i++){
        if (value[i] > highestSoFar)
        highestSoFar = value[i];
    }

    return highestSoFar;
}