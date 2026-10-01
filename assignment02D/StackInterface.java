package assignment02D;

public interface StackInterface<T> {
	public void push(T elem);
	public T peek();
	public T pop();
	public boolean isEmpty();
}
