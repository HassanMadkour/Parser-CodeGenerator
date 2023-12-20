package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Token {
    static public int indexofToken = -1;
    static public List<String[]> tokens;

    public static List<String[]> convertTheFiletoList(File file) {

        try {
            List<String[]> tokenList = new ArrayList<>();

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words[1].equals("Keyword")) {
                    words[1] = typeOFKeyword(words[0]);
                }
                tokenList.add(words);
            }
            bufferedReader.close();
            return tokenList;
        } catch (FileNotFoundException e) {
            System.err.println("Can not find the file");
        } catch (IOException e) {
            System.err.println("error with file");

        }
        return List.of();

    }

    private static String typeOFKeyword(String keyword) {
        String[] keywords = { "if", "for", "else", "do", "while" };
        for (int i = 0; i < keywords.length; i++)
            if (keyword.equals(keywords[i]))
                return keywords[i];
        return "datatype";
    }

    public static String[] getNextToken() {
        indexofToken++;
        return tokens.get(indexofToken);
    }

}
