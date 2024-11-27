import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int count = 0;
    private final int limit;
    private int prev = 0;
    private int current = 1;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return count < limit;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements in the sequence");
        }

        count++;

        if (count == 1) {
            return 1;
        }

        int nextValue = prev + current;
        prev = current;
        current = nextValue;

        return current;
    }
}
