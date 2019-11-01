import scala.collection.immutable.List;

public class Mutate {
    public static <T> List<T> changeTail(scala.collection.immutable.$colon$colon<T> nel, List<T> newTail) {
        nel.next_$eq(newTail);
        return nel;
    }
}
