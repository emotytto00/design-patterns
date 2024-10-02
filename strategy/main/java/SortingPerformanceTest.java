import java.util.Random;

public class SortingPerformanceTest {
    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(500);
        int[] largeArray = generateRandomArray(100000);

        System.out.println("Sorting small array (30 elements):");
        testSortingPerformance(smallArray.clone(), new BubbleSort(), "Bubble Sort");
        testSortingPerformance(smallArray.clone(), new MergeSort(), "Merge Sort");
        testSortingPerformance(smallArray.clone(), new QuickSort(), "Quick Sort");

        System.out.println("\nSorting large array (100,000 elements):");
        testSortingPerformance(largeArray.clone(), new BubbleSort(), "Bubble Sort");
        testSortingPerformance(largeArray.clone(), new MergeSort(), "Merge Sort");
        testSortingPerformance(largeArray.clone(), new QuickSort(), "Quick Sort");
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100000);
        }
        return array;
    }

    private static void testSortingPerformance(int[] array, SortingStrategy strategy, String strategyName) {
        SortingContext context = new SortingContext();
        context.setStrategy(strategy);
        long startTime = System.currentTimeMillis();
        context.sortArray(array);
        long endTime = System.currentTimeMillis();
        System.out.println(strategyName + " took " + (endTime - startTime) + " ms");
    }
}
