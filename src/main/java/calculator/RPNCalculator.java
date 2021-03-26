package calculator;

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class RPNCalculator {

	public int calculate(String[] tokens) {
		Map<String, BiFunction<Integer, Integer, Integer>> ops = Map.of(
				"+", (v1,v2) -> v2 + v1,
				"-", (v1,v2) -> v2 - v1,
				"/", (v1,v2) -> v2 / v1,
				"*", (v1,v2) -> v2 * v1 );

		Stack<Integer> operands = new Stack<>();
		for (String value : tokens) {
			operands.push(ops.containsKey(value) ? ops.get(value).apply(operands.pop(),operands.pop()) : Integer.parseInt(value)); 
		}
		return operands.isEmpty() ? 0 : operands.pop();
	}
}
