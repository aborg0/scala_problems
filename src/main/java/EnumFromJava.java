import scala.Enumeration;

public class EnumFromJava {
    static void print(A$.Value a) {
        System.out.println(a);
    }
    public static void main(String[] args) {
        // Compiles and works as both A#Value and B#Value are erased to Enumeration#Value
        print(B.B2());
    }
}
