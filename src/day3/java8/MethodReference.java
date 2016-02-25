package day3.java8;

import java.util.function.Predicate;

public class MethodReference {
	
	private static int i =100;

	public static boolean isPrime(Integer number) {
        if(number == 1 ){
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false; 
            }
        }
        return true; 
    }
	
	public static boolean isEven(Integer i) {
		return i%2 == 0;
	}
	
	public static void main(String[] args) {
		Predicate<Integer> p = MethodReference::isPrime;
		System.out.println(p.getClass());
		System.out.println(p.test(7));
		System.out.println(p.test(10));
		p = MethodReference::isEven;
		System.out.println(p.test(10));
		doSomething(MethodReference::isEven);
	}

	private static void doSomething(Predicate<Integer> p) {
		p.test(i);
	}
}
