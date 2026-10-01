package assignment02A;
public class MinHeapTester {
   public static void main(String[] args) {
       MinHeap<Integer> minHeap = new MinHeap<>();
       minHeap.insert(10);
       minHeap.insert(5);
       minHeap.insert(15);
       minHeap.insert(20);
       minHeap.insert(14);
       minHeap.insert(35);
       minHeap.insert(1);
       minHeap.insert(12);
       System.out.println("Extracted Min: " + minHeap.extractMin());
       System.out.println("Extracted Min: " + minHeap.extractMin());
       System.out.println("Extracted Min: " + minHeap.extractMin());
       System.out.println("Extracted Min: " + minHeap.extractMin());
       System.out.println("Extracted Min: " + minHeap.extractMin());
       System.out.println("Extracted Min: " + minHeap.extractMin());
       System.out.println("Extracted Min: " + minHeap.extractMin());
       System.out.println("Extracted Min: " + minHeap.extractMin());
       try {
    	   System.out.println("Extracted Min: " + minHeap.extractMin());
       } catch (Exception e) {
    	   System.out.println(e.getMessage());
       }
       int i = 0;
       while(true) {
    	   try {
    		   // 203000000, 204000000
    		   if(i == 203000000) {
    			   System.out.println("reached " + i);
    			   System.out.println(">>>>>>>>" + Integer.MAX_VALUE);
    		   }
    		   
    		   //if(i == Integer.MAX_VALUE/1024) System.out.println("reached " + i);
    		   minHeap.insert(i++);
           } catch (Exception e) {
        	   System.out.println("reached " + i);
        	   System.out.println(e.getMessage());
           }
       }
   }
}