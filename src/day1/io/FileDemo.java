package day1.io;

import java.io.File;

public class FileDemo {

	/**
	 * delete, create, rename
	 * @param args
	 */
	public static void main(String[] args) {
		File folder = new File("src/day1");
		System.out.println(folder.getAbsolutePath());
		if(folder.isDirectory() && folder.exists()) {
			System.out.println("Exist");
			File [] files = folder.listFiles();
			for (File file : files) {
				System.out.println(file.getAbsolutePath());
			}
		}
		else {
			System.out.println("Don't Exist");
		}
	}

}
