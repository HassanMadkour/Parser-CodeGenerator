package main;

import java.io.File;
import java.util.NoSuchElementException;

import rules.Statment;

public class App {

    public static void main(String[] args) throws Exception {
        try {

            // read file in list
            File tokenFile = new File("resources/newToken.text");
            Token.tokens = Token.convertTheFiletoList(tokenFile);

            // for (String[] array : Token.tokens) {
            // for (int i = 0; i < 2; i++) {
            // System.out.print(array[i] + " ");
            // }
            // System.out.print(" \n");

            // }

            // intial state
            while (Token.indexofToken < Token.tokens.size() && Statment.vaildation()) {

                Statment.statment(Token.getNextToken());

            }

        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
    }
}
