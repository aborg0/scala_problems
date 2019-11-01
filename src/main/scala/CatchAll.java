import java.util.function.Supplier;

public class CatchAll {
    public static <T> T catchAll(Supplier<T> thunk) {
        try {
            return thunk.get();
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }
}
