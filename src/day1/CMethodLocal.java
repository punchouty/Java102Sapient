package day1;

public class CMethodLocal {
	
	void someMethod() {
		System.out.println("Outer");
	}
	
	void defineInner() {
		int i = 0;
		class MethodInner {
			int k;
			
			void print() {
				System.out.println("k : " + k + ", i : " + i);
				someMethod();
			}
		}
		MethodInner inner = new MethodInner();
		inner.print();
	}

}
