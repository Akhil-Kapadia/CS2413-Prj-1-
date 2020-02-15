package HtmlToText;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanUp {

	private static List<String> cleaned = new LinkedList<String>();
	
	private static String Parser(String Current) 
	{
		String Clean;
		Pattern replacer = Pattern.compile("<\\w+>");
		Matcher match = replacer.matcher(Current);
		Clean = match.replaceAll("\n");
	//	Clean = Current.replaceAll("<(\\w+)>", "\n"); 
	
		return Clean;
	}
	
	public int ListLength()
	{
		return cleaned.size();
	}
	
	public String Cleaned(int Index)
	{
		return cleaned.get(Index);
	}
	
	private static void main(String[] args)
	{
		readHtml htmlList = new readHtml(); 
		int Length = htmlList.listLength();
		int count = 0;
		String Current;
		//Goes line by line of list. 
		while( count < Length)
		{
			Current = htmlList.getLine(count);
		//	cleaned.add(Parser(Current));
			System.out.println(Parser(Current));
		}
		
	}
}
