package day2;

import java.util.Scanner;

public class EnumDemo2 {
	
	public enum Country {
		INDIA("Delhi"),
		US("Washington DC"),
		UK("London"),
		JAPAN("Tokyo");
		
		private String capital;
		
		private Country(String capital) {
			this.capital = capital;
		}
		
		public String getCapital() {
			return capital;
		}
	}
	

	public static void main(String[] args) {
		Country country = Country.INDIA;
		System.out.println(country.getCapital());
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String countryName = scanner.next();
			if(countryName.equalsIgnoreCase("exit")) {
				System.out.println("Exiting....");
			}
			else {
				try {
					Country temp = Country.valueOf(countryName);
					System.out.println(temp.capital);
				} catch (Exception e) {
					System.out.println("Country not found");;
				}
			}
		}
		scanner.close();
	}

}
