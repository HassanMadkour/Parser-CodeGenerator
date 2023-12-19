package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Token {
    static int indexofToken = 0;
    static List<String> tokens;

    public static List<String> convertTheFiletoList(File file) {

        try {
            List<String> tokens = new ArrayList<>();
            String token;

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((token = bufferedReader.readLine()) != null) {
                tokens.add(token);
            }
            bufferedReader.close();
            return tokens;
        } catch (FileNotFoundException e) {
            System.err.println("Can not find the file");
        } catch (IOException e) {
            System.err.println("error with file");

        }
        return List.of();

    }

    public static String getNextToken(){

        return 
    }

}
