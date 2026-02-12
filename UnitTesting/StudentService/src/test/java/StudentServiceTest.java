import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class StudentServiceTest {
	private StudentService ss;
	@BeforeEach
	public void setup() {
		ss=new StudentService();
	}
	@Test
	@DisplayName("Failed Test")
	public void test1() {
		Student s1=new Student("Shinchan",20,20,30);
		assertEquals(false, ss.isPassed(s1));
	}
	@Test
	@DisplayName("Passed Test")
	public void test2() {
		Student s2=new Student("Shinchan",100,90,30);
		assertEquals(true, ss.isPassed(s2));
	}
}
