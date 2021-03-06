// 1. Convert String Array to ArrayList<String>. 
// 2. Convert Integer Array to ArrayList<Integer>. 
// 3. Convert String Array to List<String>. 
// 4. Convert ArrayList<String> to String Array. 


//package pack01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToFromArrayList 
{

	public static void main(String[] args)
	{
		
		
		// 1. String Array to ArrayList<String>. using "java.util.Arrays". 
		String[] arrayStrings = {"a", "b", "c"};
		List<String> arrayList = new ArrayList<String>(Arrays.asList(arrayStrings));
		for (String str : arrayList) 
		{
			System.out.println(str);
		}

		System.out.println();
		
		// 2. Integer Array to ArrayList. 
		// Be aware that it is not int[] but Integer[]!!
		Integer[] nums = {2, 2, 5, 2, 3, 4, 2, 2, 5, 9};
		List<Integer> arrayListIntegers = new ArrayList<Integer>();
		List<Integer> listIntegers = Arrays.asList(nums);
		arrayListIntegers.addAll(listIntegers);
		// List<Integer> arrayListIntegers = new ArrayList<>(Arrays.asList(nums));
        // might also be ok.
		for (int num: arrayListIntegers) 
		{
			System.out.println(num);
		}
				
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(list.toString()); // [1, 2, 3, 4, 5]


		
		
		System.out.println();


		
		// 3. String Array to List<String>. 
		String[] arrayStrings2 = {"a", "b", "c"};
		List<String> list = Arrays.asList(arrayStrings2);
		for (String str : list) 
		{
			System.out.println(str);
		}
		
		System.out.println();
		


		// 4. ArrayList<String> to a String Array.
		// Author: kei
		// Date  : February 12, 2017
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
	 
	    String[] array = new String[list.size()];
	    array = list.toArray(array);
	 
	    System.out.println(Arrays.toString(array)); // [a, b, c]

		
		

	}

}
