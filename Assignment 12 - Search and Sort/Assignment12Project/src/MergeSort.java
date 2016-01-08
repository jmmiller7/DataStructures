
public class MergeSort 
{
	Comparable[] values;
	public Comparable[] mergeSort(int first, int last, Comparable[] values)
	// Sorts the values array using the merge sort algorithm.
	{
		this.values = values;
		
		if(first < last)
		{
			int middle = (first + last) / 2;
			sort(first, middle);
			sort(middle+1,last);
			merge(first, middle, middle+1, last);
		}
		return values;
	}
	
	public void sort(int first,int last)
	{
		for(int i = first; i < last; i++)
			if(values[i].compareTo(values[i+1]) > 0)
				swap(i,i+1);
	}
	
	
	private void merge(int leftFirst, int leftLast, int rightFirst, int rightLast)
	{	
		// final sort left half
		sort(leftFirst,leftLast);
		
		// final sort right half
		sort(rightFirst,rightLast);
		
		// merge left and right
		for(int i = rightFirst; i < rightLast; i++)
		{
			insert(values[i],leftFirst,leftLast+1);
			leftLast++;
		}
	}
	
	public void insert(Comparable item, int first, int last)
	{
		for(int i = first; i < last; i++)
		{
			Comparable tmp = values[i];
			int left = 0; 
			int right = i;
			while(left < right)
			{
				int middle = (left+right)/2;
				if(tmp.compareTo(values[middle]) > 0)
					left = middle+1;
				else
					right = middle;
			}
			for(int j = i; j > left; j--)
				swap(j-1,j);
		}
	}
	
	
	private void swap(int i, int j)
	{
		Comparable tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	
}
