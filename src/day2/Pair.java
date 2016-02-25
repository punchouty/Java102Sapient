package day2;

public class Pair<A, B> {
	
	private A first;
	private B second;
	
	public Pair(A first, B second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}

	public A getFirst() {
		return first;
	}

	public B getSecond() {
		return second;
	}
	
	public static void main(String[] args) {
		Pair<Integer, String> pair = new Pair<Integer, String>(1, "one");
		Pair pairRaw = new Pair(2, 2);
		System.out.println(pair);
	}

}
