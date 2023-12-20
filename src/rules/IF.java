package rules;

import main.Token;

public class IF {

    public static boolean ifStatment() {
        if (Token.getNextToken()[0].equals("(")) {
            if (ConditionParser.isCondition()) {
                if (Token.getNextToken()[0].equals(")")) {
                    if (Token.getNextToken()[0].equals("{")) {
                        // write new statment
                        Statment.statment(Token.getNextToken());
                        // to stop if error show
                        if (!Statment.vaildation()) {
                            return false;
                        }
                        if (Token.getNextToken()[0].equals("}")) {
                            // check if else exist
                            if (Token.getNextToken()[0].equals("else")) {
                                if (Token.getNextToken()[0].equals("{")) {
                                    Statment.statment(Token.getNextToken());
                                    if (Token.getNextToken()[0].equals("}")) {
                                        // end of if statment
                                        return true;
                                    } else {
                                        System.err.println(" } not exist  ");
                                    }
                                } else {
                                    System.err.println(" prehaps this { not exist");

                                }
                            } // end of else
                              // end of if
                            return true;

                        } else {
                            System.err.println("} not exist ");
                            return false;

                        }
                    } else {
                        System.err.println(" prehaps this { not exist");
                        return false;

                    }

                } else {
                    System.err.println("Error Syntax )");
                    return false;

                }
            } else {
                System.err.println("error in condtion");
                return false;

            }
        } else {
            System.err.println("Error Syntax ( ");
            return false;

        }

    }
}
