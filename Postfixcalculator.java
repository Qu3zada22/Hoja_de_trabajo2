import java.util.Stack;

/**
 * Clase que realiza el cálculo de expresiones en formato postfix.
 * 
 * @author Jonathan Díaz
 * @author Anggie Quezada
 */
public class PostfixCalculator implements CalculadoraPOSTFIX {
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
     * @return El resultado
     */
    @Override
    public int calcular(String notacion) {
        String[] characters = notacion.split("\\s+");

        try {
            for (String character : characters) {
                if (character.matches("\\d+")) {
                    stack.push(Integer.parseInt(character));
                    size++;
                } else if (isOperator(character)) {
                    if (size < 2) {
                        throw new IllegalArgumentException("Error, la sintaxis de la operación es incorrecta");
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
                                throw new IllegalArgumentException("Error, la sintaxis de la operación es incorrecta");
                            }
                            result = operand1 / operand2;
                            break;
                        default:
                            throw new IllegalArgumentException("Operador invalido: " + character);
                    }
                    stack.push(result);
                    size--;
                } else {
                    throw new IllegalArgumentException("Error, la sintaxis de la operación es incorrecta");
                }
            }
            if (stack.isEmpty() || size != 1) {
                throw new IllegalArgumentException("Error, la sintaxis de la operación es incorrecta");
            } else {
                return stack.pop();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error, la sintaxis de la operación es incorrecta");
        }
    }

    private boolean isOperator(String character) {
        return character.equals("+") || character.equals("-") || character.equals("*") || character.equals("/");
    }
}
