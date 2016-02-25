package day3.java8;

public class DefaultMethod {

}

interface MyInterface {
	
	public void doSomething();
	
	default public void doSomethingElse() {
		System.out.println("In side doSomething");
	}
}

class MyClass implements MyInterface {

	@Override
	public void doSomething() {
		System.out.println("In side doSomething");
	}
	
}

class MyAnotherClass implements MyInterface {

	@Override
	public void doSomething() {
		System.out.println("In side doSomething");
	}
	
	@Override
	public void doSomethingElse() {
		System.out.println("In side doSomething of MyAnotherClass");
	}
	
}