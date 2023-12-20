class ExpressionParser {

    public static boolean isValidExpression() {

        return parseIdentifier() && match("=") && parseIdentifier() && parseArithmeticOperator() && parseNumber()
                && match(";");
    }

    private static boolean parseIdentifier() {
        String token = nextToken();
        if (token.matches("[a-zA-Z][a-zA-Z0-9]*")) {
            return true;
        } else {
            System.out.println("Error: Expected an identifier but found " + token);
            return false;
        }
    }

    private static boolean parseNumber() {
        String token = nextToken();
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: Expected a number but found " + token);
            return false;
        }
    }

    private static boolean parseArithmeticOperator() {
        String token = nextToken();
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static boolean match(String expected) {
        String token = nextToken();
        if (token.equals(expected)) {
            return true;
        } else {
            System.out.println("Error: Expected '" + expected + "' but found " +
                    (token.isEmpty() ? "end of input" : "'" + token + "'"));
            return false;
        }
    }
}
