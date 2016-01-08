package student;

import java.util.*;

public class Student implements Comparable<Student>
{
	Name stuName;
	double gpa;
	
	public Student(String first, String last, double gpa)
	{
		stuName = new Name(first, last);
		if(gpa >= 0 && gpa < 4.1)
			this.gpa = gpa;
		else
			this.gpa = 0;
	}
	
	public void setGPA(double gpa)
	{
		this.gpa = gpa;
	}

	public double getGPA() 
	{
		return gpa;
	}
	
	public Name getName()
	{
		return stuName;
	}

	public String toString()
	{
		String str;
		
		str = stuName + "\tGPA: " + gpa;
		
		return str;
	}
	
	public int compareTo(Student b) {
		if(gpa > b.getGPA())
			return -1;
		else if (gpa == b.getGPA()) // gpa is same, compare by name
			return stuName.compareTo(b.stuName);
		else
			return 1;
	}
}
