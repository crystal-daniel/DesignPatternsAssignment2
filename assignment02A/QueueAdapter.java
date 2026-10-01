package assignment02A;

public class QueueAdapter <T extends Comparable<T>> implements QueueInterface<T> {
	// Implement QueueInterface using an OBJECT ADAPTER
	MinHeap<T> adaptee;
	public QueueAdapter (MinHeap<T> adapteeIn) {
		adaptee = adapteeIn;
	}
	public void enqueue(T elem) {
		adaptee.insert(elem);
	}
	public T peek() {
		return adaptee.viewMin();
	}
	public T poll() {
		return adaptee.extractMin();
	}
	public boolean isEmpty() {
		return adaptee.isEmpty();
	}
}