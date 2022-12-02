
public class Customer 
{
	ThreadClass thread1 = new ThreadClass("Thread1");
	ThreadClass thread2 = new ThreadClass("Thread2");
	ThreadClass thread3 = new ThreadClass("Thread3");
	ThreadClass thread4 = new ThreadClass("Thread4");
	ThreadClass thread5 = new ThreadClass("Thread5");
	
	public boolean sendMessage(String message) 
	{
		if(thread1.isStatus()) 
		{
			thread1.setMessage(message);
			thread1.start();
		}
		if(thread2.isStatus()) 
		{
			thread2.setMessage(message);
			thread2.start();
		}
		if(thread3.isStatus()) 
		{
			thread3.setMessage(message);
			thread3.start();
		}
		if(thread4.isStatus()) 
		{
			thread4.setMessage(message);
			thread4.start();
		}
		if(thread5.isStatus()) 
		{
			thread5.setMessage(message);
			thread5.start();
		}
		else 
		{
			return false;
		}
			return true;
	}
}
