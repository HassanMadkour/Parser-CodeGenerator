package Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class File2TokenList {

    public static List<String> convertFileToTokenList(File file) {
        try {
            List<String> tokens = new ArrayList<>();

            FileReader fileReader = new FileReader(file);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    tokens.addAll(Arrays.stream(line.trim().split(" ")).toList());
                }
            }
            return tokens;
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (IOException e) {
            System.err.println("Error reading or writing the file.");
        }
        return List.of();
    }
}