import java.util.*;

public class PurchaseDemo 
{
	public static Handler createChain()
	{
		Handler employee = new EventHandler1();
		Handler deptHead = new EventHandler2();
		Handler distMngr = new EventHandler3();
		
		employee.setSuccessor(deptHead);
		deptHead.setSuccessor(distMngr);
		
		return employee;
	}
	
	
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		Handler chain = createChain();
		
		int price = 0;
		String object = "";
		
		System.out.println("* * * Welcome to Purchase Order * * *\n");
		System.out.print("What would you like to order? ");
		object = keyboard.nextLine();
		System.out.print("How much do " + object + " cost? ");
		price = keyboard.nextInt();
		
		System.out.println("");
		
		chain.handleEvent(object, price);
		
		System.out.println("\n* * * Thanks for using Purchase Order * * *\n");
	}
}