package day2;

import java.util.EnumSet;

public class EnumDemo3 {
	
	public enum Operation {
		
		ADD {

			@Override
			public int calculate(int a, int b) {
				return a+b;
			}
			
		},
		SUBTRACT {

			@Override
			public int calculate(int a, int b) {
				return a-b;
			}
			
		},
		MULTIPLY {

			@Override
			public int calculate(int a, int b) {
				return a*b;
			}
			
		};
		
		public abstract int calculate(int a, int b);
	}

	public static void main(String[] args) {
		Operation operation = Operation.ADD;
		int value = operation.calculate(1, 3);
		System.out.println(value);
		
		EnumSet<Operation> enums = EnumSet.of(Operation.ADD, Operation.SUBTRACT);
		for (Operation operation2 : enums) {
			System.out.println(operation2);
			
		}
		enums = EnumSet.allOf(Operation.class);
		for (Operation operation2 : enums) {
			System.out.println(operation2);
			
		}
	}

}
