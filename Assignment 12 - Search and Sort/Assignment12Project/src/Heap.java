
public class Heap<T extends Comparable<T>>
{
	final int MAX_CAP = 50;
	
	T[] theHeap;
	int lastIndex;
	int arrCap;
	
	public Heap()
	{
		theHeap = (T[]) new Object[MAX_CAP];
		arrCap = MAX_CAP;
		lastIndex = -1;
	}
	
	public Heap(int cap)
	{
		theHeap = (T[]) new Object[cap];
		arrCap = cap;
		lastIndex = -1;
	}
	
	public Heap(T[] array)
	{
		theHeap = array;
		arrCap = array.length;
		lastIndex = -1;
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] != null)
				// There is an item in the slot,
				// update lastIndex to keep track.
				lastIndex++;
		}
	}
	
	
	public void makeItHeap()
	{
		// organize the heap
		for(int i = (lastIndex+1)/2; i >= 0; i--)
		{
			heapDown(theHeap[i], i); 
		}
	}
	
	public Object[] heapSort(T[] array)
	{
		Heap<T> temp = new Heap<T>(array);
		temp.makeItHeap();
		
		for(int i = temp.lastIndex; i >= 1; i--)
		{			
			T t = temp.theHeap[0];
			temp.theHeap[0] = temp.theHeap[i];
			temp.theHeap[i] = t;
			temp.lastIndex = i-1;
			
			temp.heapDown(temp.theHeap[0],0);
		}
		return temp.theHeap;
	}
	
	public void enqueue(T item)
	{
		if(isFull()) return;
		lastIndex++;
		heapUp(item);
	}
	
	
	public T dequeue()
	{
		if(isEmpty()) return null;
		T temp = theHeap[0];
		T last = theHeap[lastIndex];
		lastIndex--;
		heapDown(last,0);
		return temp;
	}
	
	
	private void heapUp(T item)
	{		
		int hole = lastIndex;  // child node location
		
		int parent = (hole-1)/2;
		
		while( (hole > 0) && (item.compareTo(theHeap[parent]) > 0) )
		{	
			// item is greater than parent
			// swap parent and child information
			theHeap[hole] = theHeap[parent];
			hole = parent;
			parent = (hole-1)/2;
		}
		theHeap[hole] = item;
	}
	
	
	private void heapDown(T item, int hole)
	{
		int newhole;
		
		newhole = newHole(item, hole);
		
		while(newhole != hole)
		{
			theHeap[hole] = theHeap[newhole];
			hole = newhole;
			newhole = newHole(item, hole);
		}
		theHeap[hole] = item;
	}
	
	private int newHole(T item, int hole)
	{
		int left = 2*hole+1;	  // left child
		int right = left + 1;
		
		if(left > lastIndex) return hole;	// hole has no children
		if(left == lastIndex)				// hole only has left child
		{
			if(theHeap[left].compareTo(item)>0) return left;
			else return hole;
		}
		
		// hole has two children, right is greater than left
		if(theHeap[left].compareTo(theHeap[right]) < 0)
		{
			if(theHeap[right].compareTo(item) <= 0)
				return hole;		// item is greater than right
			else
				return right;		// item is smaller than right child
		}
		
		// left child >= right child && leftChild <= item
		if(theHeap[left].compareTo(item) <= 0) return hole;
		else return left;	// item < left child
		
	}
	
	
	//===========================================================
	//== Problem 2: Print in an inorder fashion =================
	//===========================================================
	public String printInOrder()
	{
		return recPrintInOrder(0);
	}
	
	private String recPrintInOrder(int loc)
	{
		String str = "";
		int left = loc*2+1;
		int right = left + 1;
		
		
		if(left == lastIndex)  
		// only has left child
		{
			str += recPrintInOrder(left);
			str += theHeap[loc] + " ";
		}
		else if(left > lastIndex)
		// no children	
			str += theHeap[loc]  + " ";
		else
		// has left and right children
		{
			str += recPrintInOrder(left);
			str += theHeap[loc] + " ";
			str += recPrintInOrder(right);
		}
		
		return str;
	}
	
	
	public boolean contains(T item)
	{
		return recContains(item,0);
	}
	
	private boolean recContains(T item, int cursor)
	{
		// item doesn't exist OR heap is empty
		if(cursor > lastIndex || cursor < 0)
			return false;
		
		if(theHeap[cursor].equals(item))
			return true;
		else
		{
			return recContains(item, cursor*2+1) || recContains(item, cursor*2+2);
		}
	}
	
	
	
	public boolean isFull()
	{
		return lastIndex == arrCap;
	}
	
	public boolean isEmpty()
	{
		return lastIndex == -1;
	}
	
	public String toString()
	{
		String str = new String();
		
		for(int i = 0; i <= lastIndex; i++)
		{
			str += theHeap[i] + " ";
		}
		
		return str;
	}

}
