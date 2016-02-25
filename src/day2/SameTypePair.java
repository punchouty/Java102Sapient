package day2;

public class SameTypePair<T> {
	
	private T first;
	private T second;
	
	public SameTypePair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "SameTypePair [first=" + first + ", second=" + second + "]";
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}
	
	public static <T extends Comparable<T>> T getMinumum(SameTypePair<T> pair) {
		if(pair.getFirst().compareTo(pair.getSecond()) > 0) {
			return pair.getFirst();
		}
		else {
			return pair.getSecond();
		}
	}

}
