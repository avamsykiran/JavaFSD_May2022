package in.tp.jsedemo.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ReadingTextFilesDemoApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("FileName: ");
		String fileName = scan.next();
		
		Path filePath = Paths.get(fileName);
	
		if(Files.notExists(filePath)) {
			System.out.println("No Such file found");
		}else {
			try {
				List<String> lines =  Files.readAllLines(filePath);
				for(String line : lines)
					System.out.println(line);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
