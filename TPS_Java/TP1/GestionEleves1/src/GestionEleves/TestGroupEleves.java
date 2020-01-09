package GestionEleves;

import java.util.ArrayList;

public class TestGroupEleves {

	public static void main(String[] args) {
		
		Eleve eleve1=new Eleve("souad");
		eleve1.ajouterNote(13);
		eleve1.ajouterNote(16);
		eleve1.ajouterNote(12);

		Eleve eleve2=new Eleve("hassna");
		eleve2.ajouterNote(10);
		eleve2.ajouterNote(18);
		eleve2.ajouterNote(15);
		
		Eleve eleve3=new Eleve("Houssam");
		eleve3.ajouterNote(16);
		eleve3.ajouterNote(12);
		eleve3.ajouterNote(19);
		
		Eleve eleve4=new Eleve("Mohammed");
		eleve4.ajouterNote(17);
		eleve4.ajouterNote(17);
		eleve4.ajouterNote(11);
		
		GroupEleves group=new GroupEleves();
		group.ajouterElevee(eleve1);
		group.ajouterElevee(eleve2);
		group.ajouterElevee(eleve3);
		
		//Chercher un eleve
		System.out.println(group.chercher("Houssam")+"\n");
		
		//Ajouter un eleve
		group.ajouterElevee(eleve4);
		
		//Lister les eleves apres l'ajout
		group.lister();
		
		//Le nombre des eleves dans le group
		System.out.println("Le nombre des eleves dand le group est : "+group.nombre()+"\n");
		
		//L'eleve avec la grande moyenne
		System.out.println("L'eleve avec la grande moyenne est : "+group.meilleurEleve());
		
		//La liste des eleves trier par la moyenne en ordre croissant
		group.trierEleves();
	}

}
