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
        String token = Token.getNextToken()[0]
        return token.equals("==") || token.equals("<") || token.equals(">") || token.equals("!=");
    }

    

}
