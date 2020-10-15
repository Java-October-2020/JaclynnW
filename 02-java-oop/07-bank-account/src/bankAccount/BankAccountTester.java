package bankAccount;

public class BankAccountTester {

	public static void main(String[] args) {
		BankAccount cust1 = new BankAccount();
		BankAccount cust2 = new BankAccount();
		
		
		cust1.checkingDeposit(200);
		cust1.checkingDeposit(2.25);
		cust1.savingDeposit(5);
		
		cust2.checkingWithdrawal(15);
		cust1.totalBalance();

	}

}
