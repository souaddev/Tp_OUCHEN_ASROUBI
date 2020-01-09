
public class Valeur{
	private int valeur;
	public Valeur(int vleur)
	{
		this.valeur=vleur;
	}
	public int getVal()
	{
		return this.valeur;
	}
	public synchronized void add(int i)
	{
		valeur+=i;
	}
	public String toString()
	{
		return "valeur "+this.getVal();
	}
}
