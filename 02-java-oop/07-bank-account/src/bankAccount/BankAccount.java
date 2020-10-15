package bankAccount;

import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int numOfAccounts = 0;
	
	public BankAccount() {
		numOfAccounts++;
		this.accountNumber = createAccount();
		System.out.println("New account number created. New account # is " + this.accountNumber);
		System.out.println("Total accounts created " + numOfAccounts);
		
	}
	public void totalBalance() {
		double totalBalance = this.checkingBalance + this.savingsBalance;
		System.out.println("Your total balance in the bank is $" + totalBalance);

	}
	public void checkingDeposit(double money) {
		this.checkingBalance += money;
		System.out.println("Checking deposit received; balance is now " + this.checkingBalance);
	}
	
	public void savingDeposit(double money) {
		this.savingsBalance += money;
		System.out.println("Savings deposit received; balance is now " + this.savingsBalance);
	}
	public void checkingWithdrawal(double money) {
		if(0 > this.checkingBalance - money) {
			System.out.println("Denied! Get a job loser! You are going to overdraft");
			System.out.println("Your checking balance is " + this.checkingBalance);
		}
		else {
			this.checkingBalance -= money;
			System.out.println("Don't spend all that money in one place! Checking balance is now " + this.checkingBalance);
		}

	}
	public void savingsWithdrawal(double money) {
		if( 0 > this.savingsBalance - money) {
			System.out.println("You need to re evaluate your life.. you don't have that kind of money here");
			System.out.println("Your savings balance is " + this.savingsBalance);
		}
		else {
			this.savingsBalance -= money;
			System.out.println("Savings are meant for saving! You are going in the wrong direction! Savings balance is now " + this.savingsBalance);
		}

	}
	
	
	private String createAccount() {
		Random rAccount = new Random();
		char [] digits = new char[10];
		digits[0] = (char) (rAccount.nextInt(9) + '1');
		for(int i = 1; i <digits.length; i++) {
			digits[i] = (char) (rAccount.nextInt(10) + '0');
		}
		long nAcct = Long.parseLong(new String(digits));
		String newAccount = String.valueOf(nAcct);
		return newAccount;
		
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	public static int getNumOfAccounts() {
		return numOfAccounts;
	}
	public static void setNumOfAccounts(int numOfAccounts) {
		BankAccount.numOfAccounts = numOfAccounts;
	}

}
