package day3.generics;

public class SortedPair<T extends Comparable<T>> {
	
	private final T smaller;
	private final T larger;

	public SortedPair(T first, T second) {
		if(first.compareTo(second) < 0) {
			this.smaller = first;
			this.larger = second;
		}
		else {
			this.smaller = second;
			this.larger = first;
		}
	}
	
	public T getSmaller() {
		return smaller;
	}

	public T getLarger() {
		return larger;
	}

}
