package rules;

import main.Token;

public class For {
    public static boolean forStatment() {
        if (Token.getNextToken()[0].equals("(")) {
            if (Token.getNextToken()[1].equals("datatype") && VariableDefinitionParser.isValidVariableDefinition()) {
                if (ConditionParser.isCondition()) {
                    if (Token.getNextToken()[0].equals(";")) {
                        if (Token.getNextToken()[1].equals("Identifier") && ExpressionParser.isValidExpression(true)) {
                            if (Token.getNextToken()[0].equals(")")) {
                                if (Token.getNextToken()[0].equals("{")) {
                                    Statment.statment(Token.getNextToken());
                                    if (!Statment.vaildation()) {
                                        return false;
                                    }
                                    if (Token.getNextToken()[0].equals("}")) {
                                        // end of for
                                        return true;
                                    } else {

                                        System.err.println(" Prehaps '}' non-exist in for ");
                                        return false;

                                    }

                                } else {
                                    System.err.println(" Prehaps '{' non-exist in for");
                                    return false;

                                }
                            } else {
                                System.err.println(" Prehaps ')' non-exist in for");
                                return false;

                            }

                        } else {
                            System.err.println("ex ");
                            return false;

                        }
                    } else {
                        System.err.println("; not exist in for");
                    }
                    return false;

                } else {
                    System.err.println("error in for condtion in for ");
                    return false;

                }

            } else {
                System.err.println("Syntax error on token '(', error in for");
                return false;

            }

        } else {
            System.err.println(" Prehaps '(' non-exist in for ");
            return false;

        }

    }
}
