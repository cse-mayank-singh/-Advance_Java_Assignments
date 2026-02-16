public class BankAccount {
	private long accountNumber;
	private String holderName;
	private long bankBalance;
	public BankAccount(long accountNumber, String holderName, long bankBalance) {
		super();
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.bankBalance = bankBalance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public long getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(long bankBalance) {
		this.bankBalance = bankBalance;
	}
}