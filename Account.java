package ATM1;

public class Account 
{	
	//Account Details
	private String userId;
	private String pin;
	private String holderName;
	private double balance; 
	
	//Constructor
	public Account(String userId, String pin, String holderName, double balance) 
	{
		this.userId = userId;
		this.pin = pin;
		this.holderName = holderName;
		this.balance = balance;
	}
	
	//Getter
	public String getuserId() 
	{
		return userId;
	}
	public String getpin()
	{
		return pin;
	}
	public String getholderName()
	{
		return holderName;
	}
	public double getbalance()
	{
		return balance;
	}
	//pin verification
	public boolean verifyPin(String EnterdPin) 
	{
		return this.pin.equals(EnterdPin);
	}
	//Update balance
	public void setBalance(double balance)
	{
		this.balance=balance;
	}

}
