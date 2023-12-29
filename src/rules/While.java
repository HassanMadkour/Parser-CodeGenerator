package rules;

import main.Atom;
import main.Token;

public class While {

    public static boolean whilestatement() {

        if (Token.getNextToken()[0].equals("(")) {
            Atom.atomList.add("(LBL,"+Atom.getNextLabel()+")");
            if (ConditionParser.isCondition()) {
                Atom.atomList.add("(JMP,"+Atom.getNextLabel()+")");
                Atom.atomList.add("(LBL,"+Atom.getPreviousLabel()+")");
                if (Token.getNextToken()[0].equals(")")) {
                    if (Token.getNextToken()[0].equals("{")) {
                        Statment.statment(Token.getNextToken());
                        Atom.atomList.add("(JMP,"+Atom.getPreviousLabelp2()+")");
                        Atom.atomList.add("(LBL,"+Atom.getCurrentLabel()+")");  
                        if (!Statment.vaildation()) {
                            return false;
                        }
                        if (Token.getNextToken()[0].equals("}")) {

                            return true;
                        } else {
                            System.err.println("while } not exist");
                            return false;
                        }
                    } else {
                        System.err.println("while { not exist");
                        return false;

                    }
                } else {
                    System.err.println("while ) not exist");
                    return false;

                }
            } else {
                System.err.println("while cond error");
                return false;

            }
        } else {
            System.err.println("while  ( not exist");
            return false;

        }
    }
}
