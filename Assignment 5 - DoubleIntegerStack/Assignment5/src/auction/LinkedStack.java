package auction;

public class LinkedStack<T> 
{
	protected LLNode<T> top;
	
	public LinkedStack()
	{
		top = null;
	}


	public void push(T element)
	{
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
	}
	
	public void pop()
	{
		if(!isEmpty())
		{
			top = top.getLink();
		}
		else
			throw new StackUnderflowException("Pop attempted" +
							" on an empty stack.");
	}
	
	public T top()
	{
		if(!isEmpty())
			return top.getInfo();
		else
			throw new StackUnderflowException("Top attempted" + 
								" on an empty stack.");
	}
	
	public boolean isEmpty()
	{
		if(top == null)
			return true;
		else
			return false;
	}
	
	
	public String toString()
	{
		String str = "";
		LLNode<T> cursor = top;
		
		while(cursor != null)
		{
			str += cursor.getInfo().toString();
			cursor = cursor.getLink();
		}
		
		return str;
		
	}
	
}
