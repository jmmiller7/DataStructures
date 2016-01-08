
public class Printer 
{
	int printSpeed;					// printers ppm rating
	boolean busy = false;			// determines if printer is available or busy, initially false
	
	public Printer(int printSpeed)
	{
		this.printSpeed = printSpeed;
	}
	
	public boolean isBusy()
	{
		return busy;
	}
	
	public int startNext(PrintTask newTask)
	{
		int numPages = newTask.getPagesToPrint();
		int printTime = 60/printSpeed * numPages;
		return printTime;
	}
	
	public void setIsBusy(boolean busy)
	{
		this.busy = busy;
	}
	
}