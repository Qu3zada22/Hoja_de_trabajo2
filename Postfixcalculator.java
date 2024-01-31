import java.util.Stack;

public class PostfixCalculator {
    private Stack<Integer> stack;
    private int size;

    public PostfixCalculator() {
        stack = new Stack<>();
        size = 0;
    }

    public Boolean evaluate(String expression) {
        String[] characters = expression.split("\\s+");

        try {
            for (String character : characters) {
                if (character.matches("\\d+")) {
                    stack.push(Integer.parseInt(character));
                    size++;
                } else if (isOperator(character)) {
                    if (size < 2) {
                        throw new IllegalArgumentException("Not enough operands for operator: " + character);
                    }
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
                                System.out.println("Error, división por cero en la expresión: " + expression);
                                return false;
                            }
                            result = operand1 / operand2;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid operator: " + character);
                    }
                    stack.push(result);
                    size--;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Error, la sintaxis de la operación es incorrecta en la expresión: " + expression);
            return false;
        }
        if (size == 1) {
            return true;
        } else {
            System.out.println("Error, la sintaxis de la operación es incorrecta");
            return false;
        }
    }

    public int returnResult() {
        if (stack.isEmpty() || size != 1) {
            throw new IllegalArgumentException("Error, la sintaxis de la operación es incorrecta");
        }
        return stack.pop();
    }

    private boolean isOperator(String character) {
        return character.equals("+") || character.equals("-") || character.equals("*") || character.equals("/");
    }
}
