package ATM1;

public class ATMInterface 
{
	public static void main(String[] args) 
	{
		System.out.println("*******************************");
		System.out.println("-------WELCOME TO ATM----------");
		System.out.println("*******************************");
		
		ATM atm = new ATM();
		
		//User Login
		Account account = atm.login();
		
		//Open ATM menu after successful login
		if(account != null)
		{
			atm.showMenu(account);
		}else {
			System.err.println("THANK YOU!");
			System.out.println("Please try again later");
		}
	}
}
