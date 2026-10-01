package assignment02A;
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
		return index - other.index;
	}
	@Override
	public String toString() {
		return elem.toString() + "(" + index +")";
	}
}
