package GestionEleves;
import java.util.ArrayList;

public class Eleve implements Comparable<Object>{
		private String nom ;
		private ArrayList<Integer> note ; 
		private double moyenne;
		
	public Eleve() {
		this.nom=null;
		this.note=new ArrayList<Integer>();
		this.moyenne=0.0;		
	}
	
	public Eleve(String nom) {
		this.nom=nom;
		this.note=new ArrayList<Integer>();
	}
	
	public double getMoyenne()
	{
		int moy=0;
		for (int i : note) {
			moy += i;
		}
		return (double) moy / note.size();
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public void ajouterNote(int note1)
	{
		note.add(note1);
		this.moyenne=getMoyenne();
	}
	
	public String toString()
	{
		return "le nom : "+this.nom+" ,la moyenne : "+this.getMoyenne()+", les notes sont : "+this.note;
	}
	public ArrayList <Integer> getListesNotes()
	{
		return note;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o.getClass().equals(Eleve.class)) {
			Eleve e=(Eleve)o;
			if(this.moyenne==e.getMoyenne())
				return 0;
			else if(this.moyenne>e.getMoyenne())
				return 1;
		}
		return -1;
	}

}
