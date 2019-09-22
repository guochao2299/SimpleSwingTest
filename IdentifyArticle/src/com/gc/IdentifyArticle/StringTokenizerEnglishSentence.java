package com.gc.IdentifyArticle;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class StringTokenizerEnglishSentence implements IIdentifyArticle
{
	public String[] IdentifyArticle(String englishSentence)
	{
		if(englishSentence.isEmpty())
		{
			return new String[0];
		}
		
		List<String> result=new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(englishSentence," ,?.!:\"\"''\n#");
		List<String> wordList = new ArrayList<>();
		
		while (st.hasMoreElements())
		{
		    String s=st.nextToken().toLowerCase();
		    
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
