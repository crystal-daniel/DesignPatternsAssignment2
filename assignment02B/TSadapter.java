package assignment02B;
class TSadapter <T> implements Comparable<TSadapter<T>> {
	static int count = 0;
	T elem;
	int index;
	public TSadapter(T elemIn) {
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
	public int compareTo(TSadapter<T> other) {
		// reversed ordering: the newest element (highest index) is the "smallest",
		// so the MinHeap gives Last-In-First-Out behaviour
		return other.index - index;
	}
	@Override
	public String toString() {
		return elem.toString() + "(" + index +")";
	}
}