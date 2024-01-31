import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PostfixCalculatorTest {

    @Test
    void testEvaluateValidExpression() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertTrue(calculator.evaluate("2 3 +"));
        assertEquals(5, calculator.returnResult());
    }

    @Test
    void testEvaluateInvalidExpression() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertFalse(calculator.evaluate("2 +"));
        assertFalse(calculator.evaluate("2 3 + +"));
        assertFalse(calculator.evaluate("2 0 /"));
    }

    @Test
    void testEvaluateDivisionByZero() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertFalse(calculator.evaluate("4 0 /"));
    }

    @Test
    void testEvaluateInvalidSyntax() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertFalse(calculator.evaluate("2 3a +"));
    }

    @Test
    void testReturnResultWithEmptyStack() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.returnResult());
    }

    @Test
    void testEvaluateAndReturnResultComplexExpression() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertTrue(calculator.evaluate("2 3 + 4 *"));
        assertEquals(20, calculator.returnResult());
    }

    @Test
    void testEvaluateAndReturnResultInvalidOperator() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertFalse(calculator.evaluate("2 3 $"));
    }

    @Test
    void testEvaluateAndReturnResultEmptyExpression() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertFalse(calculator.evaluate(""));
    }
}
