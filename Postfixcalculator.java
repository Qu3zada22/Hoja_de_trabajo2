public class PostfixCalculator {
    private Stack<Integer> stack;

    public PostfixCalculator() {
        stack = new Stack<>();
    }

    public int evaluate(String expression) {
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result;
                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
                stack.push(result);
            }
        }

        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return stack.pop();
    }
}
