// Compare ArrayList with Array and LinkedList. 
// (By Myself)

package pack01;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListVsArrayVsLinkedList 
{

	public static void main(String[] args)
	{
        String[] array = new String[1000000];
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
		
		// 1. Appending. (Add to the tail)
		System.out.println("1. Appending. (Add to the tail)");
		// Array.
        long start0 = System.currentTimeMillis();
		
		for (int i = 0; i < 1000000; i++)
		{
			array[i] = "a";
		}
		
		long end0 = System.currentTimeMillis();
		System.out.println("Array: " + (end0 - start0) + " ms.");
		
		// ArrayList.
        long start1 = System.currentTimeMillis();
        
		for (int i = 0; i < 1000000; i++)
		{
			arrayList.add("a");
		}
		
		long end1 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (end1 - start1) + " ms.");
		
		// LinkedList.
        long start2 = System.currentTimeMillis();
        
		for (int i = 0; i < 1000000; i++)
		{
			linkedList.add("a");
		}
		
		long end2 = System.currentTimeMillis();
		System.out.println("LinkedList: " + (end2 - start2) + " ms.");
	    System.out.println();
		
		// 2. Inserting. 
		// 2-1. Inserting to the 1000th element. 
		System.out.println("2-1. Inserting to 1000th element.");
		
		// ArrayList.
        start1 = System.currentTimeMillis();
		        
		for (int i = 0; i < 1000; i++)
		{
			arrayList.add(999, "b");
		}
		
		end1 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (end1 - start1) + " ms."
				+ " 後ろのデータをコピーしてずらす時間がかかる");
		
		// LinkedList.
        start2 = System.currentTimeMillis();
		        
		for (int i = 0; i < 1000; i++)
		{
			linkedList.add(999, "b");
		}
		
		end2 = System.currentTimeMillis();
		System.out.println("LinkedList: " + (end2 - start2) + " ms."
				+ " コピー不要。1000まで到達する時間がO(n)");
		System.out.println();
		
		// 2-2. Inserting to the 1st element.
		System.out.println("2-2. Inserting to the 1st element.");
		
		// ArrayList.
        start1 = System.currentTimeMillis();
		        
		for (int i = 0; i < 1000; i++)
		{
			arrayList.add(0, "c");
		}
		
		end1 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (end1 - start1) + " ms."
				+ " 後ろのデータをコピーしてずらす時間がかかる");
		
		// LinkedList.
        start2 = System.currentTimeMillis();
		        
		for (int i = 0; i < 1000; i++)
		{
			linkedList.add(0, "c");
		}
		
		end2 = System.currentTimeMillis();
		System.out.println("LinkedList: " + (end2 - start2) + " ms."
				+ " Java の LinkedList は Doubly Linked List で " + "\n"
				+ " head と tail へのアクセスは O(1)");
		System.out.println();
		
		// 2-3. Inserting to the tail.
		System.out.println("2-3. Inserting to the tail.");
		
		// ArrayList.
        start1 = System.currentTimeMillis();
		        
		for (int i = 0; i < 1000; i++)
		{
			arrayList.add("c");
		}
		
		end1 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (end1 - start1) + " ms."
				+ " コピー不要");
		
		// LinkedList.
        start2 = System.currentTimeMillis();
		        
		for (int i = 0; i < 1000; i++)
		{
			linkedList.add("c");
		}
		
		end2 = System.currentTimeMillis();
		System.out.println("LinkedList: " + (end2 - start2) + " ms.");
		System.out.println();
		
		// 3. Removing.
		System.out.println("3. Removing.");
		// Array.
        start0 = System.currentTimeMillis();
        
        String[] arrayR = new String[999999];
		
        for (int i = 0; i < 1000; i++) 
        {
        	for (int j = 0; j < 999999; j++)
    		{
    			arrayR[j] = array[j + 1];
    		}
		}
		
		end0 = System.currentTimeMillis();
		System.out.println("Array: " + (end0 - start0) + " ms.");
		
		// ArrayList.
        start1 = System.currentTimeMillis();
		        
		for (int i = 0; i < 1000; i++)
		{
			arrayList.remove(0);
		}
		
		end1 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (end1 - start1) + " ms.");
		
		// LinkedList. (head)
        start2 = System.currentTimeMillis();
		        
		for (int i = 0; i < 1000; i++)
		{
			linkedList.remove(0);
		}
		
		end2 = System.currentTimeMillis();
		System.out.println("LinkedList (head): " + (end2 - start2) + " ms.");
		
		// LinkedList. (1000th)
        start2 = System.currentTimeMillis();
		        
		for (int i = 0; i < 1000; i++)
		{
			linkedList.remove(1000);
		}
		
		end2 = System.currentTimeMillis();
		System.out.println("LinkedList (1000th): " + (end2 - start2) + " ms.");
		System.out.println();
		
		// 4. Referring the 1000th element.
		System.out.println("4. Referring the 1000th element.");
		String v;
		// Array.
        start0 = System.currentTimeMillis();
        		        
		for (int i = 0; i < 10000; i++)
		{
			v = array[999];
		}
		
		end0 = System.currentTimeMillis();
		System.out.println("Array: " + (end0 - start0) + " ms."
				+ " O(1)");
		
		// ArrayList.
        start1 = System.currentTimeMillis();
		        
		for (int i = 0; i < 10000; i++)
		{
			v = arrayList.get(999);
		}
		
		end1 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (end1 - start1) + " ms."
				+ " O(1)");
		
		// LinkedList.
        start2 = System.currentTimeMillis();
		        
		for (int i = 0; i < 10000; i++)
		{
			v = linkedList.get(999);
		}
		
		end2 = System.currentTimeMillis();
		System.out.println("LinkedList: " + (end2 - start2) + " ms."
				+ " O(n)");	
		System.out.println();
		
		// 5. Retrieving.
		System.out.println("5. Retrieving.");
		// Array.
        start0 = System.currentTimeMillis();
        		        
		for (int i = 0; i < 999999; i++)
		{
			if (array[i].equals("b"))
			{
				break;
			}
		}
		
		end0 = System.currentTimeMillis();
		System.out.println("Array: " + (end0 - start0) + " ms."
				+ " Linear Search");
		
		// ArrayList.
        start1 = System.currentTimeMillis();
		        
		for (int i = 0; i < 999999; i++)
		{
			if (arrayList.get(i).equals("b"))
			{
				break;
			}
		}
		
		end1 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (end1 - start1) + " ms.");
		
		// LinkedList.
        start2 = System.currentTimeMillis();
		        
        for (int i = 0; i < 999999; i++)
		{
			if (linkedList.get(i).equals("b"))
			{
				break;
			}
		}
		
		end2 = System.currentTimeMillis();
		System.out.println("LinkedList: " + (end2 - start2) + " ms.");	
		System.out.println();
	
