package rules;

import main.Token;

public class While {

    public static boolean whilestatement() {

        if (Token.getNextToken()[0].equals("(")) {
            if (ConditionParser.isCondition()) {
                if (Token.getNextToken()[0].equals(")")) {
                    if (Token.getNextToken()[0].equals("{")) {
                        Statment.statment(Token.getNextToken());
                        if (!Statment.vaildation()) {
                            return false;
                        }
                        if (Token.getNextToken()[0].equals("}")) {

                            return true;
                        } else {
                            System.err.println("while } not exist");
                            return false;
                        }
                    } else {
                        System.err.println("while { not exist");
                        return false;

                    }
                } else {
                    System.err.println("while ) not exist");
                    return false;

                }
            } else {
                System.err.println("while cond error");
                return false;

            }
        } else {
            System.err.println("while  ( not exist");
            return false;

        }
    }
}