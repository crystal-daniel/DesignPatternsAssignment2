package assignment02C;

import java.util.Comparator;

import assignment02Csolution.MaxHeap;

public class QueueAdapter <T> implements QueueInterface<T> {
	// Same Assignment 2A except the constructor header is
	public QueueAdapter (MaxHeap<T> adapteeIn) {
		
	// and you also need
	public void setComp(Comparator<T> comp) {
		adaptee.setComp(comp);
	}
}
