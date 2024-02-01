import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PostfixCalculatorTest {

    @Test
    void testEvaluateValidExpression() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertEquals(5, calculator.calcular("2 3 +"));
    }

    void testEvaluateInvalidExpression() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calcular("2 +"));
        assertThrows(IllegalArgumentException.class, () -> calculator.calcular("2 3 + +"));
        assertThrows(IllegalArgumentException.class, () -> calculator.calcular("2 0 /"));
    }

    @Test
    void testEvaluateDivisionByZero() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calcular("4 0 /"));
    }

    @Test
    void testEvaluateInvalidSyntax() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calcular("2 3a +"));
    }

    @Test
    void testEvaluateAndReturnResultInvalidOperator() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calcular("2 3 $"));
    }

    @Test
    void testEvaluateAndReturnResultEmptyExpression() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calcular(""));
    }
}
