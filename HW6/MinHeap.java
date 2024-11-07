import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        if (data == null){
        throw new IllegalArgumentException();
      }
    //   double the capacity

        if (size + 2> backingArray.length){
            T[] newArray = (T[]) new Comparable[backingArray.length * 2];
            for (int i=0;i<size+1;i++){
              newArray[i] = backingArray[i];
            }
            backingArray = newArray;}

        size++;
        backingArray[size] = data;
        int index = size;
        while (index/2 >= 1){
            if (data.compareTo(backingArray[index/2]) < 0){
                T swapped_num = backingArray[index/2];
                backingArray[index/2] = data;
                backingArray[index] = swapped_num;
                index = index/2;
            }else{
                break;
            }

        }
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        if (size == 0){
            throw new NoSuchElementException();
        }
        T answer = backingArray[1];
        if (size == 1){
            backingArray[size] = null;
            size--;
            return answer;
        }


        T data = backingArray[size];
        backingArray[size] = null;
        size --;
        int index = 1;

        backingArray[index] = data;

        while (2 * index <= size){

            if (((2 * index + 1 <= size) && (backingArray[index*2].compareTo(backingArray[index*2+1]) < 0)) || (2 * index + 1 > size)){
                if (backingArray[index].compareTo(backingArray[index*2]) < 0){
                    break;
                }else {
                    T new_num = backingArray[index*2];
                    backingArray[index*2] = backingArray[index];
                    backingArray[index] = new_num;
                    index = 2 * index;
                }
            }else{
                if (backingArray[index].compareTo(backingArray[index*2+1]) < 0){
                    break;
                }else {
                    T new_num = backingArray[index*2+1];
                    backingArray[index*2+1] = backingArray[index];
                    backingArray[index] = new_num;
                    index = 2 * index + 1;
                }
                }
        }
        return answer;

    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
