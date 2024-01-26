public class PostfixCalculator {
    private Stack<Integer> stack;
    private int size;

    public PostfixCalculator() {
        stack = new Stack<>();
        size = 0;
    }

    public int evaluate(String expression) {
        String[] characters = expression.split("\\s+");

        try {
            for (String character : characters) {
                if (character.matches("\\d+")) {
                    stack.push(Integer.parseInt(character));
                    size++;
                } else {
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();
                    int result;
                    switch (character) {
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
                            throw new IllegalArgumentException("Invalid operator: " + character);
                    }
                    stack.push(result);
                    size--;
                }
            }
            return stack.pop();
        } catch (Exception e) {
            throw new IllegalArgumentException("Exprecion invalida: " + e.getMessage());
        }
    }
}
