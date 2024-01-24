public class PostfixCalculator {
    private VectorStack<Integer> stack;

    public PostfixCalculator() {
        stack = new VectorStack<>();
    }

    public int evaluateExpression(String postfixExpression) {
        String[] tokens = postfixExpression.split("\\s+");
        
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operandB = stack.pop();
                int operandA = stack.pop();
                int result = performOperation(operandA, operandB, token);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    private int performOperation(int operandA, int operandB, String operator) {
        switch (operator) {
            case "+":
                return operandA + operandB;
            case "-":
                return operandA - operandB;
            case "*":
                return operandA * operandB;
            case "/":
                if (operandB == 0) {
                    throw new ArithmeticException("División entre cero");
                }
                return operandA / operandB;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operator);
        }
    }
}
