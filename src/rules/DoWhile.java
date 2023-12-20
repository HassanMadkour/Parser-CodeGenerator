package rules;

import main.Token;

public class DoWhile {
    public static void doWhileStatment() {
        if (Token.getNextToken()[0].equals("{")) {
            Statment.statment(Token.getNextToken());
            if (Token.getNextToken()[0].equals("}")) {
                if (Token.getNextToken()[0].equals("while")) {

                    if (Token.getNextToken()[0].equals("(")) {
                        if (ConditionParser.isCondition()) {
                            if (Token.getNextToken()[0].equals(")")) {
                                if (Token.getNextToken()[0] == ";") {
                                    return;
                                } else {
                                    System.err.println("; not exist");
                                }
                            } else {
                                System.err.println(") not exist");
                            }

                        } else {
                            System.err.println("( error in condition");
                        }
                    } else {
                        System.err.println("( not exist");
                    }
                } else {
                    System.err.println("while not exist");
                }
            } else {
                System.err.println("} not exist");
            }

        } else {
            System.err.println("{ not exist");
        }
    }
}
