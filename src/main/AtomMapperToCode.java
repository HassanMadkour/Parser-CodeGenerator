package main;

import java.util.Arrays;

public class AtomMapperToCode {
     public String mapAtomToCode(String atom) {

        String[] fields = extractFields(atom);

        switch (fields[0].toUpperCase()) {
            case "ADD", "MUL", "DIV", "SUB" -> {
                return mathmeticalMapper(fields);
            }
            case "TST" -> {
                return conditionalMapper(fields);
            }
            case "MOV" -> {
                return moveMapper(fields);
            }
            case "JMP" -> {
                return jmpMapper(fields);
            }
            case "LBL" -> {
                return labelMapper(fields);
            }
            default -> {
                return "";
            }
        }
    }

    //

    private String mathmeticalMapper(String[] fields) {
        return """
                \tLOD R1, %S
                \t%S R1, %S
                \tSTO R1, %S
                """.formatted(fields[1], fields[0], fields[2], fields[3]);
    }

    private String conditionalMapper(String[] fields) { // tst
        return """
                \tLOD R1, %S
                \tCMP R1, %S, %S
                \tJMP %S
                """.formatted(fields[1], fields[2], fields[3], fields[4]);

    }

    private String jmpMapper(String[] fields) { // tst
        return """
                \tCMP 0, 0, 0
                \tJMP %S
                """.formatted(fields[1]);

    }


    private String moveMapper(String[] fields) {
        return """
                \tMOV %S, %S
                """.formatted(fields[1], fields[2]);

    }

    private String labelMapper(String[] fields) {
        return (fields[1] + ":");
    }

    private String[] extractFields(String atoms) {
        return Arrays.stream(atoms.substring(1, atoms.length() - 1).split(",")).map(String::trim).toArray(String[]::new);
    }
}
