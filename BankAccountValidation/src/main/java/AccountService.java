public class AccountService {
	    public long deposit(BankAccount acc, long amount) {
	        acc.setBankBalance(acc.getBankBalance() + amount);
	        return acc.getBankBalance();
	    }
	    public long withdraw(BankAccount acc, long amount) {
	        if (acc.getBankBalance() >= amount) {
	            acc.setBankBalance(acc.getBankBalance() - amount);
	        }else {
	        	throw new IllegalArgumentException();
	        }
	        return acc.getBankBalance();
	    }
	    public boolean minimumBalance(BankAccount acc) {
	        return acc.getBankBalance() >= 1000;
	    }
}
