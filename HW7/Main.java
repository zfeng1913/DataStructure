import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		ExternalChainingHashMap<Integer, Integer> arr = new ExternalChainingHashMap<>();
		arr.put(1, 2);
		System.out.println(Arrays.toString(arr.getTable()));

		System.out.println(arr.put(1, 5));
		System.out.println(Arrays.toString(arr.getTable()));



		System.out.println(arr.put(4, 5));
		System.out.println(Arrays.toString(arr.getTable()));
		System.out.println(arr.put(7, 5));
		System.out.println(Arrays.toString(arr.getTable()));
		System.out.println(arr.put(10, 5));
		System.out.println(Arrays.toString(arr.getTable()));
		System.out.println(arr.put(13, 5));
		System.out.println(Arrays.toString(arr.getTable()));





  }}
