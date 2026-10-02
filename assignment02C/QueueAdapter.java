package assignment02C;

import java.util.Comparator;

public class QueueAdapter <T> implements QueueInterface<T> {
	// Implement QueueInterface using an OBJECT ADAPTER around a MaxHeap.
	// T no longer needs to be Comparable: the MaxHeap uses the Comparator
	// supplied through setComp.
	MaxHeap<T> adaptee;
	public QueueAdapter (MaxHeap<T> adapteeIn) {
		adaptee = adapteeIn;
	}
	public void setComp(Comparator<T> comp) {
		adaptee.setComp(comp);
	}
	public void enqueue(T elem) {
		adaptee.insert(elem);
	}
	public T peek() {
		return adaptee.viewMax();
	}
	public T poll() {
		return adaptee.extractMax();
	}
	public boolean isEmpty() {
		return adaptee.isEmpty();
	}
}
