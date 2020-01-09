import java.util.HashMap;

public class Processor extends Thread{
	
	private MyBuffer buff;
	private String Pname;
	private HashMap<String,Integer> wordsCounts;
	
	public Processor( String Pname,MyBuffer buff) {
		this.Pname=Pname;
		this.buff=buff;
		wordsCounts=new  HashMap<String,Integer> ();
	}
	
	public void run() {
			try {
				sleep(200);
				System.out.println(Pname+" is in proccess");
				processe();
		
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getWordsCounts());
			
		}
		
	public synchronized void processe() throws InterruptedException {
		while(true) {
			synchronized(this) {
				while((buff.getList().size()==0)) {	
					System.out.println("Buffer is empty : wait....");
					wait();
				}
			}
				String word=buff.getWord();
				if(wordsCounts.containsKey(word)) {
					int value=wordsCounts.get(word);
					value++;
					wordsCounts.replace(word,value);
					buff.removeWord(word);
					notify();
				}
				else
				{
					wordsCounts.put(word,1);
					buff.removeWord(word);
					notify();
				}
			}
			
	}
	
	public HashMap<String,Integer> getWordsCounts(){
		return wordsCounts;
	}
	
}
