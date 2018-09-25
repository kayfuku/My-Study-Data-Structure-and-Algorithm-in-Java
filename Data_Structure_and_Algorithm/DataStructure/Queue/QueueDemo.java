// Demo of Queue structure. (By Yuuki Hiroshi)

//package pack01;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueDemo 
{

	public static void main(String[] args) 
	{
		// Instantiate LinkedList as a Queue.
		Queue<String> queue = new LinkedList<String>();
		
		// 1. Failure is reported by a return value. offer(). peek(). poll().
		// Add elements. offer().
		queue.offer("Alice");
		System.out.println(queue);
		queue.offer("Bob");
		System.out.println(queue);
		queue.offer("Chris");
		System.out.println(queue);
		queue.offer("Diana");
		System.out.println(queue); 

		// Refer to the head element. peek().
		while (queue.peek() != null) 
		{
			// Take and remove the head elements. poll().
			String name = queue.poll();
			System.out.println("Return value of poll(): " + name);
			System.out.println("queue after the poll(): " + queue);
		}	
		
		System.out.println();
		
		// 2. Failure is reported by an Exception. add(). element(). remove().
		// Add elements. add().
		queue.add("Alice");
		System.out.println(queue);
		queue.add("Bob");
		System.out.println(queue);
		queue.add("Chris");
		System.out.println(queue);
		queue.add("Diana");
		System.out.println(queue);
		
		try
		{
			while (true)
			{
				// Refer to the head element. element().
				String name = queue.element();
				System.out.println("Return value of element(): " + name);	
				
				// Take and remove the head elements. remove().
				name = queue.remove();
				System.out.println("Return value of remove(): " + name);
				System.out.println("queue after the remove(): " + queue);
			}
		} 
		catch (NoSuchElementException e) 
		{
			e.printStackTrace();
		}

		
		
		
		
		
		
	}
}
