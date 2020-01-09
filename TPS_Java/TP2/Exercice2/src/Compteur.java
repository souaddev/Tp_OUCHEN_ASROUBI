public class Compteur implements Runnable{

	 String nom;
	 int maxValue; 
	 
	 public Compteur(String nom, int maxValue) {
		   this.nom=nom;
		   this.maxValue=maxValue;	
	   }
	 
	  public void run() {
	       int valeur=1;
	        try {
	            while(valeur <= maxValue) {
	                
	                System.out.println(nom+" => "+valeur);
	                valeur++;
	                Thread.sleep(100);
	            }
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	  }
	 				
	public static void main(String[] args) {
		Runnable compte1=new Compteur("Thread A ",100);
    	Runnable compte2=new Compteur("Thread B ",200);
    	
        new Thread(compte1).start();  
        new Thread(compte2).start();
        
        System.out.println("Oui , L’affichage sur la sortie standard est déterministe");

	}
}
