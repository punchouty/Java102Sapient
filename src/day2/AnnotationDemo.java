package day2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import day2.TODO.Severity;

public class AnnotationDemo {
	
	public static void main(String[] args) {
		Method [] methods = Temp.class.getMethods();
		for (Method method : methods) {
			TODO todo = method.getAnnotation(TODO.class);
			if(todo != null) {
				System.out.println("TODO - Severity : " + todo.severity() + ", item : " +todo.item() + ", assignedTo : " + todo.assignedTo());
			}
		}
	}

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TODO {
	public enum Severity {
		LOW, MEDIUM, HIGH
	}
	
	Severity severity();
	String item();
	String assignedTo();
}

class Temp {

	@Override
	@TODO(severity= Severity.HIGH, item="Implement toString Method", assignedTo="Rajan")
	public String toString() {
		return null;
	}
	
	private String someVariable;
	
	public String getSomeVariable() {
		return someVariable;
	}

	public void setSomeVariable(String someVariable) {
		this.someVariable = someVariable;
	}
}
