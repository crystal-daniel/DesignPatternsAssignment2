package assignment02C;
import java.util.Comparator;

public class QueueTester {

	public static void main(String[] args) {
		Comparator<TQadapter<Person>> comp = Comparator.naturalOrder();
		MaxHeap<TQadapter<Person>> heap = new MaxHeap<>();
		QueueAdapter<TQadapter<Person>> queue = new QueueAdapter<>(heap);
		queue.setComp(comp);
		
		
		for(int i = 0; i < 1000; i++) {
			if(queue.isEmpty()) TQadapter.resetCount();
			Person p = new Person("Person" + i);
			if(heap.size() == 1) System.out.println(heap);
			try {
				if(Math.random() < 0.45) {
					queue.enqueue(new TQadapter<Person>(p));
					System.out.println("Queue length " + heap.size() + ", " + p + " in queue");
				}
				else {
					System.out.println("\t" + p + " was not enqueued");
					System.out.print("\tPeek: " + queue.peek().getElem());
					System.out.println("\tPoll: " + queue.poll().getElem());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage() + " " + p + " was not enqueued");
			}
		}
		while(!queue.isEmpty()) {
			System.out.print("Peek: " + queue.peek());
			System.out.println("\tPoll: " + queue.poll());
		}
	}

}
