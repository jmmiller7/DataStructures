
public class Membership 
{
	// variables
	String memberID = "";
	int enrollmentYr;
	
	// constructors
	public Membership()
	{
		enrollmentYr = 2014;
		memberID += (enrollmentYr + "00" + (Club.numMembers+1)); 
	}
	
	public Membership(String id, int year)
	{
		memberID = id;
		enrollmentYr = year;
	}
	
	
	// methods
	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int getEnrollmentYr() {
		return enrollmentYr;
	}

	public void setEnrollmentYr(int enrollmentYr) {
		this.enrollmentYr = enrollmentYr;
	}
	
	
	public String toString()
	{
		String str = "ID: " + memberID + " \tYear: " + enrollmentYr;
		return str;
	}
}