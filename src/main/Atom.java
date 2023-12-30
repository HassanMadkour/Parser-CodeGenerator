package main;

import java.util.ArrayList;
import java.util.List;

public class Atom {

    static public int labelindex = 0;
    static public List<String> atomList = new ArrayList<>();

    public static String getNextLabel() {
        return "L" + labelindex++;
    }

    public static String getCurrentLabel() {
        return "L" + (labelindex - 1);
    }

    public static String getPreviousLabel() {
        return "L" + (labelindex - 2);
    }

    public static String getPreviousLabelp2() {
        return "L" + (labelindex - 3);
    }
    

    }


