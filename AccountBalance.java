
public class AccountBalance {

	public int processTransactions(int startingBalance, String[] transactions) {
		int balance = startingBalance;
		char operation;
		int amount;

		for (int i = 0; i < transactions.length; i++) {
			operation = transactions[i].charAt(0);
			amount = Integer.parseInt(transactions[i].substring(2, transactions[i].length()));

			if (operation == 'C') {
				balance += amount;
			}
			if (operation == 'D') {
				balance -= amount;
			}
		}

		return balance;
	}

	public static void main(String[] args) {
		AccountBalance ab = new AccountBalance();
		int startingBalance = 100;
		String[] transactions = { "C 1000", "D 500", "D 350" };
		System.out.println(ab.processTransactions(startingBalance, transactions));
	}

}
