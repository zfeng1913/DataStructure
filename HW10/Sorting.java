import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    private static <T> void merge(T[] arr, Comparator<T> comparator,
                                   T[] leftArr, T[] rightArr) {
         int i = 0;
         int j = 0;
         for (int k = 0; k < arr.length; k++) {
             if (j >= rightArr.length || (i < leftArr.length
                     && comparator.compare(leftArr[i], rightArr[j]) <= 0)) {
                 arr[k] = leftArr[i];
                 i++;
             } else {
                 arr[k] = rightArr[j];
                 j++;
             }
         }
    }
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
      if (arr.length > 1){
        n1 = arr.length/2;
        n2 = arr.length - n1;
        T left[] = new T[n1];
        T right[] = new T[n2];
        // T[] left = (T[]) new Object[arr.length/2];
        // T[] right = (T[]) new Object[arr.length - left.length];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[i + left.length];
        }
        mergeSort(left, comparator);
        mergeSort(right, comparator);
        merge(arr, comparator, left, right);

      }

    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }
}
