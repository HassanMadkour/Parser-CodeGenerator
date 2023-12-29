package rules;

import main.*;

class ExpressionParser {

    // Constructor

    public static boolean isValidExpression(boolean fore) {
        Atom.atomList.add("(");
        Atom.atomList.add("MOV");
        Atom.atomList.add(",");
        Token.indexofToken--;
        String token =Token.getNextToken()[0];
        Atom.atomList.add(token);
        Atom.atomList.add(",");
        if (fore) {
            String []t= Token.getNextToken();
            if (parseNumber()){   Token.indexofToken--; Token.indexofToken--;
                return match("=") && parseNumber1() ;}
            Token.indexofToken--; Token.indexofToken--;
            return match("=") && parseIdentifier() && parseArithmeticOperator() && parseNumber();
        } else {
            String []t= Token.getNextToken();
            if (parseNumber()){   Token.indexofToken--; Token.indexofToken--;
                return match("=") && parseNumber1() && match(";");}
            Token.indexofToken--; Token.indexofToken--;
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
    private static boolean parseNumber1() {
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
