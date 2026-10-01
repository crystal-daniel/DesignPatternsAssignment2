package assignment02D;

import java.util.Comparator;

public class MaxHeapTester {
   public static void main(String[] args) {
       MaxHeap<Integer> maxHeap = new MaxHeap<>();
       maxHeap.setComp(Comparator.naturalOrder());
       maxHeap.insert(10);
       maxHeap.insert(5);
       maxHeap.insert(15);
       maxHeap.insert(20);
       maxHeap.insert(14);
       maxHeap.insert(35);
       maxHeap.insert(1);
       maxHeap.insert(12);
       System.out.println("Extracted Max: " + maxHeap.extractMax());
       System.out.println("Extracted Max: " + maxHeap.extractMax());
       System.out.println("Extracted Max: " + maxHeap.extractMax());
       System.out.println("Extracted Max: " + maxHeap.extractMax());
       System.out.println("Extracted Max: " + maxHeap.extractMax());
       System.out.println("Extracted Max: " + maxHeap.extractMax());
       System.out.println("Extracted Max: " + maxHeap.extractMax());
       System.out.println("Extracted Max: " + maxHeap.extractMax());
       try {
    	   System.out.println("Extracted Max: " + maxHeap.extractMax());
       } catch (Exception e) {
    	   System.out.println(e.getMessage());
       }
   }
}