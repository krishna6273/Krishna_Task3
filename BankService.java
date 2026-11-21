package ATM1;

import java.util.ArrayList;

public class BankService 
{
	private ArrayList<Account>accounts;
	private ArrayList<Transaction>transaction;
	
	//Constructor
	public BankService()
	{
		accounts = new ArrayList<>();
		transaction = new ArrayList<>();
		
		//Demo account 
		accounts.add(new Account("krishna123","1234","Krishna",10000));
		
		accounts.add(new Account("rahul123","5678","Rahul",5000));
	}
	
	//Find account using UserID
	public Account findAccount(String userId)
	{
		for(Account account:accounts)
		{
			if(account.getuserId().equals(userId))
			{
				return account;
			}
		}
		return null;
	}
	 
	//Deposit money
	 public boolean deposit(Account account, double amount) {

	        if (amount <= 0) {
	            System.out.println("Invalid amount!");
	            return false;
	        }

	        account.setBalance(account.getbalance() + amount);

	        transaction.add(new Transaction(
	            account.getuserId(),
	            "Deposit",
	            amount,
	            "Money deposited successfully"
	        ));

	        System.out.println("Deposit Successful!");
	        return true;
	    }

	    // Withdraw money
	    public boolean withdraw(Account account, double amount) {

	        if (amount <= 0) {
	            System.out.println("Invalid amount!");
	            return false;
	        }

	        if (amount > account.getbalance()) {
	            System.out.println("Insufficient Funds!");
	            return false;
	        }

	        account.setBalance(account.getbalance() - amount);

	        transaction.add(new Transaction(
	            account.getuserId(),
	            "Withdraw",
	            amount,
	            "Money withdrawn successfully"
	        ));

	        System.out.println("Withdrawal Successful!");
	        return true;
	    }

	    // Transfer money
	    public boolean transfer(Account sender,
	                            String receiverId,
	                            double amount) {

	        if (amount <= 0) {
	            System.out.println("Invalid amount!");
	            return false;
	        }

	        Account receiver = findAccount(receiverId);

	        if (receiver == null) {
	            System.out.println("Invalid recipient account!");
	            return false;
	        }

	        if (sender == receiver) {
	            System.out.println("Cannot transfer to same account!");
	            return false;
	        }

	        if (amount > sender.getbalance()) {
	            System.out.println("Insufficient Funds!");
	            return false;
	        }

	        sender.setBalance(sender.getbalance() - amount);

	        receiver.setBalance(receiver.getbalance() + amount);

	        transaction.add(new Transaction(
	            sender.getuserId(),
	            "Transfer Sent",
	            amount,
	            "Transferred to " + receiverId
	        ));

	        transaction.add(new Transaction(
	            receiver.getuserId(),
	            "Transfer Received",
	            amount,
	            "Received from " + sender.getuserId()
	        ));

	        System.out.println("Transfer Successful!");
	        return true;
	    }

	    // Check balance
	    public void checkBalance(Account account) {

	        System.out.println("Account Holder: "
	                + account.getholderName());

	        System.out.println("Available Balance: Rs. "
	                + account.getbalance());
	    }

	    // Transaction history
	    public void showHistory(Account account) {

	        boolean found = false;

	        System.out.println("\nTRANSACTION HISTORY");

	        for (Transaction transaction : transaction) {

	            if (transaction.getuserId().equals(account.getuserId())) {

	                transaction.displaytransaction();
	                found = true;
	            }
	        }

	        if (!found) {
	            System.out.println("No transactions found.");
	        }
	    }
	}

