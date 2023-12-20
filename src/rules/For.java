package rules;

import main.Token;

public class For {
    public static boolean forStatment() {
        if (Token.getNextToken()[0].equals("(")) {
            if (ExpressionParser.isValidExpression(false) || VariableDefinitionParser.isValidVariableDefinition()) {
                if (ConditionParser.isCondition()) {
                    if (Token.getNextToken()[0].equals(";")) {
                        if (ExpressionParser.isValidExpression(true)) {
                            if (Token.getNextToken()[0].equals(")")) {
                                if (Token.getNextToken()[0].equals("{")) {
                                    Statment.statment(Token.getNextToken());
                                    if (Token.getNextToken()[0].equals("}")) {
                                        // end of for
                                        return true;
                                    } else {

                                        System.err.println("Prehaps '}' non-exist");
                                        return false;

                                    }

                                } else {
                                    System.err.println("Prehaps '{' non-exist");
                                    return false;

                                }
                            } else {
                                System.err.println("Prehaps ')' non-exist ");
                                return false;

                            }

                        } else {
                            System.err.println("ex ");
                            return false;

                        }
                    } else {
                        System.err.println("; not exist");
                    }
                    return false;

                } else {
                    System.err.println("error in for condtion ");
                    return false;

                }

            } else {
                System.err.println("Syntax error on token '(', Expression expected after this token");
                return false;

            }

        } else {
            System.err.println("Prehaps '(' non-exist ");
            return false;

        }

    }
}
