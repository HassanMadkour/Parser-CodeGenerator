package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    private static final AtomMapperToCode mapperToCode;

    static {
        mapperToCode = new AtomMapperToCode();
    }

    public static List<String> generateCode(File atomsFile) {
        try {
            List<String> codes = new ArrayList<>();

            FileReader fileReader = new FileReader(atomsFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String atom;

            while ((atom = bufferedReader.readLine()) != null) {
                codes.add(mapperToCode.mapAtomToCode(atom.trim()));
            }

            return codes;

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (IOException e) {
            System.err.println("Error reading or writing the file.");
        }
        return List.of();
    }
}
