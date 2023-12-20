package rules;

import main.Token;

public class WHILE {

    public static void whilestatement() {

        if (Token.getNextToken()[0].equals("(")) {
            if (true// condation
            ) {
                if (Token.getNextToken()[0] == ")") {
                    if (Token.getNextToken()[0] == "{") {
                        Statment.statment(Token.getNextToken());
                        if (Token.getNextToken()[0] == "}") {

                            return;
                        } else {
                            System.err.println("} not exist");
                        }
                    } else {
                        System.err.println("{ not exist");
                    }
                } else {
                    System.err.println(") not exist");
                }
            } else {
                System.err.println(" cond error");

            }
        } else {
            System.err.println(" ( not exist");

        }
    }
}