package assignment02D;

public class StackAdapter <T> extends MaxHeap<T> implements StackInterface<T> {
	// Implemented as a CLASS ADAPTER: StackAdapter IS-A MaxHeap,
	// so it calls the inherited MaxHeap methods directly.
	// There is no explicit constructor (the default one calls MaxHeap()).
	// isEmpty() and setComp() are inherited from MaxHeap.
	public void push(T elem) {
		insert(elem);
	}
	public T peek() {
		return viewMax();
	}
	public T pop() {
		return extractMax();
	}
}
