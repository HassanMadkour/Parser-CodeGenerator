package rules;

public class Statment {

    private static StatmentType getStatmenType(String[] token) {
        switch (token[1]) {
            case "if":
                return StatmentType.IF;
            case "for":
                return StatmentType.FOR;
            case "Identifier":
                return StatmentType.EspressionParser;
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
                break;
            case EspressionParser:
                ExpressionParser.isValidExpression();

            default:
                break;
        }
    }

    static boolean checkStartofStatment(String[] token) {

        return getStatmenType(token) == StatmentType.NONE ? false : true;
    }

    enum StatmentType {
        IF, FOR, EspressionParser, DECLERATION, NONE // false statment
    }
}

// expression
// for
// if
