
public class Recursion 
{
	static String indent = "";
	public static void main(String[] args)
	{
		System.out.println("* * * * *    Welcome to Examples of Recursion    * * * * *\n");
		// Reverse an array of chars
		System.out.println("**TASK 1: Reverse an array of chars.");
		System.out.println("  This method will pass a char[] containing \"a_dog_saw_rats\", ");
		System.out.println("  and it will reverse all of the chars after \"a_\" ");
		System.out.println("-------------------------------------------------------------");
		char[] arr = new char[]{'a','_','d','o','g','_','s','a','w','_','r','a','t','s'};
		System.out.println(arr);
		reverseArray(arr,2,arr.length-1);
		System.out.println(arr);
		System.out.println("\n\n");
		
		// print level	
		System.out.println("**TASK 2: printLevel(int currLvl,int max)");
		System.out.println("  This method creates and prints 4 levels");
		System.out.println("-------------------------------------------------------------");
		printLevel(0,4);
		System.out.println("\n\n");
		
		// rotateR
		System.out.println("**TASK 3: rotateR(String str, int numToMove)");
		System.out.println("  This method rotates a \"hello\" by 3 characters");
		System.out.println("-------------------------------------------------------------");
		String str = "hello";
		System.out.println("Before:\t" + str);
		str = rotateR(str,3);
		System.out.println("After:\t" +str);
		System.out.println("\n\n");
		
		// retainSpecifiedContent
		System.out.println("**TASK 4: retainSpecifiedContent(str)");
		System.out.println("  This method takes a String and returns the"
							+ "\n  content between parenthesis");
		System.out.println("-------------------------------------------------------------");
		str = "xyz(abc)123";
		System.out.print(str + "\t-->  ");
		str=retainSpecifiedContent(str);
		System.out.println(str);
		str = "x(hello)";
		System.out.print(str + "\t-->  ");
		str=retainSpecifiedContent(str);
		System.out.println(str);
		
		
		
	}
	
	public static void reverseArray(char[]arr, int lower, int upper)
	{
		if(lower > upper)
			return;
		
		char temp = arr[lower];
		
		arr[lower] = arr[upper];
		arr[upper] = temp;
		reverseArray(arr,lower+1,upper-1);
	}
	
	
	public static void printLevel(int currLvl, int max)
	{
		if(currLvl >= max)
			return;
		else
		{
			System.out.println(indent + "This was written by call number " + (currLvl+1));
			indent += "   ";
			printLevel(currLvl+1,max);
			indent = indent.substring(3);
			System.out.println(indent + "This was ALSO written by call number " + (currLvl+1));
		}
	}
	
	
	public static String rotateR(String str, int numToMove)
	{
		if(numToMove <= 1)
			return str;
		else
		{
			char temp = str.charAt(str.length()-1);
			str = str.substring(0, str.length()-1);
			str = temp + str;
			str = rotateR(str,numToMove-1);	
			return str;
		}
	}
	
	
	public static String retainSpecifiedContent(String str)
	{
		// remove everything up to opening parenthesis
		if( str.contains("(") )
			str = retainSpecifiedContent(str.substring(1));
		
		// remove everything after and inc closing parenthesis
		else if( str.contains(")") )
			str = retainSpecifiedContent(str.substring(0,str.length()-1));
		
		// add parenthesis to given pair
		else
			str = "(" + str + ")";
		
		return str;
	}
	
}