// Demo of Stack structure. (By Yuuki Hiroshi)

//package pack01;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackAndDequeDemo
{

	public static void main(String[] args) 
	{
		// Instantiate LinkedList as a Stack. After Java SE 7. 
		// push(). getFirst(). pop(). 
		Deque<String> stack = new LinkedList<>();
		
		// Add elements. push(). 
		stack.push("Alice");
		System.out.println(stack);
		stack.push("Bob");
		System.out.println(stack);
		stack.push("Chris");
		System.out.println(stack);
		stack.push("Diana");
		System.out.println(stack); 
		
		try 
		{
			while (true) 
			{
				// Refer to the head element. getFirst().
				String name = stack.getFirst();
				System.out.println("Return value of getFirst(): " + name);	
				
				// Take and remove the elements. pop().
				name = stack.pop();
				System.out.println("Return value of pop(): " + name);
				System.out.println("stack after the pop(): " + stack);
			}
		} 
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
		}
		
		
		// Instantiate LinkedList as a Stack. Before Java SE 7. 
		// addFirst(). getFirst(). removeFirst(). 
		LinkedList<String> stackOld = new LinkedList<>();
		
		// Add elements. addFirst(). 
		stackOld.addFirst("Alice");
		System.out.println(stackOld);
		stackOld.addFirst("Bob");
		System.out.println(stackOld);
		stackOld.addFirst("Chris");
		System.out.println(stackOld);
		stackOld.addFirst("Diana");
		System.out.println(stackOld); 
		
		try 
		{
			while (true) 
			{
				// Refer to the head element. getFirst().
				String name = stackOld.getFirst();
				System.out.println("Return value of getFirst(): " + name);	
				
				// Take and remove the elements. removeFirst().
				name = stackOld.removeFirst();
				System.out.println("Return value of removeFirst(): " + name);
				System.out.println("stack after the removeFirst(): " + stackOld);
			}
		} 
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}
}
