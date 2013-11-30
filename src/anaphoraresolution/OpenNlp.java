package anaphoraresolution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.Span;


public class OpenNlp {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public String[] main1(String[] sentence) throws FileNotFoundException {
		
		int count=0;
                //System.out.println("\n\n\n");
		for(int i=0;i<sentence.length;i++)
                {
                    //System.out.println("sentence : "+sentence[i]);
                }
                for(int i=0;i<sentence.length;i++)
		{
                    if(sentence[i]=="" || sentence[i] == null)
                        continue;
                    String s[] = sentence[i].split(" ");
                    count += s.length;
		}
		
                
		String[] st=new String[count];
		
                
                int j=0;
		for(	int i=0;i<sentence.length;i++)
		{
                    if(sentence[i] == null)
                        continue;
                    String s[]  = sentence[i].split(" ");
			for(int k=0;k<s.length;k++)
			{
				st[j++]=new String(s[k]);
			}
			//st  += sentence[i].split(" ");
		}
		
                for(int i=0;i<st.length;i++)
                {
                    System.out.println(st[i]);
                }
                
                System.out.println("\n\n\n\n\n\n"+"sdfsdfsdfsdfsdfsdfsdfsdfsdfkjsdnfksjdnf");
			//String[] sen =
		String st1[] = new OpenNlp().run(st);
		return st1;
	}

	
	public String[] run(String sentence[]) throws FileNotFoundException
	{
		InputStream modelIn = new FileInputStream("lib/en-ner-organization.bin");
		TokenNameFinderModel model = null;
		try {
		  model = new TokenNameFinderModel(modelIn);
		}
		catch (IOException e) {
		  e.printStackTrace();
		}
		finally {
		  if (modelIn != null) {
		    try {
		      modelIn.close();
		    }
		    catch (IOException e) {
		    }
		  }
		}
		
		NameFinderME nameFinder = new NameFinderME(model);
		
		Span nameSpans[] = nameFinder.find(sentence);
		String ans[] = new String[nameSpans.length];
                int count=0;
                
                try{
                if(nameSpans.length>0)
		{
                    System.out.println("Span : "+nameSpans[0]);
                    String str = nameSpans[0].toString();
                    for(int k=Integer.parseInt(Character.toString(str.charAt(1)));k<Integer.parseInt(Character.toString(str.charAt(4)));k++)
                    {
                        ans[count++]= sentence[k];
                    }
		}
                return ans;
                }
                catch(Exception e)
                {
                    System.out.println("Exception : "+e);
                    
                }
            
                return null;
                
                
	}
}