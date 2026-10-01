package assignment02C;

public interface QueueInterface<T> {
	public void enqueue(T elem);
	public T peek();
	public T poll();
	public boolean isEmpty();
}
