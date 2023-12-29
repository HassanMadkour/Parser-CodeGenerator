package CodeGenerator;
// (TEST,a,12,5,L0)
public class TestAtom {
    public static void Testatom (){
        String atom = "(TEST,a,12,5,L0)";
        String arr []= atom.split(",");
        assamply.sequance.add("LOD R1 , "+arr[1]+"\n");
        assamply.sequance.add("COM R1 , "+arr[2] + ", " +arr[3]+"\n");
        assamply.sequance.add("JMP "+arr[4].substring(0, arr[4].length()-1)+"\n");
        System.err.println(assamply.sequance);

    }

}
