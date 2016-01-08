import java.util.*;

public class Assign12App<T>
{
	public static void main(String[] args)
	{
		// Demo Problem 2
		System.out.println("Problem 2: ");
		System.out.println("--------------------------------");
		Heap<Integer> heap = new Heap(new Integer[] {5,8,3,1,7,10});
	
		heap.makeItHeap();
		
		System.out.println("Heap:    " + heap);		
		System.out.println("InOrder: " + heap.printInOrder());
		System.out.println();
		
		// Demo Problem 3
		System.out.println("Problem 3: ");
		System.out.println("--------------------------------");
		InsertionSort is = new InsertionSort();
		Comparable[] arr = new Comparable[]{1,3,6,10,2,9,5};
		System.out.println("Before: " + printArray(arr));
		arr = is.sort(arr);
		System.out.println("After:  " + printArray(arr));
		System.out.println();
		
		
		// Demo Problem 4
		System.out.println("Problem 4: ");
		System.out.println("--------------------------------");
		MergeSort ms = new MergeSort();
		Comparable[] values = new Comparable[]{4,8,2,22,16,5};
		System.out.println("Before: " + printArray(values));
		values = ms.mergeSort(0, (values.length-1), values);
		System.out.println("After:  " + printArray(values));	
	}
	
	public static String printArray(Comparable[] arr)
	{
		String str = "";
		
		for(int i = 0; i < arr.length; i++)
		{
			str += arr[i] + " ";
		}
		return str;
	}
}

