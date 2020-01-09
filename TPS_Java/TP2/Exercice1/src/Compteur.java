public class Compteur implements Runnable{

   int deb; 
   int fin;
   boolean incr;
   String name;
   
   public Compteur(int deb,int fin,boolean incr,String name) {
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
    	Runnable compte1=new Compteur(1,100,true,"TA");
    	Runnable compte2=new Compteur(1,100,false,"TB");
    	
        new Thread(compte1).start();  
        new Thread(compte2).start();  
       
    }
}
