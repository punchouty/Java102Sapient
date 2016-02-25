package day3.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Immutability
 * Intermediate and Terminal Function
 * Performance
 * @author rpunch
 *
 */
public class StreamsDemo {

	public static void main(String[] args) {
		moreComplex();
	}

	private static void basicLambdas() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}

		for (Integer integer : numbers) {
			System.out.println(integer);
		}

		numbers.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);

			}
		}); // simple, concurrent, lazy

		numbers.forEach((Integer value) -> System.out.println(value));

		numbers.forEach(value -> System.out.println(value));

		numbers.forEach(System.out::println);
	}

	private static void simpleStream() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

		// double and sum
		int result = 0;
		for (Integer integer : numbers) {
			result += integer * 2;
		}
		System.out.println(result);

		// Immutable
		result = numbers.stream().map(e -> e * 2).reduce(0, (c, e) -> c + e);
		System.out.println(result);
	}

	private static void moreComplex() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
		//find the double of first even number that is greater than 3
		int result = 0;
		for (Integer integer : numbers) {
			if(integer > 3 && integer % 2 ==0) {
				result = integer * 2;
				break;
			}
		}
//		System.out.println(result);
		//Intermediate Operation and Terminal Opeartion
		Optional<Integer> o = null;
//		o = numbers.stream()
//						.filter(e -> e > 3)
//						.filter(e -> e%2 ==0)
//						.map(e -> e*2)
//						.findFirst();
//		System.out.println(o.get());
		
		o = numbers.stream()
				.filter(StreamsDemo::isGtThan3)
				.filter(StreamsDemo::isEven)
				.map(StreamsDemo::doubleIt)
				.findFirst();
		System.out.println(o.get());
	}

	public static boolean isGtThan3(int i) {
		System.out.println("isGtThan3 : i = " + i + " i > 3 : " + (i > 3));
		return i > 3;
	}

	public static boolean isEven(int i) {
		System.out.println("isEven : i = " + i + " i % 2 : " + (i % 2 == 0));
		return i % 2 == 0;
	}

	public static int doubleIt(int i) {
		System.out.println("doubleIt : i = " + i + " 2 * i : " + (2 * i));
		return 2 * i;
	}

}
