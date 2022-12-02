
public class Kafka 
{
	Customer customer =  new Customer();

	public void sendMessage(String message) 
	{
		if(!customer.sendMessage(message)) 
			System.out.println("Tüm threadlar dolu veri boşta kaldı : "+ message);
	}
	
	
	

}
