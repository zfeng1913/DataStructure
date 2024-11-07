import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addToBack(1);
		System.out.println(Arrays.toString(arr.getBackingArray()));
		arr.addToBack(2);
		System.out.println(Arrays.toString(arr.getBackingArray()));
		arr.addToBack(3);
		System.out.println(Arrays.toString(arr.getBackingArray()));
		arr.addToBack(4);
		System.out.println(Arrays.toString(arr.getBackingArray()));
		arr.addToBack(5);
		System.out.println(Arrays.toString(arr.getBackingArray()));

		System.out.println(Arrays.toString(arr.getBackingArray())); // printing array


		arr.addToFront(0);

		System.out.println(Arrays.toString(arr.getBackingArray()));

		arr.removeFromBack();
		System.out.println("Removed element at back: "+Arrays.toString(arr.getBackingArray()));
		arr.removeFromFront();
		System.out.println("Removed element at front: "+Arrays.toString(arr.getBackingArray()));

		System.out.println("Size of arraylist: "+arr.size());


	}

}
