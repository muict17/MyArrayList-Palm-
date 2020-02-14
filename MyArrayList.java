public class MyArrayList<T> {
	// initial state
	private T[] array;
	private int arraySize = 1;
	private int elements = 0;

	// new state
	private T[] newArray;

	// default constructor
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (T[]) new Object[arraySize];
	}

	// add
	@SuppressWarnings("unchecked")
	public void add(T val) {
		// if the elements already fill up the array then expand the array size by 1
		if (elements == arraySize) {
			newArray = (T[]) new Object[arraySize + 1];
			copyToNewArray(arraySize);
			array = newArray;
			arraySize++;
		}
		// set value
		array[elements] = val;
		// increment elements
		elements++;
	}

	// remove
	@SuppressWarnings("unchecked")
	public void remove(int n) {
		// shift elements after n to the left
		for (int i = n + 1; i < arraySize; i++) {
			array[i - 1] = array[i];
		}

		newArray = (T[]) new Object[arraySize - 1];
		copyToNewArray(arraySize - 1);
		array = newArray;
		arraySize--;
		elements--;

	}

	// get
	public T get(int n) {
		return array[n];
	}

	// size
	public int size() {
		return arraySize;
	}

	// print data
	public void printData() {
		System.out.print("[");
		for (int i = 0; i < arraySize; i++) {
			System.out.print(array[i]);
			if (i != arraySize - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");

	}

	// copy array
	public void copyToNewArray(int end) {
		for (int i = 0; i < end; i++) {
			newArray[i] = array[i];
		}
	}

}
