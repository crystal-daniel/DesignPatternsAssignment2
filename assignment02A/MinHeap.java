package assignment02A;
import java.util.ArrayList;
public class MinHeap <T extends Comparable<T>>{
	private ArrayList<T> list;
	public MinHeap() {
		list = new ArrayList<>();
	}
	private int parent(int i) {
		return (i - 1) / 2;
	}
	private int leftChild(int i) {
		return 2 * i + 1;
	}
	private int rightChild(int i) {
		return 2 * i + 2;
	}
	private void swap(int i, int j) {
		T temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	public void insert(T value) {
		list.add(value);		   
		int currentIndex = list.size() - 1;
		while (currentIndex > 0 && list.get(currentIndex).compareTo(list.get(parent(currentIndex))) < 0) {
			swap(currentIndex, parent(currentIndex));
			currentIndex = parent(currentIndex);
		}
	}
	public T viewMin() {
		if (list.isEmpty()) throw new RuntimeException("Heap is empty");
		return list.get(0);
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public T extractMin() {
		if (list.isEmpty()) throw new RuntimeException("Heap is empty");
		T min = list.get(0);
		T lastElement = list.remove(list.size() - 1);
		if (!list.isEmpty()) {
			list.set(0, lastElement);
			heapifyDown(0);
		}
		return min;
	}
	private void heapifyDown(int i) {
		int smallest = i;
		int left = leftChild(i);
		int right = rightChild(i);
		if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) smallest = left;
		if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) smallest = right;
		if (smallest != i) {
			swap(i, smallest);
			heapifyDown(smallest);
		}
	}
	public int size() {
		return list.size();
	}
	@Override
	public String toString() {
		return list.toString();
	}
}
