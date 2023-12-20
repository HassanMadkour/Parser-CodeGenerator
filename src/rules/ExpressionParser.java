package rules;

import main.Token;

class ExpressionParser {

    // Constructor

    public static boolean isValidExpression(boolean fore) {
        if (fore) {
            return match("=") && parseIdentifier() && parseArithmeticOperator() && parseNumber();
        } else {

            return match("=") && parseIdentifier() && parseArithmeticOperator() && parseNumber()
                    && match(";");
        }
    }

    private static boolean parseIdentifier() {
        String[] token = Token.getNextToken();
        if (token[1].matches("Identifier")) {
            return true;
        } else {
            System.out.println("Error: Expected an identifier but found " + token[0]);
            return false;
        }
    }

    private static boolean parseNumber() {
        String[] token = Token.getNextToken();
        if (token[1].matches("Numeric")) {
            return true;
        } else {
            System.out.println("Error: Expected a numeric value but found " + token[0]);
            return false;
        }

    }

    private static boolean parseArithmeticOperator() {
        String token = Token.getNextToken()[0];
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static boolean match(String expected) {
        String token = Token.getNextToken()[0];
        if (token.equals(expected)) {
            return true;
        } else {

            System.out.println("Error: Expected '" + expected + "' but found " +
                    (token.isEmpty() ? "end of input" : "'" + token + "'"));
            return false;
        }
    }
}
