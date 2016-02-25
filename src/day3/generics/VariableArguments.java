package day3.generics;

public class VariableArguments {
	
	public static void doSomething(Integer... integers) {
		for (int i = 0; i < integers.length; i++) {
			System.out.println(integers[i]);
		}
	}
	
	public static void main(String[] args) {
		doSomething(3,7,2,9);
	}

}
