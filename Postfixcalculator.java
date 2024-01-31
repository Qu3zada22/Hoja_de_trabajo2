import java.util.Stack;

/**
 * Clase que realiza el cálculo de expresiones en formato postfix.
 * 
 * @author Jonathan Díaz
 * @author Anggie Quezada
 */
public class PostfixCalculator {
    private Stack<Integer> stack;
    private int size;

    /**
     * Constructor de la calculadora postfix.
     */
    public PostfixCalculator() {
        stack = new Stack<>();
        size = 0;
    }

    /**
     * Evalúa una expresión postfix y realiza el cálculo.
     * 
     * @param expression Expresión postfix a evaluar.
     * @return True si la expresión es válida y se calcula correctamente, false en
     *         caso contrario.
     */
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

    /**
     * Obtiene el resultado del cálculo de la expresión postfix.
     * 
     * @return Resultado del cálculo.
     * @throws IllegalArgumentException Si la sintaxis de la operación es
     *                                  incorrecta.
     */
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
