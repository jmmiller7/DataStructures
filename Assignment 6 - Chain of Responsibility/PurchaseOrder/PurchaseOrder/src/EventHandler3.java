
public class EventHandler3 extends Handler
{
	public void handleEvent(String object, int price)
	{
		//Check to see if w/in budget
		System.out.println("The District Manager approves the $" + price + " " + object + " purchase.");
		
	}
}
