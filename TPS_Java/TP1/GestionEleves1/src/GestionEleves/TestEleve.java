package GestionEleves;

public class TestEleve {
	
	public static void main(String[] args) {
		
		Eleve eleve1=new Eleve("souad");
		eleve1.ajouterNote(13);
		eleve1.ajouterNote(17);
		eleve1.ajouterNote(15);
		eleve1.ajouterNote(19);
		
		System.out.println(eleve1);

	}

}
