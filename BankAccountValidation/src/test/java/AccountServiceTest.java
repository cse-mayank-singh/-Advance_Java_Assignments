import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class AccountServiceTest {
	private AccountService acc;
	@BeforeEach
	public void setup() {
		acc=new AccountService();
	}
	@Test
	@DisplayName("Withdraw")
	public void test1() {
		BankAccount s1=new BankAccount(1234566780l,"Shinchan",5000);
		assertEquals(s1.getBankBalance()-500, acc.withdraw(s1,500));
	}
	@Test
	@DisplayName("Deposit")
	public void test2() {
		BankAccount s1=new BankAccount(1234566780l,"Shinchan",5000);
		assertEquals(s1.getBankBalance()+500, acc.deposit(s1,500));
	}
	@Test
	@DisplayName("Minimum Bank Balance")
	public void test3() {
		BankAccount s1=new BankAccount(1234566780l,"Shinchan",5000);
		assertEquals(true,acc.minimumBalance(s1));
	}
}
