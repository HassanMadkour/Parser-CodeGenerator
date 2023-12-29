package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import Scanner.File2TokenList;
import Scanner.TokenMapper;
import rules.Statment;

public class App {

    public static void main(String[] args) {
        try {
            File file = new File("resources/main.c");
            List<String> tokens = File2TokenList.convertFileToTokenList(file);

            File TokenWithType = new File("resources/TokenWithType.text");
            FileWriter fileWriter = new FileWriter(TokenWithType);

            for (String iterator : tokens) {
                String checkedTokenResult = TokenMapper.checkToken(iterator).orElse("");
                if (checkedTokenResult.isEmpty()) {
                    throw new NoSuchElementException("This token not in language: %s".formatted(iterator));

                } else {
                    fileWriter.write("%s %s\n".formatted(iterator, checkedTokenResult));
                }
            }

            fileWriter.close();
            File tokenFile = new File("resources/TokenWithType.text");
            File atomFile = new File("resources/atoms.text");
            FileWriter fileatom = new FileWriter(atomFile);
            Token.tokens = Token.convertTheFiletoList(tokenFile);

            while (Token.indexofToken < Token.tokens.size() && Statment.vaildation()) {

                Statment.statment(Token.getNextToken());

            }
            
            if(Statment.vaildwrite){
                for (String iterator : Atom.atomList) {
                    fileatom.write("%s \n".formatted(iterator));
                    System.err.println(iterator);
            }
            fileatom.close();
            }
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}