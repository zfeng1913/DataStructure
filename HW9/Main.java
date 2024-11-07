import java.util.Arrays;
import java.util.Comparator;
public class Main {
  public static void selectionSort(int[] arr) {
      for (int i=arr.length-1; i>0;i--){
        int max_index = 0;
        for (int j=0;j<=i;j++){

          if (arr[j] > arr[max_index]){
            max_index = j;
          }
        }
        int original_val = arr[i];
        arr[i] = arr[max_index];
        arr[max_index] = original_val;
      }
  }

  public static void insertionSort(int[] arr) {
      for (int n=1;n<arr.length;n++){
        int i = n;
        while (i > 0 && arr[i] < arr[i-1]){
          int larger = arr[i-1];
          arr[i-1] = arr[i];
          arr[i] = larger;
          i--;
        }

      }
  }
  public static void main(String[] args) {
    int[] array = new int[]{4, 5, 3, -1, 7,10,4};
    insertionSort(array);
    System.out.println(Arrays.toString(array));
    // int[] array = new int[]{6, 1, 3};
    // System.out.println(Arrays.toString(bubbleSort(array)));
    // int[] array = new int[]{6,4,3};
    // System.out.println(Arrays.toString(selectionSort(array)));
  }
}
