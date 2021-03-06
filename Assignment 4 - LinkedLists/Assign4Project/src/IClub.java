public interface IClub 
{	
	public void addMembership();
	
	public void addMembership(String memberID, int enrollmentYr);
	// Precondition:   id is not an empty string, and year must be >= 2000
	// Post-condition: The method adds an object of Membership to the array 
	//				   (at any location) with the given information.
	
	public void removeMembership(String memberID);
	// Precondition:   id is not an empty string
	// Post-condition: The method removes the Membership object from the array
	//				   that matches the given id, or does nothing otherwise. 
	
	public int searchForAMembership(String memberID);
	// Precondition:   id is not an empty string
	// Post-condition: The method returns an index where the object is located in 
	//				   the array that matches the given id, or returns -1 otherwise.
	
	public void removeMembershipOfAYear(int enrollmentYear);
	// Precondition:   year >= 2000 
	// Post-condition: The method removes all Membership objects of a given year, 
	//   			   or does nothing otherwise.
	
//	public double getLargestPercentageMembershipIncreaseSince(int year);	
	// Precondition:   year >= 2000
	// Post-condition: The method returns the largest membership increase since a 
	//				   given year, or -1 if the given year is invalid.
	
	public String toString();
}
