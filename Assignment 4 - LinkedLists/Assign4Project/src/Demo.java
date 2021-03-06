import java.util.*;

public class Demo {

	static Club test;

	public static void main(String[] args) {
		// instantiate fitness and add members
		Club fitness = new Club();
		test = fitness;

		fitness.addMembership("JMiller14", 2014);
		fitness.addMembership();
		fitness.addMembership("MWehking14", 2014);
		fitness.addMembership("MKellner14", 2014);
		fitness.addMembership("JHolent11", 2011);
		fitness.addMembership("DBrad", 2011);
		fitness.addMembership();
		fitness.addMembership("CMiller12", 2012);
		fitness.addMembership("AJones13", 2014);
		fitness.addMembership("JNoyes13", 2013);
		fitness.addMembership("RMiller13", 2013);
		fitness.addMembership("JPeek", 2011);
		fitness.addMembership("WPiel14", 2014);
		fitness.addMembership("MPiel13", 2013);
		fitness.addMembership("CPiel13", 2013);
		fitness.addMembership("CHolent", 2013);
		fitness.addMembership("PMoff", 2014);
		fitness.addMembership("KMoff", 2014);
		fitness.addMembership("AMoff", 2014);
		fitness.addMembership("JPia", 2011);
		fitness.addMembership("AVick", 2012);

		System.out.println("----------- Starting Member Totals -------");
		System.out.println(getTots());

		System.out.println("----------- Add one member to 2011 and Remove one from 2014 -------");
		fitness.addMembership("MKon", 2011);
		fitness.removeMembership("MWehking14");
		System.out.println(getTots());

		System.out.println("--------- Determine Best Year After 2011 ----");
		double largestInc = (fitness.largestPrcntIncreaseSince(2011));
		System.out.println("Percent Increase: " + largestInc + " %");

		System.out.println("\n----------- Remove all 2013 Members -------");
		fitness.removeMembershipOfAYear(2013);
		System.out.println(getTots());

		System.out.println("\n------ Members at Club Fitness -------");
		System.out.println(fitness);

		int memIndex = -2;
		String memToFind = "WPiel14";
		memIndex = fitness.searchForAMembership(memToFind);
		System.out.println(memToFind + " is number " + memIndex + " on the list.");

		System.out.println("\n------ Add member to end -------");
		fitness.addToLast("Jesse14", 2014);
		System.out.println(fitness);

		System.out.println("------ Remove 2nd member -------");
		fitness.members.removeSecond(fitness.getNumMembers());
		System.out.println(fitness);

		System.out.println("\n------ Retrieve Every Other-------");
		List<Membership> everyOther;
		everyOther = fitness.members.retrieveEveryOtherItem();

		for (Membership member : everyOther)
			System.out.println(member);
	}

	public static String getTots() {
		String str = "";

		int years[];
		years = test.getYears();
		int[] popPerYr = new int[years.length];

		for (int i = 0; i < years.length; i++) {
			popPerYr[i] = test.getPopPerGivenYr(years[i]);
			str += popPerYr[i] + " members in " + years[i] + "\n";
		}

		return str;
	}
}
