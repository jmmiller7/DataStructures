
public class InsertionSort 
{
	int size;
	Comparable[] array;
	
	
	public Comparable[] sort(Comparable[] array)
	{
		this.array = array;
		size = array.length;
		
		for(int i = 1; i < size; i++)
		{
			Comparable temp = array[i];
			int first = 0; 
			int last = i;
			while(first < last)
			{
				int middle = (first+last)/2;
				if(temp.compareTo(array[middle]) > 0)
					first = middle+1;
				else
					last = middle;
			}
			for(int j = i; j > first; j--)
				swap(j-1,j);
		}
		return array;
	}
	
	private void swap(int i, int j)
	{
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
