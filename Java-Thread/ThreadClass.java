
public class ThreadClass implements Runnable
{
	private Thread thread; 
	private String threadName;
	private String message = "";
	private boolean status = true;
	
	public ThreadClass(String threadName)
	{	
		this.threadName = threadName;
	}
	
	public boolean isStatus() 
	{
		return status;
	}
	
	public void setStatus(boolean status) 
	{
		this.status = status;
	}

	
	public void setMessage(String message) 
	{
		this.message = message;
	}
	

	@Override
	public void run() 
	{
		try 
		{
			int sleepTime = (int)(Math.random()*10000)+5000;
			Thread.sleep(sleepTime);
			setStatus (false);
			System.out.println(threadName+"("+sleepTime+"):"+message);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Thread kesildi"+ threadName);
			e.printStackTrace();
		}
		setStatus (true);
	}
	
	public void start() 
	{
		thread = new Thread(this, threadName);
		thread.start();
	
	}

}
