package ATM1;

import java.util.Scanner;

public class ATM 
{
	   private BankService bankService;
	    private Scanner sc;

	    // Constructor
	    public ATM() {
	        bankService = new BankService();
	        sc = new Scanner(System.in);
	    }

	    // Login method
	    public Account login() {

	        int attempts = 0;

	        while (attempts < 3) {

	            System.out.println("\n********** ATM LOGIN **********");

	            System.out.print("Enter User ID: ");
	            String userId = sc.nextLine();

	            System.out.print("Enter PIN: ");
	            String pin = sc.nextLine();

	            Account account = bankService.findAccount(userId);

	            if (account != null && account.getpin().equals(pin)) {

	                System.out.println("\nLogin Successful!");
	                System.out.println("Welcome, "
	                        + account.getholderName());

	                return account;
	            }

	            attempts++;

	            System.out.println("Invalid User ID or PIN!");

	            System.out.println("Attempts remaining: "
	                    + (3 - attempts));
	        }

	        System.out.println("\nAccount Access Denied!");
	        return null;
	    }

	    // ATM Menu
	    public void showMenu(Account account) {

	        int choice;

	        do {

	            System.out.println("\n*********** ATM MENU ***********");
	            System.out.println("1. Transaction History");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Deposit");
	            System.out.println("4. Transfer");
	            System.out.println("5. Check Balance");
	            System.out.println("6. Quit");

	            System.out.print("Enter your choice: ");

	            try {
	                choice = Integer.parseInt(sc.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Please enter a valid number!");
	                choice = 0;
	                continue;
	            }

	            switch (choice) {

	                case 1:
	                    bankService.showHistory(account);
	                    break;

	                case 2:
	                    System.out.print("Enter withdrawal amount: ");
	                    double withdrawAmount = Double.parseDouble(sc.nextLine());

	                    bankService.withdraw(account, withdrawAmount);
	                    break;

	                case 3:
	                    System.out.print("Enter deposit amount: ");
	                    double depositAmount = Double.parseDouble(sc.nextLine());

	                    bankService.deposit(account, depositAmount);
	                    break;

	                case 4:
	                    System.out.print("Enter receiver User ID: ");
	                    String receiverId = sc.nextLine();

	                    System.out.print("Enter transfer amount: ");
	                    double transferAmount = Double.parseDouble(sc.nextLine());

	                    bankService.transfer(account, receiverId, transferAmount);
	                    break;

	                case 5:
	                    bankService.checkBalance(account);
	                    break;

	                case 6:
	                    System.out.println("Thank you for using ATM!");
	                    break;

	                default:
	                    System.out.println("Invalid choice!");
	            }

	        } while (choice != 6);
	    }
	}

