import java.util.LinkedList;

public class MyBuffer {
	
	private LinkedList<String> list;
	private int size;
	
	public MyBuffer(int size) {
		list=new LinkedList<String>();
		this.size=size;
	}
	
	public void addWords(String word){
			list.add(word);
	}
	public String getWord() {
		return list.getLast();
	}
	public void removeWord(String word) {
		 list.remove(word);
	}
	public LinkedList<String> getList() {
		return list;
	}
	public int listMaxSize() {
		return size;
	}
	

}