//		1. Appending. (Add to the tail)
//		Array: 22 ms.
//		ArrayList: 65 ms.
//		LinkedList: 67 ms.
//
//		2-1. Inserting to 1000th element.
//		ArrayList: 407 ms. 後ろのデータをコピーしてずらす時間がかかる
//		LinkedList: 9 ms. コピー不要。1000まで到達する時間がO(n)
//
//		2-2. Inserting to the 1st element.
//		ArrayList: 381 ms. 後ろのデータをコピーしてずらす時間がかかる
//		LinkedList: 0 ms.
//
//		2-3. Inserting to the tail.
//		ArrayList: 0 ms.
//		LinkedList: 0 ms.
//
//		3. Removing.
//		Array: 1380 ms.
//		ArrayList: 349 ms.
//		LinkedList (head): 0 ms.
//		LinkedList (1000th): 3 ms.
//
//		4. Referring the 1000th element.
//		Array: 0 ms. O(1)
//		ArrayList: 3 ms. O(1)
//		LinkedList: 23 ms. O(n)
//
//		5. Retrieving.
//		Array: 17 ms. Linear Search
//		ArrayList: 0 ms.
//		LinkedList: 1 ms.
//
//		done.


		
		
		
		
		
		
			
		System.err.println("done.");  
	    return;
	} // end of main().
}



















