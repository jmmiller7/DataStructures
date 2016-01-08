package student;

import lists.*;
import java.util.*;

public class Gradebook 
{
	public static void main(String[] args)
	{
		Student header = new Student("Aaaaron", "Aaaapple", 0.00);
		Student trailer = new Student("Zzzzeke", "Zzzane", 4.40);
		DLSortedList<Student> gradebook = new DLSortedList<Student>(header,trailer);
		
		System.out.println("* * * Welcome to Gradebook * * *\n");
		
		gradebook.add(new Student("Jake","Miller",3.875));
		gradebook.add(new Student("Mitch","Piel",3.8));
		gradebook.add(new Student("Sam","Piasecki",3.25));
		gradebook.add(new Student("Evan","Jones",2.9));
		gradebook.add(new Student("Aaron","Kumbier",2.5));
		gradebook.add(new Student("Matt","Sells",3.875));
		gradebook.add(new Student("Eric","Manner",3.875));
		
		// --- demo with toString() ---
		System.out.println("--- The following uses toString() ---");
		System.out.println("Original Gradebook: ");
		System.out.println(gradebook);
		
		
		System.out.println("Remove Eric Manner, add Reese Anderson: ");
		gradebook.remove(new Student("Eric","Manner",3.875));
		gradebook.add(new Student("Reese","Anderson",3.9));
		System.out.println(gradebook);
		
		
		// --- using iterator ---
		Iterator<Student> it;
		System.out.println("\n--- The following uses Iterator ---");
		
		// forward (param is true)
		System.out.println("Forward (param is TRUE) :");
		it = gradebook.getIterator(true);
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		// backward (param is false)
		it = gradebook.getIterator(false);
		System.out.println("\nBackward (param is FALSE) :");
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		// copy
		System.out.println("\n--- A copy of gradebook...: ");
		DLSortedList<Student> gradebook2 = new DLSortedList<Student>(gradebook);
		System.out.println(gradebook2);
				
		System.out.println("\n* * * Thank you for using Gradebook * * *");
	}
}
