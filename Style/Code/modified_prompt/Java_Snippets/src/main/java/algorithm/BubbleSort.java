package algorithm;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * This class provides a method for sorting an array of integers using the Bubble Sort algorithm.
 */
public class BubbleSort {

    private static final Logger LOGGER = Logger.getLogger(BubbleSort.class.getName());

    /**
     * Sorts an array of integers using the Bubble Sort algorithm.
     *
     * @param arr the array to be sorted
     * @throws IllegalArgumentException if the array is null
     */
    public void sort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, then the array is sorted.
            if (!swapped) {
                break;
            }
        }

        LOGGER.info("Sorted array: " + Arrays.toString(arr));
    }
}
