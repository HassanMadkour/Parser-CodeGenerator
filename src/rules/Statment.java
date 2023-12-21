package rules;

import main.Token;

public class Statment {

    static public boolean vaild = true;

    private static StatmentType getStatmenType(String[] token) {
        switch (token[1]) {
            case "while":
                return StatmentType.WHILE;
            case "do":
                return StatmentType.DO;
            case "switch":
                return StatmentType.SWITCH;
            case "if":
                return StatmentType.IF;
            case "for":
                return StatmentType.FOR;
            case "Identifier":
                return StatmentType.ExpressionParser;
            case "datatype":
                return StatmentType.DECLERATION;

            default:
                return StatmentType.NONE;
        }
    }

    public static void statment(String[] token) {

        switch (getStatmenType(token)) {
            case IF:
                vaild = IF.ifStatment();
                break;
            case FOR:
                vaild = For.forStatment();
                break;
            case WHILE:
                vaild = While.whilestatement();
                break;
            case DO:
                vaild = DoWhile.doWhileStatment();
                break;
            case ExpressionParser:
                vaild = ExpressionParser.isValidExpression(false);
                break;
            case SWITCH:
                vaild = Switch.switchStatment();
                break;

            case DECLERATION:
                vaild = VariableDefinitionParser.isValidVariableDefinition();
                break;
            default: {
                if (Token.getNextToken()[0].equals(" ")) {
                    System.err.println("no Syntax Error");
                    vaild = false;
                } else {
                    System.err.println("the Statment Can not start with token " + Token.getcurrentToken()[0]);
                    vaild = false;
                }
            }
                break;
        }
    }

    static public boolean vaildation() {
        return vaild;
    }

    static boolean checkStartofStatment(String[] token) {

        return getStatmenType(token) == StatmentType.NONE ? false : true;
    }

    enum StatmentType {
        IF, FOR, ExpressionParser, DECLERATION, DO, WHILE, SWITCH, NONE // false statment
    }
}
