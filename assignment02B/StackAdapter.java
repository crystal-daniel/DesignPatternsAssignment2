package assignment02B;

public class StackAdapter <T extends Comparable<T>> extends MinHeap <T> implements StackInterface<T> {
	// Implemented as a CLASS ADAPTER: StackAdapter IS-A MinHeap,
	// so it calls the inherited MinHeap methods directly.
	// There is no explicit constructor (the default one calls MinHeap()).
	// isEmpty() is already inherited from MinHeap and satisfies StackInterface.
	public void push(T elem) {
		insert(elem);
	}
	public T peek() {
		return viewMin();
	}
	public T pop() {
		return extractMin();
	}
}