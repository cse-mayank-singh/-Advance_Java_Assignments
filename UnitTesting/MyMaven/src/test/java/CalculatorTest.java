import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
public class CalculatorTest {
	private Calculator calculator;
	@BeforeEach
	void setup() {
		calculator=new Calculator();
	}
	@Test
	@DisplayName("Test sum of two positive numbers")
	public void test() {
		assertEquals(5,calculator.add(3, 2));
	}
	@Test
	public void test1() {
		assertEquals(12,calculator.add(6, 6));
	}
	@DisplayName("Test sum of two positive numbers")
	@Test
	public void test2() {
		assertEquals(7,calculator.add(6, 1));
	}
	@RepeatedTest(3)
	@DisplayName("Test sum of repeated execution")
	void testsumRepeated() {
		assertEquals(10,calculator.add(5,5),"Sum for 10");
	}
	@Nested
	@DisplayName("Subtraction Tests")
	class SubtractionTests{
		@Test
		@DisplayName("Test subtraction of two numbers")
		void testSubtraction() {
			assertEquals(1,calculator.sub(5,4));
		}
		@Test
		@DisplayName("Test subtraction of two numbers")
		void testSubtraction2() {
			assertEquals(1,calculator.sub(5,4));
		}
	}
	@ParameterizedTest
	@ValueSource(ints= {1,2,3,4,5})
	@DisplayName("Multiplication by 2")
	void testmultiplications(int a) {
		assertEquals(a*2,calculator.multiply(a,2)); 
	}
	@ParameterizedTest
	@CsvSource({
	    "1,2,3",
	    "2,3,5",
	    "5,5,10"
	})
	void testAdd(int a, int b, int result) {
	    assertEquals(result, calculator.add(a, b));
	}
}














