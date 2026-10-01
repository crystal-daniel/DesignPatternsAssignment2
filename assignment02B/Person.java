package assignment02B;

public record Person(String name) {
	@Override
	public String toString() {
		return name;
	}
}

