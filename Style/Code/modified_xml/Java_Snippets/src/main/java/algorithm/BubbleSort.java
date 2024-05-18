package algorithm;

/**
 * This class provides a method for sorting an array of integers using the bubble sort algorithm.
 */
public class BubbleSort {

    /**
     * Sorts an array of integers in ascending order using the bubble sort algorithm.
     *
     * @param array the array to be sorted
     */
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
