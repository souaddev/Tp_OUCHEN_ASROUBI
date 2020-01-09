import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class Lecteur extends Thread{
	private String fileName;
	private String threadName;
	private MyBuffer buff;

	public Lecteur(String threadName,String fileName,MyBuffer buff) {
		 this.fileName=fileName;
		 this.threadName=threadName;
		 this.buff=buff;
	}
	
	public void run() {
		System.out.println(threadName+" is in proccess");
		try {
			readWord();
			sleep(100);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public void readWord() throws InterruptedException  {
		File fichier;
		FileReader fr;
		BufferedReader reader;
		String[] wordsTab=null;
		ArrayList <String> words = new ArrayList<String>();
					
			try {
				fichier=new File(fileName+".txt");
				fr = new FileReader(fichier);
				reader=new BufferedReader(fr);
				String line;
				
				while((line=reader.readLine())!=null) {
					wordsTab=line.split("[\\s?!?,.:]+");
				}
				for(String i : wordsTab) {
					words.add(i);
					System.out.println(i+" -------- to words list");
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		while(true) {
			System.out.println("true");
			synchronized(this) {
				while(buff.getList().size()==(buff.listMaxSize())){
					System.out.println("buffer is full wait.... ");
					wait();
				}
				for(String i:words) {
				 buff.addWords(i);
				 System.out.println(i+" : have been added to the buffer");
			//	 words.remove(i);
			//	 System.out.println(i+" : have been removed from  the tab");
				 
				 notify();
				}
			}
		}
	}

}
