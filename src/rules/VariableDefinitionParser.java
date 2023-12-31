package rules;

import main.*;

class VariableDefinitionParser {
    static String a,b;

    public static boolean isValidVariableDefinition() {
        if( parseIdentifier() && parseInitialization() && match(";"))
        {  String r="(MOV,"+b+","+a+")";
            Atom.atomList.add(r);


            return true ;
        }
        return false;
    }

    private static boolean parseIdentifier() {
        String[] token = Token.getNextToken();
        a=token[0];
        if (token[1].matches("Identifier")) {


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
        b=token[0];
        if (token[1].matches("Numeric")) {


            return true;
        } else {
            System.out.println("Error:1111111111111 Expected a numeric value but found " + token[0]);
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
