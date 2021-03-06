package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class RPNCalculator {

	public int calculate(String[] tokens) {
		Stack<Integer> operands = new Stack<>();
		for (String value : tokens) {
			if ("+-/*".contains(value))
				operands.push( oper(value).apply(operands.pop(),operands.pop()));
			else 
				operands.push(Integer.parseInt(value));
		}
		return operands.isEmpty() ? 0 : operands.pop();
	}
	private static BiFunction<Integer, Integer, Integer> oper(String op) {
		Map<String, BiFunction<Integer, Integer, Integer>> ops = new HashMap<>();
		ops.put("+", (v1,v2) -> v2 + v1);
		ops.put("-", (v1,v2) -> v2 - v1);
		ops.put("/", (v1,v2) -> v2 / v1);
		ops.put("*", (v1,v2) -> v2 * v1);
		return ops.get(op);
	}

	
}
