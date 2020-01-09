
public class Ajob implements Runnable {
	Valeur myVal;
	int i;
	
	public Ajob(Valeur myVal, int i) {
		this.myVal=myVal;
		this.i=i;
	}
	
	public void run() {
		
		for(int j=0;j<Math.pow(10,6);j++) {
			myVal.add(i);
			System.out.println(myVal.toString());
		}	
	}
}
