package assignment02D;

public record Person(String name) {
	@Override
	public String toString() {
		return name;
	}
}

