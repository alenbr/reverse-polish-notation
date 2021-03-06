package calculator;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

import org.junit.Test;
public class RPNCalculatorTest {
	@Test
	public void testCorrectStrings() {
		RPNCalculator rpnCalc = new RPNCalculator();
		assertEquals("The should be 9",9,rpnCalc.calculate(new String[]{"2", "1", "+", "3", "*"}));
		assertEquals("The should be 6",6,rpnCalc.calculate(new String[]{"4", "13", "5", "/", "+"}));
		assertEquals("The should be 22",22,rpnCalc.calculate(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}
	@Test
	public void testSingleValue() {
		RPNCalculator rpnCalc = new RPNCalculator();
		assertEquals("The should be 123",123,rpnCalc.calculate(new String[]{"123"}));
	}
	@Test(expected=EmptyStackException.class)
	public void testOnlyOperation() {
		RPNCalculator rpnCalc = new RPNCalculator();
		assertEquals("The should be 0",0,rpnCalc.calculate(new String[]{"+"}));
	}
	@Test
	public void testWithoutOperation() {
		RPNCalculator rpnCalc = new RPNCalculator();
		assertEquals("The should be 0",0,rpnCalc.calculate(new String[]{"1","2","3"}));
	}
}
