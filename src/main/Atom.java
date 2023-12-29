package main;

import java.util.List;
import java.util.ArrayList;

public class Atom {

    static public int labelindex = 0;
    static public List<String> atomList= new ArrayList<>();;

    public static String getNextLabel() {
        return "L" + ++labelindex;
    }

    public static String getCurrentLabel() {
        return "L" + --labelindex;
    }

    public static String getPreviousLabel() {
        return "L" + (labelindex - 2);
    }

}
