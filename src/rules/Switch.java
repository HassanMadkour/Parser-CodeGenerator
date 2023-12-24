package rules;

import main.Token;

public class Switch {

    public static boolean switchStatment() {
        int i = 0;
        // Check (
        if (!Token.getNextToken()[0].equals("(")) {
            System.out.println("Error: Expected ( after Switch");
            return false;
        }
        // Check Condition
        if (!Token.getNextToken()[1].equals("Identifier")) {
            System.out.println("Error: Identifier Expected");
            return false;
        }
        // Check )
        if (!Token.getNextToken()[0].equals(")")) {
            System.out.println("Error: Expected ) after Condition");
            return false;
        }
        // Check {
        if (!Token.getNextToken()[0].equals("{")) {
            System.out.println("Error: Expected { after the Condition");
            return false;
        }
        // Check Cases
        do {
            i++;
            if (i == 1) {
                if (!Token.getNextToken()[0].equals("case")) {
                    System.out.println("Error: Expected 'case 1'");
                    return false;
                }
            }
            // Check "case"

            // Check num after case
            // Assume after case must be Numeric
            if (!Token.getNextToken()[1].equals("Numeric")) {
                System.out.println("Error: Expected Numeric value after the Case");
                return false;
            }
            // Check :
            if (!Token.getNextToken()[0].equals(":")) {
                System.out.println("Error: Expected : after the case");
                return false;
            }
            // Check Statement
            // Assume the statement is just 1
            Statment.statment(Token.getNextToken());
            if (!Statment.vaildation()) {
                System.out.println("Error: Expected Statement inside the case condition ");
                return false;
            }
            // Check break
            // Assume the statement must be followed by break;
            if (!Token.getNextToken()[0].equals("break")) {
                System.out.println("Error: Expected 'break' after the statement");
                return false;
            }
            // Check ;
            if (!Token.getNextToken()[0].equals(";")) {
                System.out.println("Error: Expected ; after the break");
                return false;
            }
        } while (Token.getNextToken()[0].equals("case"));
        Token.indexofToken--;
        // Check if there is Default
        if (Token.getNextToken()[0].equals("default")) {
            // Check :
            if (!Token.getNextToken()[0].equals(":")) {
                System.out.println("Error: Expected : after the case");
                return false;
            }
            // Check Statement
            // Assume the statement is just 1
            Statment.statment(Token.getNextToken());
            if (!Statment.vaildation()) {
                System.out.println("Error: Expected Statement inside the case condition ");
                return false;
            }
            // go for next line if there is default
        }
        // Check }
        if (!Token.getNextToken()[0].equals("}")) {
            System.out.println("Error: Expected } after the Cases");
            return false;
        }
        return true;
    }
}
