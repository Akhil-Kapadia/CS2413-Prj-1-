package HtmlToText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Reads html sample file and stores it in string "Data"
public class readHtml {
	public static List<String> rawData = new LinkedList<String>();
	//Will read and input everything from html_Sample.html into string Data.
	private static void readFile() {
		String aLine;
		//Catches the error thrown when html sample file is not named correctly.
		try {
		      File myHTML = new File("htmlSample.html");
		      Scanner myReader = new Scanner(myHTML);
		      while (myReader.hasNextLine())
		        {
		            aLine = myReader.nextLine();
		            rawData.add(aLine);
		            System.out.println(aLine);
		        } 
		    
		    	myReader.close();
		        
		    File outFile = new File("output.txt");
		    PrintStream output = new PrintStream (outFile);
		    
		    Iterator itr = rawData.iterator();
		    
		    while (itr.hasNext())
		            output.println(itr.next());
		    output.close();
		    
		   
		
//		      if (myReader.hasNextLine()) {
//		  		System.out.println("Beginning conversion please wait.");
//		      }
//		      while (myReader.hasNextLine()) {
//		        rawData.add(myReader.nextLine());
//		      }
		myReader.close();   
		}catch (FileNotFoundException e) {
			System.out.println("File Not Found. Make sure file is named htmlSample.html");
			e.printStackTrace();
		}
	}
	//Length of list
	public int listLength() {
		return rawData.size();
	}
	
	//Returns next line of list as a string.
	public String getLine(int index)
	{
		return rawData.get(index);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Reading html from file htmlSample.html");
		readFile();
	}

}
