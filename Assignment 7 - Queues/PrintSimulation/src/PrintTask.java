import java.util.Random;

public class PrintTask 
{
	private static final int MIN_NUM_PAGES = 1;		// min num pages to print
	private static int maxNumPages;					// largest allowable task
	static Random rand = new Random();
	private int pagesToPrint = 0;
	private int	timeEnqueued;	// the time that the task is recieved and enqueued
	
	public PrintTask()
	{
		pagesToPrint = rand.nextInt(maxNumPages) + 1;
	}
			
	public int getPagesToPrint()
	{
		return pagesToPrint;
	}
	
	public void setPagesToPrint(int pages)
	{
		pagesToPrint = pages;
	}
	
	public int getTimeEnqueued()
	{
		return timeEnqueued;
	}
	
	public void setTimeEnqueued(int time)
	{
		this.timeEnqueued = time;
	}
	
	public int waitTime(int currentTime)
	{
		int timeWaited;
		timeWaited = currentTime - timeEnqueued;
		return timeWaited;
	}
	
	public static void setMaxNumPages()
	{
		maxNumPages = rand.nextInt(100) + 1;
	}
	
	public static int getMaxNumPages()
	{
		return maxNumPages;
	}
}