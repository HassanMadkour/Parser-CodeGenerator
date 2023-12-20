package rules;

public class Statment {

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
                IF.ifStatment();

                break;
            case FOR:
                For.forStatment();
                break;
            case WHILE:
                While.whilestatement();
                break;
            case DO:
                For.forStatment();
                break;
            case ExpressionParser:
                ExpressionParser.isValidExpression(false);
            case SWITCH:
                // Switch class

            case DECLERATION:
                VariableDefinitionParser.isValidVariableDefinition();
            default:
                System.err.println("Can't recognize this statement");
                break;
        }
    }

    static boolean checkStartofStatment(String[] token) {

        return getStatmenType(token) == StatmentType.NONE ? false : true;
    }

    enum StatmentType {
        IF, FOR, ExpressionParser, DECLERATION, DO, WHILE, SWITCH, NONE // false statment
    }
}
