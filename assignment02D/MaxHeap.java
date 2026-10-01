package assignment02D;
import java.util.ArrayList;
import java.util.Comparator;
public class MaxHeap <T> {
	private ArrayList<T> list;
	Comparator<T> comp;
	public MaxHeap () {
		list = new ArrayList<>();
	}	
	public void setComp(Comparator<T> comp) {
		this.comp = comp;
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
		while (currentIndex > 0 && comp.compare(list.get(currentIndex),list.get(parent(currentIndex))) > 0) {
			swap(currentIndex, parent(currentIndex));
			currentIndex = parent(currentIndex);
		}
	}
	public T viewMax() {
		if (list.isEmpty()) throw new RuntimeException("Heap is empty");
		return list.get(0);
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public T extractMax() {
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
		int largest = i;
		int left = leftChild(i);
		int right = rightChild(i);
		if (left < list.size() && comp.compare(list.get(left),list.get(largest)) > 0) largest = left;
		if (right < list.size() && comp.compare(list.get(right),list.get(largest)) > 0) largest = right;
		if (largest != i) {
			swap(i, largest);
			heapifyDown(largest);
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
