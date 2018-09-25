// Demo of HashMap. (By Yuuki Hiroshi, Tsuboi-san)

//package pack01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo 
{

	public static void main(String[] args) 
	{
		// Instantiate HashMap as a Map. 
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// Add pairs of key and value. put().
		map.put("Alice", 100);
		map.put("Bob", 57);
		map.put("Chris", 85);
		map.put("Diana", 85);
		
		// containsKey("key1"). get("key1").
		if (map.containsKey("Alice"))
		{
			System.out.println("Aliceの値 = " + map.get("Alice"));
	    }
		else
		{
			System.out.println("The key doesn't exist.");
		}
		
		// Get all entries. entrySet() >> getKey(), getValue().
		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println();

		// Get all entries using Iterator. 
		for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) 
		{
			// Get an entry. 
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println();
		
		// Get all keys. keySet().
		for (String name : map.keySet())
		{
			System.out.println(name);
		}
		System.out.println();
		
		// Get all values. values().
		for (int value : map.values())
		{
			System.out.println(value);
		}
		System.out.println();
		
		// Get all keys and values. keySet().
		for (String name : map.keySet())
		{
			System.out.println(name + " : " + map.get(name));
		}
		System.out.println();
		
		// Overwrite the value of a key. put().
		map.put("Bob", 120);
		
		// Get the value of a key. 
		System.out.println("The value of \"Bob\" is " + map.get("Bob"));

		// If you're trying to get the value of the key that doesn't exist ...  
		System.out.println("The value of \"Fred\" is " + map.get("Fred"));

		
		
		// Initial value is null. 
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		System.out.println(map.get(1)); // null
















	}

}
