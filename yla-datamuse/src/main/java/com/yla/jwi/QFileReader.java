package com.yla.jwi;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;



public class QFileReader {
	
	String error= "";

	public int readFile(String fileName) {
		// TODO Auto-generated method stub
		//returns the number of lines
		int x =5;
		
		try {
			
			Stream<String>   stream = Files.lines(Paths.get(fileName));
			
			//stream.forEach(System.out::println);
			stream.forEach (line -> printLine(line));
			x=1;
			
		}
		
		catch (Exception e) {
			error = e.toString();
			e.printStackTrace();
		}
		
		return x;
		
	}
	
	private void  printLine(String  line) {
		System.out.println(line);
	}

}
