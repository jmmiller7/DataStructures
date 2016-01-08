
public class EventHandler2 extends Handler
{
	public void handleEvent(String object, int price)
	{
		//Check to see if w/in budget
		if(price <= 500)
		{
			System.out.println("Department Head can buy the " + object + " because it is within the $500 budget.");
		}
		else
		{
			System.out.println("The " + object + " costs $" + price + " which is above the Department Head's $500 budget.");
			successor.handleEvent(object,price);
		}
			
	}
}