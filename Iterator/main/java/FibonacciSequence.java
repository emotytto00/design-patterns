import java.util.Iterator;

public class FibonacciSequence implements Iterable<Integer> {
    private final int limit;

    public FibonacciSequence(int limit) {
        this.limit = limit;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}
