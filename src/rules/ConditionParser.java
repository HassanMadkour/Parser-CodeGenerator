package rules;
import java.util.ArrayList;
import java.util.List;

import main.Token;
import main.Atom;

class ConditionParser {

     static String numbersin;



    public static boolean isCondition() {
       Atom.atomList.add("(");
        Atom.atomList.add("TEST");
        Atom.atomList.add(",");




        return parseIdentifier() && parseConditionalExpression() && parseNumber();
    }

    private static boolean parseIdentifier() {
        String token[] = Token.getNextToken();

        if (token[1].matches("Identifier")) {
            Atom.atomList.add(token[0]);
            Atom.atomList.add(",");

            return true;

        }
         else {
            System.out.println("Error:sa56as Expected an identifier but found " + Token.getNextToken()[0]);
            return false;
        }}

    private static boolean parseNumber() {
        String token[] = Token.getNextToken();

        if (token[1].matches("Numeric")) {
            Atom.atomList.add(token[0]);
            Atom.atomList.add(",");
            Atom.atomList.add(numbersin);
            Atom.atomList.add(",");
            Atom.atomList.add(Atom.getNextLabel());
            Atom.atomList.add(")");

            return true;
        } else {
            System.out.println("Error: Expected a numeric value but found " + Token.getNextToken()[0]);
            return false;
        }

    }

    private static boolean parseConditionalExpression() {
       String token;
        token = Token.getNextToken()[0];
        if(token.equals("=="))
            numbersin= "3";
        if(token.equals(">"))
            numbersin= "4";
        if(token.equals("<"))
            numbersin= "5";
        if(token.equals("!="))
            numbersin= "6";

        return token.equals("==") || token.equals("<") || token.equals(">") || token.equals("!=");
    }

}
