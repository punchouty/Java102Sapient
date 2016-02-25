package day1;

public class BStaticMemberDemo {

	public static void main(String[] args) {
		Outside.Inside inside = new Outside.Inside();
		inside.printInside();
	}

}

class Outside {
	int o = 10;
	
	void printOutside() {
		System.out.println(o);
	}
	
	static class Inside {
		int i = 20;
		
		void printInside() {
			System.out.println(" i : " + i);

		}
		
		// can i access o or printOutside
	}
}
