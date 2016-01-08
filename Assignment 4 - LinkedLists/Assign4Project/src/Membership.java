
public class Membership {
	String memberID = "";
	int enrollmentYr;

	public Membership() {
		enrollmentYr = 2014;
		memberID += (enrollmentYr + "00" + (Club.numMembers + 1));
	}

	public Membership(String id, int year) {
		memberID = id;
		enrollmentYr = year;
	}

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

	public String toString() {
		String str = "ID: " + memberID + " \tYear: " + enrollmentYr;
		return str;
	}

	public boolean equals(Membership other) {
		if (other.getMemberID().equalsIgnoreCase(memberID))
			return true;
		else
			return false;
	}
}
