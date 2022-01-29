package Model;

public class Produit {
	private String libelle;
	private float prix;
	private String referance;
	private boolean etat;

	public Produit(String libelle, float prix, String referance, boolean etat) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.referance = referance;
		this.etat = etat;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getReferance() {
		return referance;
	}
	public void setReferance(String referance) {
		this.referance = referance;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (etat != other.etat)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (Float.floatToIntBits(prix) != Float.floatToIntBits(other.prix))
			return false;
		if (referance == null) {
			if (other.referance != null)
				return false;
		} else if (!referance.equals(other.referance))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Produit [libelle=" + libelle + ", prix=" + prix + ", referance=" + referance + ", etat=" + etat + "]";
	}

}