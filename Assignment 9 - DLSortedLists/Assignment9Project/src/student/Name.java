package student;

import java.util.*;

public class Name implements Comparable<Name>
{
	String first;
	String last;
	
	public Name(String first, String last)
	{
		this.first = first;
		this.last = last;
	}
	
	public void setFirst(String first)
	{
		this.first = first;
	}
	
	public String getFirst()
	{
		return first;
	}
	
	public void setLast(String last)
	{
		this.last = last;
	}
	
	public String getLast()
	{
		return last;
	}
	
	public String toString()
	{
		String str = last + ", " + first;
		return str;
	}
	
	public boolean equals(Name rem)
	{
		if(last.equalsIgnoreCase(rem.last))
			if(first.equalsIgnoreCase(rem.first))
				return true;
			else
				return false;
		else
			return false;
	}
	
	
	public int compareTo(Name stuName) {
		if(!last.equals(stuName.last))
			return last.compareTo(stuName.last);
		else if(!first.equals(stuName.first))
			return first.compareTo(stuName.first);
		else return 0;
	}
	
}
