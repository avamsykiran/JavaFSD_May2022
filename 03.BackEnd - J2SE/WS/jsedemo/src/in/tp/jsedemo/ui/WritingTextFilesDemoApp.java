package in.tp.jsedemo.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WritingTextFilesDemoApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		final String Data_DIR = "./data";
		
		Path dirPAth = Paths.get(Data_DIR);
		
		if(Files.notExists(dirPAth)) {
			try {
				Files.createDirectories(dirPAth);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		
		System.out.println("FileName: ");
		String fileName = scan.next();
		
		Path filePath = Paths.get(Data_DIR, fileName);
		
		System.out.println("Enter data into fiel use '**STOP**' to end inputting: ");
		
		List<String> lines = new ArrayList<>();
		String line=null;
		while(!"**STOP**".equals(line)) {
			line = scan.nextLine();
			lines.add(line);
		}
		
		try {
			Files.write(filePath, lines);
			System.out.println("Data Saved");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
