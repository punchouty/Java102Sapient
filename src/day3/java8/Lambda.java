package day3.java8;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Lambda {

	public static void main(String[] args) {
		Runnable noArgs = () -> System.out.println();
		ActionListener oneArgument = event -> System.out.println("button clicked");
		Runnable multiStatementd = () -> {
			System.out.println("1");
			System.out.println("2");
		};
		
		BinaryOperator<Integer> add = (x,y) -> x+y;
		System.out.println(add.apply(1, 2));
		
		Predicate<Integer> p = i -> i%2 == 0;
	}

}
