import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//Lifecycle @BeforeAll @BeforeEach @Test @AfterEach @AfterAll
public class ValidatorTest {
	private Validator val;
	@BeforeEach
	void setup() {
		val=new Validator();
	}
	@Test
	@DisplayName("A valid username")
	public void test1() {
		assertEquals(true,val.isUsernameValid("Mayank19"));
	}
	@Test
	@DisplayName("Username with special characters")
	public void test2() {
		assertEquals(false,val.isUsernameValid("M@Y@N@12"));
	}
	@Test
	@DisplayName("Username shorter than the minimum length")
	public void test3() {
		assertEquals(false,val.isUsernameValid("M1@"));
	}
	@Test
	@DisplayName("Empty username")
	public void test4() {
		assertEquals(false,val.isUsernameValid(""));
	}
	@Test
	@DisplayName("Null username")
	public void test5() {
		assertEquals(false,val.isUsernameValid(null));
	}
	
	@Test
	@DisplayName("A valid Password")
	public void test6() {
		assertEquals(true,val.isPasswordValid("Mayank@19"));
	}
	@Test
	@DisplayName("Password with special characters")
	public void test7() {
		assertEquals(false,val.isPasswordValid("MAYYYN12"));
	}
	@Test
	@DisplayName("Password shorter than the minimum length")
	public void test8() {
		assertEquals(false,val.isPasswordValid("M1@"));
	}
	@Test
	@DisplayName("Empty Password")
	public void test9() {
		assertEquals(false,val.isPasswordValid(""));
	}
	@Test
	@DisplayName("Null Password")
	public void test10() {
		assertEquals(false,val.isPasswordValid(null));
	}
	@Test
	@DisplayName("IS LOGIN SUCCESSFUL")
	public void test11() {
		assertEquals(true,val.isLoginValid("Mayank19","Mayank@19"));
	}
}