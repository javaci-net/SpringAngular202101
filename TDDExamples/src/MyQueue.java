

public class MyQueue<T>  {

	private T arr[];
	
	
	public MyQueue() {
		arr = (T[])new Object[0];
	}
	
	public Object size() {
		return arr.length;
	}

	public void push(T string) {
		T newArr[] = (T[]) new Object[arr.length+1];
		for (int i=0; i<arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = string;
		arr = newArr;
	}



	public T pop() {
		if (arr.length == 0)
			throw new IllegalStateException();
		T pop = arr[arr.length-1];
		T newArr[] = (T[])new Object[arr.length-1];
		for (int i=0; i<arr.length-1; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
		return pop;
	}



	public T peek() {
		return arr[arr.length-1];
	}

	
}

