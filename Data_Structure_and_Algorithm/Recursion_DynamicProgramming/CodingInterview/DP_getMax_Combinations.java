// Get combinations that meet some specific restrictions. 
// Solution #1: For-loop pattern. 
// Solution #2: Select/Not select pattern. 
// Author: CtCI 8.13 p.366 + kei
// Date  : December 16, 2016

package whiteboard;

import java.util.ArrayList;
import java.util.Collections;


public class Lab_whiteboard {

    public static void main(String[] args) {

        
        ArrayList<Box> boxes = new ArrayList<>();
        Box aBox = new Box("A", 5, 5, 5);
        Box bBox = new Box("B", 4, 3, 4);
        Box cBox = new Box("C", 3, 4, 2);
        Box dBox = new Box("D", 1, 2, 1);
        boxes.add(aBox);
        boxes.add(cBox);
        boxes.add(dBox);
        boxes.add(bBox);

        
        System.out.println(getMaxHeight(boxes)); // 11
        System.out.println(getMaxHeight2(boxes)); // 11
        
        
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    
    

    // Solution #1
    // For-loop pattern. 
    // Author: CtCI 8.13 p.366 + kei
    // Date  : December 16, 2016
    public static int getMaxHeight(ArrayList<Box> boxes) {
        // Note that the compareTo() is made  
        // to get descending order. 
        Collections.sort(boxes);
        
        int maxHeight = 0;
        int[] memoMaxHeight = new int[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            int height = getMaxHeight(boxes, i, memoMaxHeight);
            maxHeight = Math.max(maxHeight, height);
        }
        
        return maxHeight;
    }
    public static int getMaxHeight(
            ArrayList<Box> boxes, int bottomIdx, int[] memoMaxHeight) {
        if (bottomIdx < boxes.size() /* Avoid out of bound. */
            && memoMaxHeight[bottomIdx] > 0) {
            /* Memoization. */
            return memoMaxHeight[bottomIdx];
        }
        
        Box bottom = boxes.get(bottomIdx);
        int maxHeight = 0;
        // Get the max height after experimenting with each box as a bottom. 
        // This is what the pattern name comes from. 
        for (int i = bottomIdx + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = getMaxHeight(boxes, i, memoMaxHeight);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.height;
        
        // Memoization. 
        memoMaxHeight[bottomIdx] = maxHeight;
        
        return maxHeight;
    }
    
    
    // Solution #2
    // Select/Not select pattern. 
    // Author: CtCI 8.13 p.368 + kei
    // Date  : December 16, 2016
    public static int getMaxHeight2(ArrayList<Box> boxes) {
        // Sort by descending order of height. 
        // compareTo() is modified a bit. 
        Collections.sort(boxes);
        int[] memoMaxHeight = new int[boxes.size()];
        
        return getMaxHeight2(boxes, null, 0, memoMaxHeight);
    }
    // Get the max height of a stack whose bottom box index is 'currBoxIdx'. 
    // 'bottom' is below the current bottom box. 
    public static int getMaxHeight2(
            ArrayList<Box> boxes, Box bottom, int currBoxIdx, int[] memoMaxHeight) {
        // Base case. 
        if (currBoxIdx >= boxes.size()) {
            return 0;
        }
        
        // Get height with the current bottom box. (Select)
        Box newBottom = boxes.get(currBoxIdx);
        int heightWithCurrBox = 0;
        // Check if the 'newBottom' can be above 'bottom'.
        if (bottom == null || newBottom.canBeAbove(bottom)) {
            if (memoMaxHeight[currBoxIdx] > 0) {
                // Recall memo. 
                heightWithCurrBox = memoMaxHeight[currBoxIdx];
            } else {
                // Recursion. 
                // Insert memo. 
                memoMaxHeight[currBoxIdx] = 
                        getMaxHeight2(boxes, newBottom, currBoxIdx + 1, memoMaxHeight)
                        + newBottom.height;
                heightWithCurrBox = memoMaxHeight[currBoxIdx];
            }
        }
        
        // Get height without the current bottom box. (Not select)
        int heightWithoutCurrBox = 
                    getMaxHeight2(boxes, bottom, currBoxIdx + 1, memoMaxHeight);
        
        // Return better of two options. 
        return Math.max(heightWithCurrBox, heightWithoutCurrBox);       
    }
    
    
    
    
    
    
    
    
    
}


class Box implements Comparable<Box> {
    String name;
    int width, height, depth;
    
    public Box(String s, int w, int h, int d) {
        this.name = s;
        this.width = w;
        this.height = h;
        this.depth = d;
    }
    
    public boolean canBeAbove(Box b) {
        return this.width < b.width 
                && this.height < b.height
                && this.depth < b.depth;
    }
    
    @Override
    public int compareTo(Box b) {
        // Descending order. 
        return b.height - this.height;      
    }
    
    @Override
    public String toString() {
        return this.name;
    }   
    
}






















