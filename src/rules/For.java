package rules;

import main.Token;

public class For {
    public static void forStatment() {
        if (Token.getNextToken()[0] == "(") {
            if (ExpressionParser.isValidExpression()// Decleration
            ) {
                if (true
                // condtion
                ) {
                    if (Token.getNextToken()[0] == ";") {
                        if (ExpressionParser.isValidExpression()) {
                            if (Token.getNextToken()[0] == ")") {
                                if (Token.getNextToken()[0] == "{") {
                                    Statment.statment(Token.getNextToken());
                                    if (Token.getNextToken()[0] == "}") {
                                        // end of for
                                    } else {

                                        System.err.println("Prehaps '}' non-exist");
                                    }

                                } else {
                                    System.err.println("Prehaps '{' non-exist");

                                }
                            } else {
                                System.err.println("Prehaps ')' non-exist ");
                            }

                        } else {
                            System.err.println("ex ");
                        }
                    } else {
                        System.err.println("; not exist");
                    }
                } else {
                    System.err.println("error in for condtion ");

                }

            } else {
                System.err.println("Syntax error on token '(', Expression expected after this token");

            }

        } else {
            System.err.println("Prehaps '(' non-exist ");
            return;
        }

    }
}
