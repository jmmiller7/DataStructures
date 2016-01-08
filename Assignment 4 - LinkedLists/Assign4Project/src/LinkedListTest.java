import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class LinkedListTest {

	Club fitness = new Club();
	
	@Test
	public void test() {
		fitness.addMembership("JMiller14", 2014);
		fitness.addMembership("jmmiller",2014);
		fitness.addMembership("MPiel13",2013);
		
		
		
		fitness.members.removeSecond(3);
		
		assertEquals("ID: Mpiel13 " + " \tYear: 2013:"+ "\nID: JMiller14" + " \tYear:2014");
	}

}
