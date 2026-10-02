package assignment02C;
class TQadapter <T> implements Comparable<TQadapter<T>> {
	static int count = 0;
	T elem;
	int index;
	public TQadapter(T elemIn) {
		elem = elemIn;
		index = ++count;
	}
	static void resetCount() {
		count = 0;
	}
	public T getElem() {
		return elem;
	}
	@Override
	public int compareTo(TQadapter<T> other) {
		// reversed ordering: the oldest element (lowest index) is the "largest",
		// so the MaxHeap gives First-In-First-Out behaviour
		return other.index - index;
	}
	@Override
	public String toString() {
		return elem.toString() + "(" + index +")";
	}
}
