package day1.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadDemo {

	public static void main(String[] args) throws IOException {
		String srcFile = "src/day1/io/ReadDemo.java";
		File file = new File(srcFile);
		if(file.exists()) {
		    BufferedReader br = new BufferedReader(new FileReader(srcFile));
		    String text = null;
	
		    while ((text = br.readLine()) != null) {
		      System.out.println(text);
		    }
		    br.close();
		}
	}

}
