package day4.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import day3.java8.StreamsDemo;

public class StreamDemo {

	public static void main(String[] args) {
		demo();
	}
	
	private static void demo() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
		//find the double of first even number that is greater than 3
		int result = 0;
		for (Integer integer : numbers) {
			if(integer > 3 && integer % 2 ==0) {
				result = integer * 2;
				break;
			}
		}
		System.out.println(result);
		//Intermediate Operation and Terminal Opeartion
		Optional<Integer> o = numbers.stream()
						.filter(e -> e > 3)
						.filter(e -> e%2 ==0)
						.map(e -> e*2)
						.findFirst();
		System.out.println(o.get());
		
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
