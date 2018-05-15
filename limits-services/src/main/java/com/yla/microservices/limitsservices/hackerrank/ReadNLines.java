package com.yla.microservices.limitsservices.hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ReadNLines {
	

	    public static void main(String[] args) {
	    	List<String> enteredItems = new ArrayList<String>();
	        Scanner in = new Scanner(System.in);
	        String t = in.nextLine();
	        enteredItems.add(t);
	        //comment1
	         while(in.hasNextLine()) {
	        	  t = in.nextLine();
	        	  enteredItems.add(t);
	        	  if (t.endsWith("end-of-file.")) {
	        		  break;
	        	  }
	         }
	         //comment2
	         
	         int n=1;
	         for (String s : enteredItems) {
	        	 System.out.println(n+" "+s);
                 n++;
				
			}
	    }

}
