// Map/Set fundamentals. 



// The value that has not been put in yet returns null. 
// Author: kei
// Date  : October 14, 2016
HashMap<Integer, Integer> map = new HashMap<>();
System.out.println(map.get(0)); // null

int n = map.get(0); // NullPointerException. 
System.out.println(n); 

// You can set default to anything using getOrDefault(...).
HashMap<Integer, Integer> map = new HashMap<>();
int n = map.getOrDefault(0, 1);
System.out.println(n); // 1



// You need to implement hashCode() and equals() 
// when you create your own data structure in order to
// determine what does equals() mean. 
// Use eclipse. Select the class name and right click and
// select source/generate hashCode() and equals().
// This rules are also applied to set.contains(key) or
// map.containsKey(key).

// Author: kei
// Date  : October 6, 2016

package pack01;

import java.util.HashMap;

public class 00_Warning_Map_Set {

	public static void main(String[] args) {		
		HashMap<Point, Boolean> memo = new HashMap<Point, Boolean>();
		Point p = new Point(3, 5);
		memo.put(p, true);
		Point point = new Point(3, 5);
		System.out.println(memo.containsKey(point)); // true


		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
		
		// We can loop a Map with forEach and lambda expression. 
		items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
		// Item : A Count : 10
		// Item : B Count : 20
		// Item : C Count : 30
		// Item : D Count : 40
		// Item : E Count : 50
		// Item : F Count : 60
		
		items.forEach((k,v)->{
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});
		// Item : A Count : 10
		// Item : B Count : 20
		// Item : C Count : 30
		// Item : D Count : 40
		// Item : E Count : 50
		// Hello E
		// Item : F Count : 60
		
		
		System.out.println();
		System.out.println("done.");
		return;
	} // end of main().

}

class Point {
	int row, col;	
	
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	// Auto-generated.
	// Use eclipse. point the class name and right click and
	// select source/generate hashCode() and equals(). 
	// And check row and col so that 
	// two points are equal if they have the same coordinate.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
    
	// Auto-generated.
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + row + ", " + col + ")";
	}
	
}





























