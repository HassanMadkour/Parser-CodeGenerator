package rules;

import main.Token;

public class DoWhile {
    public static boolean doWhileStatment() {
        if (Token.getNextToken()[0].equals("{")) {
            Statment.statment(Token.getNextToken());
            if (Token.getNextToken()[0].equals("}")) {
                if (Token.getNextToken()[0].equals("while")) {

                    if (Token.getNextToken()[0].equals("(")) {
                        if (ConditionParser.isCondition()) {
                            if (Token.getNextToken()[0].equals(")")) {
                                if (Token.getNextToken()[0].equals(";")) {
                                    return true;
                                } else {
                                    System.err.println("; not exist");
                                    return false;

                                }
                            } else {
                                System.err.println(") not exist");
                                return false;

                            }

                        } else {
                            System.err.println("( error in condition");
                            return false;

                        }
                    } else {
                        System.err.println("( not exist");
                        return false;

                    }
                } else {
                    System.err.println("while not exist");
                    return false;

                }
            } else {
                System.err.println("} not exist");
                return false;

            }
        } else {
            System.err.println("{ not exist");
            return false;

        }
    }
}
