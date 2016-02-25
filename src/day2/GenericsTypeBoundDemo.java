package day2;

import java.util.ArrayList;
import java.util.List;

public class GenericsTypeBoundDemo {
	
	//Producer Extends, Consumer Super

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
		
		Object [] ao = new Object[10];
		ao = new Integer[10];
		extendsKeyword();
		
		superKeyword();
		List<?> list = new ArrayList<>();
		Object o = list.get(0);
	}

	private static void superKeyword() {
		Number myNumber = null;
		Integer myInteger = null;
		Double myDouble = null;
		Object myObject = null;
		myNumber = myInteger;//Correct
		
		List<? super Integer> ints = new ArrayList<Integer>();  // Integer is a "superclass" of Integer (in this context)
		List<? super Integer> nums = new ArrayList<Number>();   // Number is a superclass of Integer
		List<? super Integer> objs = new ArrayList<Object>();   // Object is a superclass of Integer
		objs = ints;
		ints = objs;
		
		myObject = ints.get(0);
		
		ints.add(myInteger);//Or any other subclass of Integer
		nums.add(myInteger);//Or any other subclass of Integer
		objs.add(myInteger);//Or any other subclass of Integer
//		ints.add(myNumber);
//		nums.add(myNumber);
//		objs.add(myNumber);
	}

	private static void extendsKeyword() {
		Number myNumber = null;
		Integer myInteger = null;
		Double myDouble = null;
		myNumber = myInteger;//Correct
		List<Number> nums = new ArrayList<Number>();
		List<Integer> ints = new ArrayList<>();
		//ints = nums; //Error
		//nums = ints;//Error
		List<? extends Number> numbers = new ArrayList<Number>();  // Number "extends" Number (in this context)
		List<? extends Number> integers = new ArrayList<Integer>(); // Integer extends Number
		List<? extends Number> doubles = new ArrayList<Double>();  // Double extends Number
		myNumber = numbers.get(0);//Correct
		myNumber = integers.get(0);
		myNumber = doubles.get(0);
		//Integer myInteger = numbers.get(0);//Error
		//Double myDouble = numbers.get(0);//Error
		
		//numbers.add(myNumber);//Error
		//numbers.add(myInteger);//Error
		//numbers.add(myDouble);//Error
		//doubles.add(myNumber);//Error
	}
	
	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
	      for (int i=0; i<src.size(); i++) 
	        dest.set(i,src.get(i)); 
	} 
	
	public void printStuff(Iterable<?> stuff) {
	  for (Object item : stuff) {
	    System.out.println(item);
	  }
	}

}

