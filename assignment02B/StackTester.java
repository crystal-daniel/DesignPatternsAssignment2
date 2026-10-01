package assignment02B;

public class StackTester {

	public static void main(String[] args) {
		StackAdapter<TSadapter<Person>> stack = new StackAdapter<>();
		
		for(int i = 0; i < 1000; i++) {
			if(stack.isEmpty()) TSadapter.resetCount();
			Person p = new Person("Person" + i);
			if(stack.size() == 1) System.out.println(stack);
			try {
				if(Math.random() < 0.45) {
					stack.push(new TSadapter<Person>(p));
					System.out.println("Stack length " + stack.size() + ", " + p + " in stack");
				}
				else {
					System.out.println("\t" + p + " was not stacked");
					System.out.print("\tPeek: " + stack.peek().getElem());
					System.out.println("\tPoll: " + stack.pop().getElem());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage() + " " + p + " was not stacked");
			}
		}
		while(!stack.isEmpty()) {
			System.out.print("Peek: " + stack.peek());
			System.out.println("\tPoll: " + stack.pop());
		}
	}

}
