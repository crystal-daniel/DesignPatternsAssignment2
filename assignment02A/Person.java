package assignment02A;

public record Person(String name) {
	@Override
	public String toString() {
		return name;
	}
}

