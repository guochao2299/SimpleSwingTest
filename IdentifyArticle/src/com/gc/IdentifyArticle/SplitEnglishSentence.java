package com.gc.IdentifyArticle;
import java.util.ArrayList;

public class SplitEnglishSentence implements IIdentifyArticle
{
	public String[] IdentifyArticle(String englishSentence)
	{
		if(englishSentence.isEmpty())
		{
			return new String[0];
		}
		
		ArrayList<String> result=new ArrayList<String>();
		String[] splitedResult=englishSentence.split(" ");
		for(String s :splitedResult)
		{
			if(s.equalsIgnoreCase("a"))
			{
				result.add("a");
			}
			else if(s.equalsIgnoreCase("an"))
			{
				result.add("an");
			}
			else if(s.equalsIgnoreCase("the"))
			{
				result.add("the");
			}				
		}
		
		return result.size()>0?result.toArray(new String[0]):new String[0];				
	}
}
