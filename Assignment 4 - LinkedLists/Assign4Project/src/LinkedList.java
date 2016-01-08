// Generic Class
import java.util.*;

public class LinkedList<T>
{
	// === inner class Node=======================================
	class Node
	{
		Membership member;
		Node link;
		
		public Node(Membership member, Node link)
		{
			this.member = member;
			this.link = link;
		}
		
		// this is where you would put node getters and setters 
	}
	// end Node===================================================
	
		
	// LinkedList Class Variables
	Node head;
	int numMembers = 0;
	
	
	// LinkedList Default Constructor
	public LinkedList()
	{
		head = null;
		numMembers = 0;
	}
	
	
	// add a node
	public void add(Membership member)
	{
		Node newNode = new Node(member, head);
		head = newNode;
		numMembers++;
	}
	

	// return where a member with certain memberID is 
	public int contains(String memberID)
	{
		Node cursor = head;
		int position = 1; 
		
		while(cursor != null)
		{
			if(cursor.member.getMemberID().equals(memberID))
				return position;
			cursor = cursor.link;
			position++;
		}
		
		return position;
	}
	
	
	
	// add last
	public void addLast(Membership member)
	{
		Node cursor = head;
				
		Node newNode = new Node(member,null);
		numMembers++;
		
	   if (head == null) 
	   {
	       head = newNode;
	       return;
	   }
	
	  
	   while ((cursor.link != null)) 
	   {
	       cursor = cursor.link;
	   }
	
	   
	  cursor.link = newNode;
	}
	
	
	// remove a single membership
	public void removeMembership(String memberID)
	// Precondition:   id is not an empty string
	// Post-condition: The method removes the Membership object from the array
	//				   that matches the given id, or does nothing otherwise. 
	{
		if(memberID.equals(""))
			return;
		
			if(head.member.getMemberID().equals(memberID))
			{	
				head = head.link;
				numMembers--;
				return;
			}
			
			Node	cursor = head,
					preCursor = null;
			boolean found = false;
			
			while(cursor != null)
			{
				if(cursor.member.getMemberID().equals(memberID))
				{
					found = true;
					break;
				}
				preCursor = cursor;
				cursor = cursor.link;
			}
			
			if(found)
			{
				preCursor.link = cursor.link;
				numMembers--;
			}
	}
	
	
	
	
	//remove membership of a year -------------------------------------
	public void removeMembershipOfAYear(int enrollmentYear)   
	// Precondition:   year >= 2000 
	// Post-condition: The method removes all Membership objects of a given year, 
	//   			   or does nothing otherwise.
	{
		if(enrollmentYear < 2000)
			return;
		
		if(head.member.getEnrollmentYr() == enrollmentYear)
		{	
			head = head.link;
			numMembers--;
			return;
		}
		
		Node	cursor = head,
				preCursor = null;
		
		
		while(cursor != null)
		{
			if(cursor.member.getEnrollmentYr() == enrollmentYear)
			{
				preCursor.link = cursor.link;
				numMembers--;
			}
			else
				preCursor = cursor;
			
			cursor = cursor.link;
		}
	}
		
	
	
	// remove second
	public void removeSecond(int cntItems)
	{	
		if(cntItems < 2)
			return;
		
		head.link = head.link.link;
	}
	
	
	// retrieve every other item ======================================================
	public List<Membership> retrieveEveryOtherItem()
	{
		List<Membership> list = new ArrayList<Membership>();
		
		Node cursor = head;
			 
		
		while(cursor != null)
		{
			list.add(cursor.member);
			//if(cursor.link.link != null)
			//	list.add(cursor.link.link.member); 
			
			cursor = cursor.link;
			if(cursor != null)
				cursor = cursor.link;
		}
		
		return list;
	}
	
	
	
	public int getSize()
	{
		return numMembers;
	}
	
	public String toString()
	{
		String str = "";
		Node cursor = head;
		
		while(cursor != null)
		{
			str += cursor.member.toString() + "\n";
			cursor = cursor.link;
		}
		
		return str;
	}
	
	
}