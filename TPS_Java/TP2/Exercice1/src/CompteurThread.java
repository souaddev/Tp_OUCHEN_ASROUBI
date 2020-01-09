//Exercice 1 question 2 avec Thread :
public class CompteurThread extends Thread{
	int deb; 
	   int fin;
	   boolean incr;
	   String name;
	   
	   public CompteurThread(int deb,int fin,boolean incr,String name) {
		   this.deb=deb;
		   this.fin=fin;
		   this.incr=incr;
		   this.name=name;
	   }

	   public void run() {
	       
	        try {
	            while(incr && deb <= fin) {
	                System.out.println(deb+" "+name);
	                deb++;
	                Thread.sleep(10);
	            }
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	    
	    while(!incr  && fin>=deb) {
	        System.out.println(fin+" "+name);
	        fin--;
	        try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    
	    }
	   }
	   
	 public static void main(String[] args) {
		 new CompteurThread(1,100,true,"TA").start();
		 new CompteurThread(1,100,false,"TB").start();  	       
	    }
	
}
