class VariableDefinitionParser {


    public static boolean isValidVariableDefinition() {

        return  parseIdentifier() && parseInitialization() && match(";");
    }


private static boolean parseIdentifier() {
        String token = token.getnextToken()[1];
        if (token.matches("Identifier")) {
            return true;
        } else {
            System.out.println("Error: Expected an identifier but found " + token.getnextToken()[0]);
            return false;
        }
    }
private static boolean parseInitialization() {
String token = token.getnextToken()[0];
        if (token.equals("=")) {
            return parseExpression();
        }

      
        return true; // No initialization is also valid
    }

    private static boolean parseExpression() {
        return parseNumber();
    }

    private static boolean parseNumber() {
        String token = token.getnextToken()[1];
        if (token.matches("Numeric")) {
            return true;
        } else {
            System.out.println("Error: Expected a numeric value but found " + token.getnextToken()[0]);
            return false;
        }
            
    }
    private static boolean match(String expected) {
        String token = Token.getNextToken()[0];
        if (token.equals(expected)) {
            return true;
        } else{
                // Check if it's the end of input
                if (token.isEmpty()) {
                    System.out.println("Error: Expected '" + expected + "' but found end of input");
                } else {
                    System.out.println("Error: Expected '" + expected + "' but found '" + token + "'");
                }
                return false;
            }
        
        
    }


}
