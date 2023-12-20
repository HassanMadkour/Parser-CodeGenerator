package rules;

import main.Token;

public class While {

    public static boolean whilestatement() {

        if (Token.getNextToken()[0].equals("(")) {
            if (ConditionParser.isCondition()) {
                if (Token.getNextToken()[0] == ")") {
                    if (Token.getNextToken()[0] == "{") {
                        Statment.statment(Token.getNextToken());
                        if (Token.getNextToken()[0] == "}") {

                            return true;
                        } else {
                            System.err.println("} not exist");
                            return false;
                        }
                    } else {
                        System.err.println("{ not exist");
                        return false;

                    }
                } else {
                    System.err.println(") not exist");
                    return false;

                }
            } else {
                System.err.println(" cond error");
                return false;

            }
        } else {
            System.err.println(" ( not exist");
            return false;

        }
    }
}