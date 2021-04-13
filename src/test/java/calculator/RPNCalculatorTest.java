package calculator;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class RPNCalculatorTest {

	@Test
	@DisplayName("Test with a simple plan group of values")
	public void testWithPlanGroupOfValues() {
		RPNCalculator rpnCalc = new RPNCalculator();
		Assertions.assertEquals(9,rpnCalc.calculate(new String[]{"2", "1", "+", "3", "*"}),"The value should be 9");
	}
	@Test
	@DisplayName("Test with more than 2 values sequenced and operations after that")
	public void testWithMoreThanTwoValuesSequence() {
		RPNCalculator rpnCalc = new RPNCalculator();
		Assertions.assertEquals(6,rpnCalc.calculate(new String[]{"4", "13", "5", "/", "+"}),"The value should be 6");
	}
	@Test
	@DisplayName("Test with a large sequence of values with large sequence of Operations")
	public void testWithMoreThanTwoValuesAndOperationsSequenced() {
		RPNCalculator rpnCalc = new RPNCalculator();
		Assertions.assertEquals(22,rpnCalc.calculate(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}),"The value should be 22");
	}
	@Test
	@DisplayName("Test array with a single value without any operation")
	public void testSingleValueWithoutOperation() {
		RPNCalculator rpnCalc = new RPNCalculator();
		Assertions.assertEquals(123,rpnCalc.calculate(new String[]{"123"}),"The value should be 123");
	}
	@Test
	@DisplayName("Test array with only operation and no values expecting excepton")
	public void testOnlyOperationException() {
		RPNCalculator rpnCalc = new RPNCalculator();
		Assertions.assertThrows(EmptyStackException.class,() -> rpnCalc.calculate(new String[]{"+"}),"The value should be 0");
	}
}
