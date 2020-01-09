
public class Voiture {
	private static int count =0;
	private int id;
	
	public Voiture(int id) {
		id=++count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String toString() {
		return "Voiture id : "+id;
	}

}
