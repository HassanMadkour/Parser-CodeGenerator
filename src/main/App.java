package main;

import java.io.File;
import java.util.NoSuchElementException;

public class App {

    public static void main(String[] args) throws Exception {
        try {
            File tokenFile = new File("N:/4thYear/first-Term/Compiler/project/parser/resources/Tokens.text");
            Token.tokens = Token.convertTheFiletoList(tokenFile);

        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
    }
}
