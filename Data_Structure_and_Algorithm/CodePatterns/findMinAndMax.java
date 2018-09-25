// Find a minimum.
// Author: Kei Fukutani
// Date  : February 22, 2016

public static int findMin(int[] integers) {
    int min = integers[0];

    for (int i = 0; i < integers.length; i++) {
        min = Math.min(min, integers[i]);  
    }
    
    return min;
}

// Find a maximum. 
// Author: takahashi + kei
// Date  : October 12, 2016
int getMaxNum(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    return max;
}



// Find a minimum. 
// Author: A top programmer in TopCoder
int min = Math.abs(droids[0] - door);
for (int j = 0; j < droids.length; j++) {
    min = Math.min(min, Math.abs(droids[j] - doors[i]));
}
return min;


// Find a maximum. 
// Author: A top programmer in TopCoder
int max = 0;
for (int i = 0; i < doors.length; i++) {
    int dis = Math.abs(droid - doors[i]);
    max = Math.max(max, dis);
}
return max;


// Find a maximum. 
// Return -1 if not applicable.
// Author: tiny_code, a top programmer in TopCoder
public class BearPair {
    public int bigDistance(String s) {
 
        int best = -1;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i + 1; j < s.length(); ++j) {
                if (s.charAt(i) != s.charAt(j)) {
                    best = Math.max(best, j - i);
                }
            }
        }

        return best;
    } 
}





































