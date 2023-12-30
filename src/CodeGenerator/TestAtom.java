package CodeGenerator;

// (TEST,a,12,5,L0)
public class TestAtom {
    public static void testAtom(String atom) {
        // String atom = "(TEST,a,12,5,L0)";
        String arr[] = atom.split(",");
        assamply.sequance.add("LOD R1 , " + arr[1] + "\n");
        assamply.sequance.add("COM R1 , " + arr[2] + ", " + arr[3] + "\n");
        assamply.sequance.add("JMP " + arr[4].substring(0, arr[4].length() - 1) + "\n");
        System.err.println(assamply.sequance);

    }

    public static void MovAtom(String atom) {
        // String atom = "(MoV,a,12)";
        String arr[] = atom.split(",");
        assamply.sequance.add("Mov " + arr[1] + ", " + arr[2].substring(0, arr[2].length() - 1) + "\n");
        System.err.println(assamply.sequance);
    }

    public static void addAtom(String atom) {
        // String atom = "(Add,a,12,x)";
        String arr[] = atom.split(",");
        assamply.sequance.add("LOD R1 , " + arr[1] + "\n");
        assamply.sequance.add("Add R1 , " + arr[2] + ", " + "R1" + "\n");
        assamply.sequance.add("STO " + arr[3].substring(0, arr[3].length() - 1) + "\n");
        System.err.println(assamply.sequance);
    }

    public static void mulAtom(String atom) {
        // String atom = "(Add,a,12,x)";
        String arr[] = atom.split(",");
        assamply.sequance.add("LOD R1 , " + arr[1] + "\n");
        assamply.sequance.add("MUL R1 , " + arr[2] + ", " + "R1" + "\n");
        assamply.sequance.add("STO " + arr[3].substring(0, arr[3].length() - 1) + "\n");
        System.err.println(assamply.sequance);
    }

    public static void divAtom(String atom) {
        // String atom = "(Add,a,12,x)";
        String arr[] = atom.split(",");
        assamply.sequance.add("LOD R1 , " + arr[1] + "\n");
        assamply.sequance.add("Div R1 , " + arr[2] + ", " + "R1" + "\n");
        assamply.sequance.add("STO " + arr[3].substring(0, arr[3].length() - 1) + "\n");
        System.err.println(assamply.sequance);
    }

    public static void subAtom(String atom) {
        // String atom = "(Add,a,12,x)";
        String arr[] = atom.split(",");
        assamply.sequance.add("LOD R1 , " + arr[1] + "\n");
        assamply.sequance.add("SUB R1 , " + arr[2] + ", " + "R1" + "\n");
        assamply.sequance.add("STO " + arr[3].substring(0, arr[3].length() - 1) + "\n");
        System.err.println(assamply.sequance);
    }

}
