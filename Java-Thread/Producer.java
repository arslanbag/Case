import java.util.Timer;
import java.util.TimerTask;

public class Producer {

	
	public static void main(String[] args) 
	{
		Kafka kafka = new Kafka();
		Timer myTimer = new Timer();
		TimerTask task = new TimerTask() 
		{

			@Override
			public void run() 
			{
				kafka.sendMessage("Hello World");
			}
		};

		myTimer.schedule(task, 0, 1000);
	}

}
