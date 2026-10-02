package assignment02C;

import java.util.Comparator;

public class MyQueueTester {

	private static int passed = 0;
	private static int failed = 0;

	private static void check(boolean condition, String message) {
		if (condition) {
			passed++;
			System.out.println("PASS: " + message);
		} else {
			failed++;
			System.out.println("FAIL: " + message);
		}
	}

	public static void main(String[] args) {
		Comparator<TQadapter<Person>> comp = Comparator.naturalOrder();
		MaxHeap<TQadapter<Person>> heap = new MaxHeap<>();
		QueueAdapter<TQadapter<Person>> queue = new QueueAdapter<>(heap);
		queue.setComp(comp);

		// 10 people, in the order they arrive at the deli counter
		Person[] people = {
			new Person("Alice Johnson"),
			new Person("Brian Smith"),
			new Person("Carmen Lopez"),
			new Person("David Chen"),
			new Person("Emma Wilson"),
			new Person("Farid Khan"),
			new Person("Grace Kim"),
			new Person("Henry Adams"),
			new Person("Isabel Rossi"),
			new Person("Jamal Brooks")
		};

		// 1. A new queue must be empty
		check(queue.isEmpty(), "new queue is empty");

		// 2. peek and poll on an empty queue throw an exception
		try {
			queue.peek();
			check(false, "peek on empty queue throws an exception");
		} catch (RuntimeException e) {
			check(true, "peek on empty queue throws an exception (" + e.getMessage() + ")");
		}
		try {
			queue.poll();
			check(false, "poll on empty queue throws an exception");
		} catch (RuntimeException e) {
			check(true, "poll on empty queue throws an exception (" + e.getMessage() + ")");
		}

		// 3. Enqueue everyone; the front of the queue must always stay the first person
		for (Person p : people) {
			queue.enqueue(new TQadapter<Person>(p));
			System.out.println("Enqueued " + p + ", queue length " + heap.size());
			check(!queue.isEmpty(), "queue is not empty after enqueuing " + p);
			check(queue.peek().getElem() == people[0],
					"peek still shows " + people[0] + " after enqueuing " + p);
		}

		// 4. Poll everyone; they must come out in the same order they went in (FIFO)
		for (int i = 0; i < people.length; i++) {
			Person expected = people[i];
			Person peeked = queue.peek().getElem();
			check(peeked == expected, "peek shows " + expected + " (got " + peeked + ")");
			Person peekedAgain = queue.peek().getElem();
			check(peekedAgain == peeked, "peek does not remove " + peeked);
			Person polled = queue.poll().getElem();
			check(polled == expected, "poll returns " + expected + " (got " + polled + ")");
			if (i < people.length - 1) {
				check(!queue.isEmpty(), "queue is not empty after polling " + polled);
			}
		}

		// 5. After removing everyone the queue is empty again
		check(queue.isEmpty(), "queue is empty after polling all 10 people");

		// 6. Interleaved enqueue and poll still keeps arrival order
		queue.enqueue(new TQadapter<Person>(people[0]));
		queue.enqueue(new TQadapter<Person>(people[1]));
		check(queue.poll().getElem() == people[0], "interleaved: first poll returns " + people[0]);
		queue.enqueue(new TQadapter<Person>(people[2]));
		check(queue.peek().getElem() == people[1], "interleaved: peek shows " + people[1]);
		check(queue.poll().getElem() == people[1], "interleaved: second poll returns " + people[1]);
		check(queue.poll().getElem() == people[2], "interleaved: third poll returns " + people[2]);
		check(queue.isEmpty(), "interleaved: queue is empty at the end");

		System.out.println();
		System.out.println("Passed: " + passed + ", Failed: " + failed);
	}
}
