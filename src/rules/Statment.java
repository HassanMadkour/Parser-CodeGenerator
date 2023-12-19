package rules;

public class Statment {

    private static StatmentType getStatmenType(String[] token) {
        switch (token[1]) {
            case "if":

                break;
            case "for":
                break;
            case "EXPRESSION":
                break;
            case "d":
                break;

            default:
                break;
        }
        return StatmentType.IF;
    }

    public static void statment(String[] token) {

        switch (getStatmenType(token)) {
            case IF:

                break;
            case FOR:
                break;
            case EXPRESSION:

            default:
                break;
        }
    }

    enum StatmentType {
        IF, FOR, EXPRESSION, DECLERATION, Equation
    }
}

// expression
// for
// if
