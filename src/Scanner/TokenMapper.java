package Scanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TokenMapper {

    private static final Map<String, String> tokenMapper;

    static {
        tokenMapper = new HashMap<>();
        // Common Keywords
        tokenMapper.put("auto", "Keyword");
        tokenMapper.put("break", "Keyword");
        tokenMapper.put("case", "Keyword");
        tokenMapper.put("char", "Keyword");
        tokenMapper.put("continue", "Keyword");
        tokenMapper.put("const", "Keyword");
        tokenMapper.put("default", "Keyword");
        tokenMapper.put("do", "Keyword");
        tokenMapper.put("double", "Keyword");
        tokenMapper.put("else", "Keyword");
        tokenMapper.put("enum", "Keyword");
        tokenMapper.put("extern", "Keyword");
        tokenMapper.put("float", "Keyword");
        tokenMapper.put("for", "Keyword");
        tokenMapper.put("goto", "Keyword");
        tokenMapper.put("if", "Keyword");
        tokenMapper.put("int", "Keyword");
        tokenMapper.put("long", "Keyword");
        tokenMapper.put("register", "Keyword");
        tokenMapper.put("return", "Keyword");
        tokenMapper.put("short", "Keyword");
        tokenMapper.put("signed", "Keyword");
        tokenMapper.put("sizeof", "Keyword");
        tokenMapper.put("static", "Keyword");
        tokenMapper.put("struct", "Keyword");
        tokenMapper.put("switch", "Keyword");
        tokenMapper.put("typedef", "Keyword");
        tokenMapper.put("union", "Keyword");
        tokenMapper.put("unsigned", "Keyword");
        tokenMapper.put("void", "Keyword");
        tokenMapper.put("volatile", "Keyword");
        tokenMapper.put("while", "Keyword");
        tokenMapper.put("cout", "Keyword");

        // Common Operators
        tokenMapper.put("+", "Operator");
        tokenMapper.put("-", "Operator");
        tokenMapper.put("*", "Operator");
        tokenMapper.put("/", "Operator");
        tokenMapper.put("%", "Operator");
        tokenMapper.put("=", "Operator");
        tokenMapper.put("!", "Operator");
        tokenMapper.put("&&", "Operator");
        tokenMapper.put("||", "Operator");
        tokenMapper.put("<", "Operator");
        tokenMapper.put(">", "Operator");
        tokenMapper.put("<=", "Operator");
        tokenMapper.put("<<", "Operator");
        tokenMapper.put(">>", "Operator");
        tokenMapper.put(">=", "Operator");
        tokenMapper.put("==", "Operator");
        tokenMapper.put("!=", "Operator");

        // Common punctuators
        tokenMapper.put("(", "Special Character");
        tokenMapper.put(")", "Special Character");
        tokenMapper.put("{", "Special Character");
        tokenMapper.put("}", "Special Character");
        tokenMapper.put(";", "Special Character");
        tokenMapper.put("'", "Special Character");
        tokenMapper.put("\"", "Special Character");
        tokenMapper.put(":", "Special Character");
    }

    public static Optional<String> checkToken(String token) {

        for (Map.Entry<String, String> item : tokenMapper.entrySet()) {
            if (item.getKey().equals(token)) {
                return Optional.of(item.getValue());
            }
        }
        return checkTokenIdentifier(token);
    }

    private static Optional<String> checkTokenIdentifier(String token) {
        if (token.matches("^[a-zA-Z_]+\\w*$")) {
            return Optional.of("Identifier");
        }
        if (token.matches("^[0-9]+|[0-9.0-9]+$\"")) {
            return Optional.of("Numeric Constant");
        }
        return Optional.empty();
    }
}
