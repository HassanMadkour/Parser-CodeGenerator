package rules;

import main.Token;

public class IF {

    public static void ifStatment() {
        if (Token.getNextToken()[0] == "(") {
            if (true
            // condition
            ) {
                if (Token.getNextToken()[0] == ")") {
                    if (Token.getNextToken()[0] == "{") {
                        Statment.statment(Token.getNextToken());
                        if (Token.getNextToken()[0] == "}") {
                            if (Token.getNextToken()[0] == "else") {
                                if (Token.getNextToken()[0] == "{") {
                                    Statment.statment(Token.getNextToken());
                                    if (Token.getNextToken()[0] == "}") {
                                        System.err.println("");
                                    } else {
                                        System.err.println(" } not exist  ");
                                    }
                                } else {
                                    System.err.println(" prehaps this { not exist");

                                }
                            } // end of else

                        } else {
                            System.err.println("} not exist ");
                        }
                    } else {
                        System.err.println(" prehaps this { not exist");
                    }

                } else {
                    System.err.println("Error Syntax )");
                }
            } else {
                System.err.println("error in condtion");
            }
        } else {
            System.err.println("Error Syntax ( ");
        }

    }
}
