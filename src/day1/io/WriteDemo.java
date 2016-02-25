package day1.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDemo {

	public static void main(String[] args) throws IOException {
		String srcFile = "data/out.txt";
		File file = new File(srcFile);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.append("test");
			bw.newLine();
			bw.append("test1");
			bw.newLine();
			bw.append("test2");
			bw.newLine();
			bw.append("test3");
			bw.flush();
		} finally {
			bw.close();
		}
	}

}
