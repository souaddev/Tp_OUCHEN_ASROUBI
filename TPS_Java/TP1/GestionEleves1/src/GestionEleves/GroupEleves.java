package GestionEleves;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GroupEleves {
	private ArrayList<Eleve> listEleves;
	
	public GroupEleves() {
		this.listEleves=new ArrayList<Eleve>();
	}
	
	public int nombre() {
		return listEleves.size();
	}

	public List<Eleve> getListe(){
		return listEleves;
	}
	
	public void ajouterElevee(Eleve eleve) {
		listEleves.add(eleve);
	}
	
	public Eleve chercher(String nom) {
		for(Eleve i : listEleves) {
			if(i.getNom()==nom){
				return i;
			}
		}
		return null;
	}
	
	public void lister() {
		for(Eleve i : listEleves) {
			System.out.println(i.toString());
		}
	}
	
	public Eleve meilleurEleve(){
		return Collections.max(listEleves);
	}
	
	public void trierEleves() {	
		Iterator<Eleve> it=listEleves.iterator();
		System.out.println("La liste des eleves selon l'ordre croissant des moyennes des élèves : ");
		Collections.sort(listEleves);
		it=listEleves.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
