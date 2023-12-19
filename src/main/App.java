package main;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            File tokenFile = new File("N:/4thYear/first-Term/Compiler/project/parser/resources/Tokens.text");
            List<String> tokens = Covert2List.convertTheFiletoList(tokenFile);

        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
    }
}
