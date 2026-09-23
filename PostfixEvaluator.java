import java.util.Scanner;

/**
 * C-6.19 / P-6.35  Evaluating Postfix Expressions
 *
 * In postfix notation, each operator comes AFTER its two operands.
 *   Infix:   ((5 + 2) * (8 - 3)) / 4
 *   Postfix: 5 2 + 8 3 - * 4 /
 *
 * Your program reads a postfix expression (tokens separated by spaces)
 * and prints its value. Use the Stack interface and LinkedStack class
 * from this repository (EX6_01 and EX6_04). Do NOT use recursion.
 *
 * ---------------------------------------------------------------
 * C-6.19  Written answer: describe your non-recursive algorithm.
 * Write it in your own words BEFORE you start coding.
 *
 *   1.
 *   2.
 *   3.
 *   ...
 * ---------------------------------------------------------------
 */
public class PostfixEvaluator {

    /**
     * Evaluates a postfix expression and returns its value.
     *
     * @param expression  tokens separated by spaces, e.g. "5 2 + 8 3 - * 4 /"
     * @return the value of the expression
     * @throws IllegalArgumentException if the expression is not valid postfix
     */
    public static double evaluate(String expression) {
        Stack<Double> stack = new LinkedStack<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                // TODO: An operator needs two operands.
                //       - Make sure the stack has at least two values
                //         (otherwise throw an IllegalArgumentException).
                //       - Pop the two operands. Be careful about the ORDER:
                //         which one is the left operand and which is the right?
                //       - Use applyOperator(...) and push the result.

            } else {
                // TODO: The token should be a number.
                //       Convert it with Double.parseDouble(token) and push it.
                //       (What should happen if the token is not a number?)

            }
        }

        // TODO: When all tokens are processed, exactly one value should be
        //       left on the stack. If not, throw an IllegalArgumentException.
        //       Otherwise, pop and return it.

        return 0.0;   // placeholder so the starter code compiles; replace this
    }

    /**
     * Returns true if the token is one of the four operators + - * /
     */
    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
            || token.equals("*") || token.equals("/");
    }

    /**
     * Applies the operator to the two operands: left op right.
     *
     * @param left   the first (left) operand
     * @param right  the second (right) operand
     * @param op     one of "+", "-", "*", "/"
     * @return the result of left op right
     */
    public static double applyOperator(double left, double right, String op) {
        switch (op) {
            case "+": return left + right;
            // TODO: add the cases for "-", "*", and "/"
            //       (What should happen if right is 0 for "/"?)

            default:  throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    /** Runs the book example, then evaluates expressions typed by the user. */
    public static void main(String[] args) {
        // Book example from C-6.19. Expected value: 8.75
        String example = "5 2 + 8 3 - * 4 /";
        System.out.println(example + "  =  " + evaluate(example));

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a postfix expression (blank line to quit):");
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isBlank()) break;
            try {
                System.out.println("Value: " + evaluate(line));
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Invalid expression: " + e.getMessage());
            }
            System.out.println("Enter a postfix expression (blank line to quit):");
        }
    }
}
