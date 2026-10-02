package assignment02D;

import java.util.Comparator;

public class MyStackTester {

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
		Comparator<TSadapter<Person>> comp = Comparator.naturalOrder();
		StackAdapter<TSadapter<Person>> stack = new StackAdapter<>();
		stack.setComp(comp);

		// 10 people, in the order they are pushed on the stack
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

		// 1. A new stack must be empty
		check(stack.isEmpty(), "new stack is empty");

		// 2. peek and pop on an empty stack throw an exception
		try {
			stack.peek();
			check(false, "peek on empty stack throws an exception");
		} catch (RuntimeException e) {
			check(true, "peek on empty stack throws an exception (" + e.getMessage() + ")");
		}
		try {
			stack.pop();
			check(false, "pop on empty stack throws an exception");
		} catch (RuntimeException e) {
			check(true, "pop on empty stack throws an exception (" + e.getMessage() + ")");
		}

		// 3. Push everyone; the top of the stack must always be the person just pushed
		for (Person p : people) {
			stack.push(new TSadapter<Person>(p));
			System.out.println("Pushed " + p + ", stack length " + stack.size());
			check(!stack.isEmpty(), "stack is not empty after pushing " + p);
			check(stack.peek().getElem() == p, "peek shows " + p + " right after pushing it");
		}

		// 4. Pop everyone; they must come out in reverse order (LIFO)
		for (int i = people.length - 1; i >= 0; i--) {
			Person expected = people[i];
			Person peeked = stack.peek().getElem();
			check(peeked == expected, "peek shows " + expected + " (got " + peeked + ")");
			Person peekedAgain = stack.peek().getElem();
			check(peekedAgain == peeked, "peek does not remove " + peeked);
			Person popped = stack.pop().getElem();
			check(popped == expected, "pop returns " + expected + " (got " + popped + ")");
			if (i > 0) {
				check(!stack.isEmpty(), "stack is not empty after popping " + popped);
			}
		}

		// 5. After removing everyone the stack is empty again
		check(stack.isEmpty(), "stack is empty after popping all 10 people");

		// 6. Interleaved push and pop still keeps LIFO order
		stack.push(new TSadapter<Person>(people[0]));
		stack.push(new TSadapter<Person>(people[1]));
		check(stack.pop().getElem() == people[1], "interleaved: first pop returns " + people[1]);
		stack.push(new TSadapter<Person>(people[2]));
		check(stack.peek().getElem() == people[2], "interleaved: peek shows " + people[2]);
		check(stack.pop().getElem() == people[2], "interleaved: second pop returns " + people[2]);
		check(stack.pop().getElem() == people[0], "interleaved: third pop returns " + people[0]);
		check(stack.isEmpty(), "interleaved: stack is empty at the end");

		System.out.println();
		System.out.println("Passed: " + passed + ", Failed: " + failed);
	}
}
