package day3.java8;

import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesType {
	
	public boolean isNull(Object obj) {
		System.out.println("isNull");
		return obj == null;
	}
	
	public String convertToString(Integer i) {
		System.out.println("convert");
		return "Integer : " + i;
	}
	
	public Date currentTime() {
		System.out.println("currentTime");
		return new Date();
	}
	
	public boolean isStringLengthLarge(String str, int size) {
		if(str.length() >= size) return true;
		else return false;
	}
	
	public void print(String str) {
		System.out.println("print");
		System.out.println(str);
	}

	public static void main(String[] args) {
		FunctionalInterfacesType obj = new FunctionalInterfacesType();
		
		Consumer<String> c = obj::print;
		c.accept("Rajan");
		c = System.out::println;
		
		Predicate<Object> p = obj::isNull;
		p.test(null);
		
		Function<Integer, String> f = obj::convertToString;
		String str = f.apply(3);
		System.out.println(str);
		
		Supplier<Date> s = obj::currentTime;
		Date date = s.get();
		System.out.println(date);
		
		BiFunction<String, Integer, Boolean> b = obj::isStringLengthLarge;
		Boolean  result = b.apply("rajan", 4);
		System.out.println(result);

	}

}
