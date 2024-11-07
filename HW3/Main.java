import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		ArrayQueue<Integer> arr = new ArrayQueue<>();
		arr.enqueue(1);
		System.out.println(Arrays.toString(arr.getBackingArray()));
		arr.enqueue(2);
		System.out.println(Arrays.toString(arr.getBackingArray()));
		arr.enqueue(3);
		System.out.println(Arrays.toString(arr.getBackingArray()));
    arr.enqueue(4);
		System.out.println(Arrays.toString(arr.getBackingArray()));
    arr.enqueue(5);
		System.out.println(Arrays.toString(arr.getBackingArray()));
    arr.enqueue(6);
		System.out.println(Arrays.toString(arr.getBackingArray()));
		arr.dequeue();
    System.out.println(Arrays.toString(arr.getBackingArray()));


  }}
