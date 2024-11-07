import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> arr = new SinglyLinkedList<>();
		arr.addToFront(1);
		System.out.println(arr.getHead().getData());
    System.out.println(arr.getTail().getData());
    System.out.println(arr.size());

    arr.addToBack(2);
    arr.addToBack(3);

    System.out.println(arr.getHead().getData());
    System.out.println(arr.getTail().getData());
    System.out.println(arr.size());

    arr.removeFromBack();
    System.out.println(arr.getHead().getData());
    System.out.println(arr.getTail().getData());
    System.out.println(arr.size());

    arr.removeFromFront();
    System.out.println(arr.getHead().getData());
    System.out.println(arr.getTail().getData());
    System.out.println(arr.size());

	}

}
