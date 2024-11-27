public class IteratorMain {
    public static void main(String[] args) {
        int limit = 10;
        FibonacciSequence fibonacciSequence = new FibonacciSequence(limit);

        System.out.println("First " + limit + " Fibonacci numbers:");
        for (Integer number : fibonacciSequence) {
            System.out.print(number + " ");
        }
    }
}
