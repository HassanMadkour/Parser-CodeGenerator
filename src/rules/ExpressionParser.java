package rules;

import main.*;

class ExpressionParser {

    // Constructor


    static String b;
    static String c;
   static String t;
    static String m;
    public static boolean isValidExpression(boolean fore) {
        Token.indexofToken--;
      m  =Token.getNextToken()[0];

        if (fore) {
            String []t= Token.getNextToken();
            if (parseNumber()){   Token.indexofToken--; Token.indexofToken--;
                String p="(MOV,"+c+","+m+")" ;
                Atom.atomList.add(p);
                return match("=") && parseNumber() ;}
            Token.indexofToken--; Token.indexofToken--;

            return match("=") && parseIdentifier() && parseArithmeticOperator() && parseNumber1();
        } else {
            String []t= Token.getNextToken();
            if (parseNumber()){   Token.indexofToken--; Token.indexofToken--;
                String p="(MOV,"+c+","+m+")" ;
                Atom.atomList.add(p);
                return match("=") && parseNumber() && match(";");}
            Token.indexofToken--; Token.indexofToken--;
            return match("=") && parseIdentifier() && parseArithmeticOperator() && parseNumber1()
                    && match(";");
        }
    }

    private static boolean parseIdentifier() {
        String[] token = Token.getNextToken();
        b=token[0];
        if (token[1].matches("Identifier")) {
            return true;
        } else {
            System.out.println("Error: Expected an identifier but found " + token[0]);
            return false;
        }
    }

    private static boolean parseNumber() {
        String[] token = Token.getNextToken();
        c=token[0];
        if (token[1].matches("Numeric")) {
            return true;
        } else {

            return false;
        }

    }
    private static boolean parseNumber1() {
        String[] token = Token.getNextToken();
        c=token[0];
        t=t+c+","+m+")";
        Atom.atomList.add(t);
        if (token[1].matches("Numeric")) {
            return true;
        } else {
            System.out.println("Error: Expected a numeric value but found " + token[0]);
            return false;
        }

    }


    private static boolean parseArithmeticOperator() {
        String token = Token.getNextToken()[0];
        if(token.equals("+")){t="(ADD,"+b+"," ;}
        if(token.equals("-")){t="(SUB,"+b+"," ;}
        if(token.equals("*")){t="(MUl,"+b+"," ;}
        if(token.equals("/")){t="(DEV,"+b+"," ;}

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
