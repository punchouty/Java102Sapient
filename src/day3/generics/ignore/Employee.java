package day3.generics.ignore;

public class Employee extends Person {
	public Employee(final String name, final int age) {
		super(name, age);
	}

	@Override
	public String toString() {
		return "Employee{" + "name='" + getName() + '\'' + ", age=" + getAge() + '}';
	}
}