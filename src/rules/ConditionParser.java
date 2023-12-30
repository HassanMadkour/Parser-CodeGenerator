package rules;
import java.util.ArrayList;
import java.util.List;

import main.Token;
import main.Atom;

class ConditionParser {

     static String numbersin;
    static String a;
    static String b;




    public static boolean isCondition() {
        if(parseIdentifier() && parseConditionalExpression() && parseNumber())
        { String t="(TST,"+a+","+b+","+numbersin+","+Atom.getNextLabel()+")"  ;
            Atom.atomList.add(t);

            return true;
        }




        return false;
    }

    private static boolean parseIdentifier() {
        String token[] = Token.getNextToken();
          a=token[0];
        if (token[1].matches("Identifier")) {

            return true;

        }
         else {
            System.out.println("Error:sa56as Expected an identifier but found " + Token.getNextToken()[0]);
            return false;
        }}

    private static boolean parseNumber() {
        String token[] = Token.getNextToken();
        b=token[0];

        if (token[1].matches("Numeric")) {


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
