package base.algorithm;

public class MainAlgorithm {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort.sort(array);
        System.out.println("Sorted array: ");
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
