package Model;

public class LigneFacture {
	

	private int numero;
	private float prix;
	private String prod;
	private int quantite;
	
	
	public LigneFacture(float prix, String  prod, int quantite , int numero) {
		this.numero = numero;
		this.prix = prix;
		this.prod = prod;
		this.quantite = quantite;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getProd() {
		return prod;
	}
	public void setProd(String prod) {
		this.prod = prod;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "LigneFacture [prix=" + prix + ", prod=" + prod + ", quantite=" + quantite + "]";
	}
	
		
}
