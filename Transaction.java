package ATM1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction 
{
	private String userId;
	private	String type;
	private	double amount;
	private	String details;
	private	LocalDateTime dateTime;
	

	//constructor
	public Transaction (String userId, String type, double amount, String details)
	{
		this.userId= userId;
		this.type= type;
		this.amount= amount;
		this.details= details;
		this.dateTime= LocalDateTime.now();
	}
	public String getuserId() 
	{
		return userId;
	}
	//Display transaction details
	public void displaytransaction()
	{
		System.out.println("********************************");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm:ss");
		System.out.println("Date: "+dateTime.format(formatter));
		System.out.println("Type: "+type);
		System.out.println("Amount: RS."+amount);
		System.out.println("Details: "+details);
		
		System.out.println("********************************");
	}
	}
	
