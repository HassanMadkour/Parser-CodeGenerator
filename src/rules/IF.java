package rules;
import main.Atom;
import main.Token;

public class IF {

    public static boolean ifStatment() {
        if (Token.getNextToken()[0].equals("(")) {
            if (ConditionParser.isCondition()) {
                if (Token.getNextToken()[0].equals(")")) {
                    if (Token.getNextToken()[0].equals("{")) {
                        // write new statment
                        Atom.atomList.add("(JMP,"+Atom.getNextLabel()+")");
                       
                        Atom.atomList.add("(LBL,"+Atom.getPreviousLabel()+")");
                        
                        Statment.statment(Token.getNextToken());
                        Atom.atomList.add("(LBL,"+Atom.getCurrentLabel()+")");
                       
                        // to stop if error show
                        if (!Statment.vaildation()) {
                            return false;
                        }
                        if (Token.getNextToken()[0].equals("}")) {
                            // check if else exist
                            if (Token.getNextToken()[0].equals("else")) {
                                if (Token.getNextToken()[0].equals("{")) {
                                    Statment.statment(Token.getNextToken());
                                    if (!Statment.vaildation()) {
                                        return false;
                                    }
                                    if (Token.getNextToken()[0].equals("}")) {
                                        // end of if statment
                                        return true;
                                    } else {
                                        System.err.println(" } not exist  in if  ");
                                    }
                                } else {
                                    System.err.println(" prehaps this { not exist in if ");

                                }
                            } // end of else
                              // end of if
                            Token.decrementIndex();
                            return true;

                        } else {
                            System.err.println("} not exist in if ");
                            return false;

                        }
                    } else {
                        System.err.println(" prehaps this { not exist in if");
                        return false;

                    }

                } else {
                    System.err.println("Error Syntax )  in if");
                    return false;

                }
            } else {
                System.err.println("error in condtion in if");
                return false;

            }
        } else {
            System.err.println("Error Syntax (  in if");
            return false;

        }

    }
}
