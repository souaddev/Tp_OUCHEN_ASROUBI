import java.util.ArrayList;

public class Parking{
	private int nbr;
	private ArrayList<Voiture> listeVoitures;
	
	public Parking(int nbr) {
		this.nbr=nbr;
		listeVoitures=new ArrayList<Voiture>();
	}
	
	public int getNbr() {
		return nbr;
	}
	
	public void setNbr(int nbr) {
		this.nbr=nbr;
	}
	
	public ArrayList<Voiture> getListeVoitures() {
		return listeVoitures;
	}
	
	public void setListeVoiture(ArrayList<Voiture> listeVoitures) {
		this.listeVoitures=listeVoitures;
	}
	
	public synchronized boolean enter(Voiture v) throws InterruptedException {
		if(listeVoitures.size()<nbr) {
			listeVoitures.add(v);
			System.out.format("[Parking] :%s acceptée \n", v);
			System.out.format("Voiture Garees\n");
			System.out.println(listeVoitures);
			return true;
		}else {
			System.out.format("Parking est plein %s en attend \n", v);
			v.wait();
			return false;	
		}		
	}
	
	public void quitter(Voiture v) {
		listeVoitures.remove(v);
		v.notify();
		System.out.format("Parking :[%s] est sortie \n", v);
	}

}
