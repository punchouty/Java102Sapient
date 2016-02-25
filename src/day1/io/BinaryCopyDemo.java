package day1.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryCopyDemo {

	public static void main(String[] args) throws IOException {
		File original = new File("data/original.jpg");
		File copy = new File("data/copy.jpg");
		FileInputStream fis = new FileInputStream(original);
		FileOutputStream fos = new FileOutputStream(copy);
		
		int c = 0;
		while((c = fis.read()) != -1) {
			fos.write(c);
		}
		
		fis.close();
		fos.close();
	}

}
