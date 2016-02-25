package day2;

import day2.EnumDemo.IcecreamFlavor;

public class EnumDemo {
	
	public enum IcecreamFlavor {
		VANILLA, STRABERRY, BUTTERSCOTCH
	}
	
	public static void main(String[] args) {
		new Icecream(IcecreamFlavor.VANILLA);
		IcecreamFlavor flavor = IcecreamFlavor.valueOf("VANILLA");
		System.out.println(flavor.toString());
		System.out.println(flavor == IcecreamFlavor.VANILLA);
		IcecreamFlavor [] flavors = IcecreamFlavor.values();
	}

}

class Icecream {
	
	private IcecreamFlavor flavor;
	
	public Icecream(IcecreamFlavor flavor) {
		this.flavor = flavor;
		System.out.println(flavor.getClass().getSuperclass());
	}
}
