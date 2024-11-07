import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        int stop_index = arr.length - 1;
        while (stop_index > 0){
          int i=0;
          int last_swap_index=0;
          while (i < stop_index){

            if (comparator.compare(arr[i], arr[i+1])>0){
              T smaller = arr[i+1];
              arr[i+1] = arr[i];
              arr[i] = smaller;
              last_swap_index = i;
            }
          i++;
          }
          stop_index = last_swap_index;
        }
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        for (int i=arr.length - 1; i>0;i--){
          int max_index = 0;
          for (int j=0;j<=i;j++){

            if (comparator.compare(arr[j], arr[max_index])>0){
              max_index = j;
            }
          }
          T original_val = arr[i];
          arr[i] = arr[max_index];
          arr[max_index] = original_val;
        }
    }


    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
      for (int n=1;n<arr.length;n++){
        int i = n;
        while (i > 0 && (comparator.compare(arr[i], arr[i-1])<0)){
          T larger = arr[i-1];
          arr[i-1] = arr[i];
          arr[i] = larger;
          i--;
        }

      }
    }
}
