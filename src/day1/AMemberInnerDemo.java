package day1;

public class AMemberInnerDemo {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.printInner();
	}

}

class Outer {
	
	int o = 10;
	
	void printOuter() {
		System.out.println("o : " + o);
	}
	
	
	class Inner {
		
		int i = 20;
		
		void printInner() {
			printOuter();
			System.out.println("o : " + o + ", i : " + i);
		}
		
	}
}
