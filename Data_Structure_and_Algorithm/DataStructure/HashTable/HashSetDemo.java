// Set demo.

package pack01;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo 
{

	public static void main(String[] args)
	{
		// Instantiate HashSet as a Set. 
		Set<String> set = new HashSet<String>();
		
		// Add elements. add().
		set.add("Alice");
		System.out.println(set);
		set.add("Bob");
		System.out.println(set);
		set.add("Chris");
		System.out.println(set);
		set.add("Diana");
		System.out.println(set);
		set.add("Alice"); // This won't be added because duplication will be removed. 
		System.out.println(set);

		// add/remove() returns true if the original set is changed by that. 
		boolean b = set.add("Chris"); // This should return false. 
		System.out.println(b);

		for (String name : set)
		{
			System.out.println(name);
		}
		
		// Contains "Alice"? contains().
		if (set.contains("Alice"))
		{
			System.out.println("The 'set' contains \"Alice\". ");
		}
		else
		{
			System.out.println("The 'set' doesn't contain \"Alice\". ");
		}


		// Get an element from a set. 
		Object[] elements = set.toArray();

		// Convert Set to ArrayList.
		ArrayList<String> categoryArrayList = new ArrayList<>();
        categoryArrayList.addAll(set);
		
		
		
	}

}





























