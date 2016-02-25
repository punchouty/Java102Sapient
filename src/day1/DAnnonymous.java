package day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DAnnonymous {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("Rajan");
		names.add("Punchouty");
		names.add("Ajay");
		names.add("Anil");
		for (String string : names) {
			System.out.println(string);
		}
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("-------------------");
		for (String string : names) {
			System.out.println(string);
		}
	}

}
