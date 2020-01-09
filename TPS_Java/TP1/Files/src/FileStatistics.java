import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FileStatistics {
 
	String filename;
	File file;
    FileInputStream fileStream;
    BufferedReader reader;
    InputStreamReader input;
    String line;
    
	public FileStatistics(String filename) {
		this.filename=filename;
		file = new File(filename+ ".txt"); 
	}
	
	public void readerfileRefresh() throws FileNotFoundException {
		fileStream = new FileInputStream(file);
		input = new InputStreamReader(fileStream);
		reader = new BufferedReader(input);
	}
	
	public int getCharCount() throws IOException {
		String line; 
		int characterCount = 0;
		readerfileRefresh();
		 while((line = reader.readLine()) != null) 
		    {    
		     if(!(line.equals(""))) 
		        { 
		    	 characterCount += line.length(); 
		        } 
	    }
		 return characterCount;
	}
	
	public int getWordCount() throws IOException {
		String line; 
		int wordCount = 0;
		readerfileRefresh();
		 while((line = reader.readLine()) != null) 
		    {    
		     if(!(line.equals(""))) 
		        { 
		    	 String[] wordList = line.split("\\s+"); 
		    	 wordCount += wordList.length;  
		        } 
	    }
		 return wordCount;
	}
	
	public int getSentanceCount() throws IOException {
		String line; 
		int sentanceCount = 0;
		readerfileRefresh();
		 while((line = reader.readLine()) != null) 
		    {    
		     if(!(line.equals(""))) 
		        { 
		    	   String[] sentenceList = line.split("[!?.:]+"); 		              
		            sentanceCount += sentenceList.length; 
		        } 
	    }
		 return sentanceCount;
	}
	
	public int getParagrapheCount() throws IOException {
		String line; 
		int paragrapheCount = 1;
		readerfileRefresh();
		 while((line = reader.readLine()) != null) 
		    {    
			 if(line.equals("")) 
		        { 
				 paragrapheCount++; 
		        } 
	    }
		 return paragrapheCount;
	}
	
	public void saveCounts(String filename) throws IOException {
		File fichier = new File(filename+ ".txt"); 
		FileWriter fw;
		String text="-Total word count = " + this.getWordCount()+ "\r\n-Total number of characters = " + this.getCharCount() +"\r\n-Total number of sentences = " 
		+ this.getSentanceCount()+"\r\n-Number of paragraphs = " + this.getParagrapheCount()+"\r\n";
		fw=new FileWriter(fichier);
		fw.write(text);
		fw.close();
		
	}
	
	public void getDictionary() throws IOException {
		HashMap<String,Integer> wordsCounts = new  HashMap<String,Integer> ();;
		String line; 
		String[] wordList = null ;
		readerfileRefresh();
		 while((line = reader.readLine()) != null) 
		    {    
		     if(!(line.equals(""))) 
		        { 
		    	 wordList = line.split("\\s+");  
		        } 
	    }
		for(String i: wordList) {
			if(wordsCounts.containsKey(i)) {
				int value=wordsCounts.get(i);
				value++;
				wordsCounts.replace(i,value);
			}
			else
			{
				wordsCounts.put(i,1);
			}
		 }
		FileWriter fw=new FileWriter(new File("dictionnaire.txt"));
		String text="";
		for(String i : wordsCounts.keySet()) {
			text+="cle : "+i+" => valeur : "+wordsCounts.get(i)+"\r\n";
		}
		fw.write(text);
		fw.close();
	}
	
public static void main(String[] args) throws IOException  {
	
	FileStatistics file=new FileStatistics("MonFichier");
      
    System.out.println("Total word count = " + file.getWordCount()); 
    System.out.println("Total number of characters = " + file.getCharCount());
    System.out.println("Total number of sentences = " + file.getSentanceCount()); 
    System.out.println("Number of paragraphs = " + file.getParagrapheCount()); 
    
    file.saveCounts("FichierResultat");
    
    file.getDictionary();

	} 
   
}


