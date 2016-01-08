
public class LinkedQueue<T> 
{
	private QueueNode<T> front;
	private QueueNode<T> rear;
	private int numItems;
	
	// Default Constructor
	public LinkedQueue() 
	{
		front = rear = null;
		numItems = 0;
	}
	
	
	public void enqueue(T item)
	{
		QueueNode<T> newNode = new QueueNode<T>(item);
		if(rear == null)
		{
			front = newNode;
		}
		else
		{
			rear.setLink(newNode);
		}
		
		numItems++;
		rear = newNode;
	}
	
	
	public T dequeue()
	{
		T toReturn = null;
		
		if(!isEmpty())
		{
			toReturn = front.getInfo();
			front = front.getLink();
			numItems--;
			
			if(front == null)
				rear = null;
		}
			
		return toReturn;
	}
	
	
	public boolean isEmpty()
	{
		return numItems == 0;
		// return front == null;
	}
	
	public int getNumItems()
	{
		return numItems;
	}
	
	
	public String toString()
	{
		String str = "";
		QueueNode<T> cursor = front;
		
		while(cursor != null)
		{
			str += cursor.getInfo() + "\n";
			cursor = cursor.getLink();
		}
		
		
		
		return str;
	}
	
	
	
	
	
}


class QueueNode<T>
{
	private T info;
	private QueueNode<T> link;
	
	public QueueNode(T item) 
	{
		info = item;
		link = null;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public QueueNode<T> getLink() {
		return link;
	}

	public void setLink(QueueNode<T> link) {
		this.link = link;
	}
	
	
}