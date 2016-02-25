package day2;

public class GenericDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static <T>  T getMiddle(T[] elements) {
		return elements[elements.length/2];
	}

}
