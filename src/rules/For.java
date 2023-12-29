package rules;

import main.Atom;
import main.Token;

public class For {
    public static boolean forStatment() {
        if (Token.getNextToken()[0].equals("(")) {
            if (Token.getNextToken()[1].equals("datatype") && VariableDefinitionParser.isValidVariableDefinition()) {
                Atom.atomList.add("(LBL,"+Atom.getNextLabel()+")");
                if (ConditionParser.isCondition()) {
                    Atom.atomList.add("(JMP,"+Atom.getNextLabel()+")");
                    Atom.atomList.add("(LBL,"+Atom.getPreviousLabel()+")");                  
                    if (Token.getNextToken()[0].equals(";")) {
                        if (Token.getNextToken()[1].equals("Identifier") && ExpressionParser.isValidExpression(true)) {
                            if (Token.getNextToken()[0].equals(")")) {
                                if (Token.getNextToken()[0].equals("{")) {
                                    Statment.statment(Token.getNextToken());
                                    String a1 = Atom.atomList.get(Atom.atomList.size()-1);
                                    String a2 = Atom.atomList.get(Atom.atomList.size()-2);
                                    Atom.atomList.set(Atom.atomList.size()-1, a2);
                                    Atom.atomList.set(Atom.atomList.size()-1, a1);
                                    Atom.atomList.add("(JMP,"+Atom.getPreviousLabelp2()+")");
                                    Atom.atomList.add("(LBL,"+Atom.getCurrentLabel()+")");   
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
