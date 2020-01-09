public class TestOrder {
	
	public static void main(String[] args) {
		Runnable compte1=new Compteur("Thread A ",100);
    	Runnable compte2=new Compteur("Thread B ",200);
    	Runnable compte3=new Compteur("Thread C ",1000);
    	Runnable compte4=new Compteur("Thread D ",600);
    	
        new Thread(compte1).start();  
        new Thread(compte2).start();
        new Thread(compte3).start();  
        new Thread(compte4).start();

	}

}
