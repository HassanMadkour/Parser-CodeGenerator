package rules;

import main.*;

class VariableDefinitionParser {

    public static boolean isValidVariableDefinition() {
        Atom.atomList.add("(");
        Atom.atomList.add("MOV");
        Atom.atomList.add(",");



        return parseIdentifier() && parseInitialization() && match(";");
    }

    private static boolean parseIdentifier() {
        String[] token = Token.getNextToken();
        if (token[1].matches("Identifier")) {
            Atom.atomList.add(token[0]);
            Atom.atomList.add(",");


            return true;
        } else {
            System.out.println("Error:22222 Expected an identifier but found " + token[0]);
            return false;
        }
    }

    private static boolean parseInitialization() {
        String token = Token.getNextToken()[0];
        if (token.equals("=")) {
            return parseExpression();
        }

        return true; // No initialization is also valid
    }

    private static boolean parseExpression() {
        return parseNumber();
    }

    private static boolean parseNumber() {
        String[] token = Token.getNextToken();
        if (token[1].matches("Numeric")) {
            Atom.atomList.add(token[0]);
            Atom.atomList.add(")");


            return true;
        } else {
            System.out.println("Error: Expected a numeric value but found " + token[0]);
            return false;
        }

    }

    private static boolean match(String expected) {
        String token = Token.getNextToken()[0];
        if (token.equals(expected)) {
            return true;
        } else {
            // Check if it's the end of input
            if (token.isEmpty()) {
                System.out.println("Error:5555555 Expected '" + expected + "' but found end of input");
            } else {
                System.out.println("Error:4444445 Expected '" + expected + "' but found '" + token + "'");
            }
            return false;
        }

    }

}
