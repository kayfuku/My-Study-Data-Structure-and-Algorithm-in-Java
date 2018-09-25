/*
  Finding the minimum value in an array.
*/

public static int getLowest(int[] value){
    int lowestSoFar = value[0];

    for (int i = 1; i < value.length; i++){
        if (value[i] < lowestSoFar)
        lowestSoFar = value[i];
    }

    return lowestSoFar;
}