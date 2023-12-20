package rules;

import main.Token;

class ConditionParser {

    public static boolean isCondition() {

        return parseIdentifier() && parseConditionalExpression() && parseNumber();
    }

    private static boolean parseIdentifier() {
        String token = Token.getNextToken()[1];
        if (token.matches("Identifier")) {
            return true;
        } else {
            System.out.println("Error: Expected an identifier but found " + Token.getNextToken()[0]);
            return false;
        }
    }

    private static boolean parseNumber() {
        String token = Token.getNextToken()[1];
        if (token.matches("Numeric")) {
            return true;
        } else {
            System.out.println("Error: Expected a numeric value but found " + Token.getNextToken()[0]);
            return false;
        }

    }

    private static boolean parseConditionalExpression() {
        String token = nextToken();
        return token.equals("==") || token.equals("<") || token.equals(">") || token.equals("!=");
    }

    private static boolean match(String expected) {
        String token = token.getnextToken()[0];
        if (token.equals(expected)) {
            return true;
        } else {
            if (expected.equals("==") || expected.equals("<") || expected.equals(">"))
                token.index--;
            else if (expected.equals("=")) {
                return false;
            } else {
                // Check if it's the end of input
                if (token.isEmpty()) {
                    System.out.println("Error: Expected '" + expected + "' but found end of input");
                } else {
                    System.out.println("Error: Expected '" + expected + "' but found '" + token + "'");
                }
                return false;
            }
        }
        return false;
    }

}
